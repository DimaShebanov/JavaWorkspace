package blogic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;

import GUI.PButtonPanel;
import dal.PersonDAO;
import dal.PersonDAO_H2;
import dal.PersonDAO_Mock;
import dal.Person_DAO_JSon_Auto;

public class PersonDM extends AbstractTableModel
{
	
	PersonDAO pd = new PersonDAO_Mock();
	ArrayList<Person> pp = new ArrayList<Person>();
	public ActionReadListener rdlst = new ActionReadListener();
	public ActionCreateListener crtlst = new ActionCreateListener();
	public ActionUpdateListener updlst = new ActionUpdateListener();
	public ActionDeleteListener dellst = new ActionDeleteListener();
	public ActionComboBoxListener aBox = new ActionComboBoxListener();
	public PButtonPanel pbtn = new PButtonPanel(this);

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

	
	
	class ActionReadListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			pp = pd.read();
			fireTableDataChanged();
		}
		
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
			
			pd.create(new Person(id, fname, lname, age));

			pp = pd.read();
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
			
			pd.update(new Person(id, fname, lname, age));
			pp = pd.read();
			fireTableDataChanged();
		}
	}
	
	class ActionDeleteListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			pd.delete(Integer.parseInt(pbtn.txt_id_add.getText()));
			pbtn.txt_id_add.setText("");
			pp = pd.read();
			fireTableDataChanged();
		}
	}
	
	class ActionComboBoxListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			JComboBox<String> box = (JComboBox<String>) e.getSource();
			switch ((String)box.getSelectedItem()) 
			{
			case "Mock": pd = new PersonDAO_Mock();  break;
			case "H2":   pd = new PersonDAO_H2();	 break;
			case "JSon":   pd = new Person_DAO_JSon_Auto(); break;
			default: break;
			}
			pp = pd.read();
			fireTableDataChanged();
		}
	}
}
