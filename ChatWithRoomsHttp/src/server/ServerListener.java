package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import com.sun.net.httpserver.*;

public class ServerListener extends Thread
{
	ArrayList<SClient> clients;
	ArrayList<String> specialMsg;
	ServerSocket ss;
	
	public ServerListener(ArrayList<SClient> clients, ServerSocket ss, ArrayList<String> specialMsg)
	{
		this.clients = clients;
		this.ss = ss;
		this.specialMsg = specialMsg;
		start();
	}
	
	@Override
	public void run()
	{
		while(true)
		{
			try
			{
				System.out.println("waiting biach!");
				Socket sock = ss.accept();
				clients.add(new SClient(sock, specialMsg));		
				System.out.println("gotanew one!");
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
