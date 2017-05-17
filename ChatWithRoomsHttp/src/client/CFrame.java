package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class CFrame extends JFrame
{
	CChatPanel chatpan;
	CCon con;
	String login;
	CRoomsPanel rooms;
	RoomAdapter adapt;
	String roomname;
	public CFrame()
	{
		setBounds(100, 100, 600, 600);
		setLayout(null);
		
		login = JOptionPane.showInputDialog("Enter your login here");
		if(login.equals(""))
		{
			login = JOptionPane.showInputDialog("Enter your login bitch!");
		}
		setTitle(login);
		chatpan = new CChatPanel(this, login);
		add(chatpan);
		rooms = new CRoomsPanel(this, login);
		add(rooms);
		adapt = new RoomAdapter(this);
		
		con = new CCon(this);
		con.writer.send(login);
		
		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
