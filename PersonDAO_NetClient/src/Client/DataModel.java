package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.Permissions;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import DataBases.Person;


public class DataModel extends AbstractTableModel
{
	ArrayList<Person> pp = new ArrayList<>();
	public ActionReadListener rdlst = new ActionReadListener();
	public ActionCreateListener crtlst = new ActionCreateListener();
	public ActionUpdateListener updlst = new ActionUpdateListener();
	public ActionDeleteListener dellst = new ActionDeleteListener();
	PButtonPanel pbtn;
	Gson json = new Gson();
	DataOutputStream write;
	DataInputStream read;

	public DataModel()
	{
		try
		{
			Socket sock = new Socket("127.0.0.1", 3345);
			read = new DataInputStream(sock.getInputStream());
			write = new DataOutputStream(sock.getOutputStream());		
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		fireTableDataChanged();
	}

	@Override
	public int getColumnCount() 
	{
		return 4;
	}

	@Override
	public int getRowCount() 
	{
		return pp.size();
	}

	@Override
	public Object getValueAt(int row, int column) 
	{
		Object ret = null;
		Person p = pp.get(row);

		switch (column) 
		{
			case 0: ret = p.id; break;
			case 1: ret = p.fname; break;
			case 2: ret = p.lname; break;
			case 3: ret = p.age; break;
			default: break;
		}
		return ret;
	}

	@Override
	public String getColumnName(int column) 
	{
		String[] names = {"ID","fname","lname","age"};
		return names[column];
	}

	public void read()
	{
		String message = "read";
		message = send(message);
		pp = json.fromJson(message, new TypeToken<ArrayList<Person>>() {}.getType());	
	}

	class ActionReadListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{			
			read();
			fireTableDataChanged();
		}

	}

	public String send(String str)
	{
		String msg = "";
		try
		{
			write.writeUTF(str);
			msg = read.readUTF();

		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return msg;
	}

	class ActionCreateListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			int id = Integer.parseInt(pbtn.txt_id_add.getText());
			pbtn.txt_id_add.setText("");

			String fname = pbtn.txt_fname_add.getText();
			pbtn.txt_fname_add.setText("");

			String lname = pbtn.txt_lname_add.getText();
			pbtn.txt_lname_add.setText("");

			int age = Integer.parseInt(pbtn.txt_age_add.getText());
			pbtn.txt_age_add.setText("");

			String Pmessage = json.toJson(new Person(id, fname, lname, age));
			Pmessage = "create>" + Pmessage;
			send(Pmessage);
			read();
			fireTableDataChanged();
		}

	}

	class ActionUpdateListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			int id = Integer.parseInt(pbtn.txt_id_add.getText());
			pbtn.txt_id_add.setText("");

			String fname = pbtn.txt_fname_add.getText();
			pbtn.txt_fname_add.setText("");

			String lname = pbtn.txt_lname_add.getText();
			pbtn.txt_lname_add.setText("");

			int age = Integer.parseInt(pbtn.txt_age_add.getText());
			pbtn.txt_age_add.setText("");

			String Pmessage = json.toJson(new Person(id, fname, lname, age));
			Pmessage = "update>" + Pmessage;
			send(Pmessage);
			read();
			fireTableDataChanged();
		}
	}

	class ActionDeleteListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			String Pmessage = pbtn.txt_id_add.getText();
			pbtn.txt_id_add.setText("");
			Pmessage = "delete>" + Pmessage;
			send(Pmessage);
			read();
			fireTableDataChanged();

		}
	}


}
