package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import client.model.CMFigure;

public class ServerListener extends Thread
{
	ArrayList<SClient> clients;
	ArrayList<String> msg;
	ArrayList<CMFigure> figs;
	ArrayList<SRoom> rooms;

	public ServerListener(ArrayList<SClient> clients, ArrayList<String> msg, ArrayList<CMFigure> figs, ArrayList<SRoom> rooms)
	{
		this.clients = clients;
		this.msg = msg;
		this.figs = figs;
		System.out.println("server listener initialised");
		this.rooms = rooms;
		start();
	}
	
	@Override
	public void run()
	{
		try
		{
			int id = 0;
			ServerSocket ss = new ServerSocket(7111);
			System.out.println("server started");
			Socket sock;
			while(true)
			{
				sock = ss.accept();
				System.out.println("we've got a new client");
				clients.add(new SClient(sock, msg, id++));
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}