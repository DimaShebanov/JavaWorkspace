package client.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import client.connection.CConnection;
import client.logic.CCommand;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CFrame extends JFrame
{

	CContentPanel content;
	CCommand cComm;
	public CFrame()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		
		cComm = new CCommand();

		
		content = new CContentPanel(cComm);


		CConnection con = new CConnection(content);
		
		cComm.con = con;
		cComm.content = content;
		
		add(content);
		
		setLayout(null);
		setVisible(true);

	}
}


