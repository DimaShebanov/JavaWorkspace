package client.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.border.LineBorder;

import client.logic.CCommand;

import javax.swing.border.EmptyBorder;

public class CRoom extends JPanel implements MouseListener
{
	public String name;
	public CCommand cComm;
	public CRoom(String name, CCommand cComm)
	{
		setBackground(Color.CYAN);
		this.name = name;
		this.cComm = cComm;
		setLayout(new BorderLayout(0, 0));
		
		JLabel roomName = new JLabel(name);
		roomName.setHorizontalAlignment(SwingConstants.CENTER);
		add(roomName);
		addMouseListener(cComm.aRoomChsLst);
	}
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
	{System.out.println("sds");}
	@Override
	public void mouseReleased(MouseEvent e)
	{}

}
