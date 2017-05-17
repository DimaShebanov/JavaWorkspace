package client;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CRoomsPanel extends JPanel
{
	CFrame mainFrame;
	String login;
	int yofnewroom = 60;
	ArrayList<CRoom> rooms = new ArrayList<>();
	JButton CreateRoom;
	public CRoomsPanel(CFrame cFrame, String login)
	{
		this.mainFrame = cFrame;
		this.login = login;

		setBounds(0, 0, 180, 560);
		setLayout(new FlowLayout());

		CreateRoom = new JButton("create Room");
		CreateRoom.setBounds(0, 0, 180, 20);
		add(CreateRoom);

		CreateRoom.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String nameofnewroom = JOptionPane.showInputDialog("Input the name of new room:");
				CRoom newro = new CRoom(nameofnewroom, yofnewroom, mainFrame);
				add(newro);
				rooms.add(newro);
				yofnewroom += 60;
				repaint();
				mainFrame.chatpan.curroom.setText(nameofnewroom);
				String msg = "createRoom:" + nameofnewroom + ":" + login;
				mainFrame.con.writer.send(msg);
				mainFrame.rooms.setVisible(false);
			}
		});
	}
}
