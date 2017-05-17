package server;

import java.util.ArrayList;

import com.google.gson.Gson;

import client.model.CMFigure;

public class SRoom
{
	ArrayList<SClient> roomClients;
	ArrayList<String> roomMsg;
	ArrayList<CMFigure> roomFigs;
	PictureIO pio;
	String name;
	Gson json = new Gson();
	
	public SRoom(String name)
	{
		roomClients = new ArrayList<>();
		roomMsg = new ArrayList<>();
		
		pio = new PictureIO();
		this.name = name;
	}
	
	
	public void appendFigs(String src)
	{
		CMFigure mfig = json.fromJson(src, CMFigure.class);
		
		if(!roomFigs.contains(mfig))
		{
			roomFigs.add(mfig);
		}
	}
}
