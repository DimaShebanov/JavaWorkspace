package client.gui;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CButtonPanel extends JPanel
{

	CContentPanel content;
	public JButton btnCreateRoom;
	public JButton btnExit;
	public CButtonPanel(CContentPanel content)
	{
		setBackground(Color.YELLOW);
		setBounds(0, 0, 584, 50);
		setLayout(null);
		this.content = content;
		
		btnCreateRoom = new JButton("Create room");
		btnCreateRoom.setBounds(0, 0, 120, 50);
		add(btnCreateRoom);
		btnCreateRoom.addActionListener(content.cComm.aCreateRoomLst);
		
		btnExit = new JButton("Exit");
		btnExit.setBounds(495, 0, 89, 50);
		add(btnExit);	
		
		
	}

}
