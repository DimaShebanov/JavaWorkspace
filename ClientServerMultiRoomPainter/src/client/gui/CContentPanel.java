package client.gui;

import java.awt.Color;

import javax.swing.JPanel;

import client.logic.CCommand;

public class CContentPanel extends JPanel
{
	public CPanelRooms rooms;
	public CButtonPanel btnPanel;
	public CCommand cComm;
	public RoomFullSize curRoom;

	public CContentPanel(CCommand cComm)
	{
		setBounds(0, 0, 584, 411);
		rooms = new CPanelRooms(cComm);
		add(rooms);
		this.cComm = cComm;
		
		btnPanel = new CButtonPanel(this);
		add(btnPanel);
		setLayout(null);
		
		curRoom = new RoomFullSize();
		add(curRoom);
	}

	
	public void connectToRoom(String roomName, String figs)
	{
		rooms.setVisible(false);
	}
}
