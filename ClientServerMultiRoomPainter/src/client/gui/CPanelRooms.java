package client.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import client.logic.CCommand;

public class CPanelRooms extends JPanel
{
	CCommand cComm;
	Gson json = new Gson();
	public CPanelRooms(CCommand cComm)
	{
		this.cComm = cComm;
		setBounds(0, 50, 584, 361);
		setLayout(new GridLayout(5, 5, 5, 5));
		setBackground(Color.BLUE);
	}

	
	public void setRooms(String str)
	{
		ArrayList<String> roomsNames = json.fromJson(str, new TypeToken<ArrayList<String>>(){}.getType());
		for (String name : roomsNames)
		{
			add(new CRoom(name, cComm));
		}
		revalidate();
	}
}
