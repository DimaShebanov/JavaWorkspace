package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CRoom extends JPanel
{
	String roomname;
	int x;
	int y;
	CFrame mainFrame;
	public CRoom(String roomname, int yofnewroom, CFrame mainFrame)
	{
		this.roomname = roomname;
		this.mainFrame = mainFrame;
		setBounds(0, yofnewroom, 90, 100);
		JTextArea name = new JTextArea(roomname);
		name.setEditable(false);
		name.setBounds(0, 0, 150, 20);
		add(name);
		
		JButton join = new JButton("Join");
		join.setBounds(0, 20, 80, 20);
		add(join);
		join.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				mainFrame.con.writer.send("join:" + roomname + ":" + mainFrame.login);
				mainFrame.chatpan.roomname = roomname;
				mainFrame.chatpan.curroom.setText(roomname);
				mainFrame.rooms.setVisible(false);
			}
		});
		
		JButton deleteRoom = new JButton("Delete");
		deleteRoom.setBounds(80, 20, 80, 20);
		add(deleteRoom);
		deleteRoom.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String msg = "deleteroom:" + roomname;
				mainFrame.con.writer.send(msg);
			}
		});
	}
}
