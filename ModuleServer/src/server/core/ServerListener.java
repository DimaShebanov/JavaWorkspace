package server.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListener extends Thread
{
	int id;
	SingleToneDB db;
	public ServerListener()
	{
		db = SingleToneDB.getInstance();
		start();
	}

	@Override
	public void run()
	{
		try
		{
			System.out.println("Server listener started");

			id = 0;
			ServerSocket ss = new ServerSocket(7777);
			System.out.println("Server socket is opened");
			Socket sock;
			while(true)
			{
				sock = ss.accept();
				System.out.println("we've got a new client");
				SClient cli = new SClient(sock, id++);
				db.addClient(cli);
				sleep(100);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
