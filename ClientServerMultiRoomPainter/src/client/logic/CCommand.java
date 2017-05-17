package client.logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import client.connection.CConnection;
import client.gui.CContentPanel;
import client.gui.CRoom;

public class CCommand
{
	public CContentPanel content;
	public CConnection con;
	CCommand self;
	public ActionChooseRoomLst aRoomChsLst;
	public ActionCreateRoomLst aCreateRoomLst;
	public CCommand()
	{
		this.con = con;
		this.content = content;
		aRoomChsLst = new ActionChooseRoomLst();
		self = this;
		aCreateRoomLst = new ActionCreateRoomLst();
	}

	
	class ActionChooseRoomLst implements MouseListener
	{
		@Override
		public void mouseClicked(MouseEvent e)
		{}

		@Override
		public void mouseEntered(MouseEvent e)
		{}

		@Override
		public void mouseExited(MouseEvent e)
		{}

		@Override
		public void mousePressed(MouseEvent e)
		{
//			CRoom room = (CRoom) e.getSource();
//			con.writer.send("join room:" + room.name);
			content.rooms.setVisible(false);
			content.btnPanel.setVisible(false);
			content.curRoom.setVisible(true);
			content.revalidate();
		}

		@Override
		public void mouseReleased(MouseEvent e)
		{}
	}
	
	class ActionCreateRoomLst implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			content.rooms.add(new CRoom("roomname", self));
			content.rooms.revalidate();
		}
	}
}
