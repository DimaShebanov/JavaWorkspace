package newserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerMain
{
	ArrayList<SClient> clients = new ArrayList<SClient>();
	ArrayList<String> msg = new ArrayList<String>();

	public static void main(String[] args)
	{		
		ServerSocket ss = new ServerSocket(725);
		new ServerSender(clients, msg);
		while(true)
		{
			Socket cs = ss.accept();
			clients.add( new SClient(cs, msg) );
		}
	}
}
