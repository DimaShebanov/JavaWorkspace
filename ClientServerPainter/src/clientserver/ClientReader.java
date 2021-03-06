package clientserver;

import java.awt.Color;
import java.awt.Component;
import java.awt.Rectangle;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import frame.Figure;
import frame.RMFrame;
import frame.RMPanel;
import model.MFigure;
import model.RMData;

public class ClientReader extends Thread
{
	DataInputStream read;
	RMFrame mainFrame;
	Gson json = new Gson();
	public ClientReader(Socket sock, RMFrame mainFrame)
	{
		this.mainFrame = mainFrame;
		try
		{
			read = new DataInputStream(sock.getInputStream());
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		start();
	}

	@Override
	public void run()
	{
		try
		{

			String line;
			sleep(100);
			line = read.readUTF();
			if(line.length() > 10)
			{
				mainFrame.rmp.setMemento(json.fromJson(line, new TypeToken<ArrayList<MFigure>>(){}.getType()));
			}
			while(true)
			{				
				line = read.readUTF();
				MFigure fig = json.fromJson(line, MFigure.class);
				mainFrame.rmp.putFigure(fig);
			}
		}			
		catch (IOException | InterruptedException e)
		{
			stop();
			e.printStackTrace();
		}
	}
}
