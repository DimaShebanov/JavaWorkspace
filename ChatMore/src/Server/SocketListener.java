package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class SocketListener extends Thread
{
	ArrayList<SClient> clients;
	ArrayList<String> msg;
	ServerSocket ss;
	
	public SocketListener(ArrayList<SClient> clients, ArrayList<String> msg, ServerSocket ss)
	{
		this.clients = clients;
		this.msg = msg;
		this.ss = ss;
		start();
	}
	
	@Override
	public void run()
	{
		while(true)
		{
			try
			{
				Socket sock;
				sock = ss.accept();
				System.out.println("we've got a new client");
				clients.add(new SClient(sock, msg));
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
			
		}
	}
}
