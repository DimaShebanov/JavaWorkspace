package newserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerMain
{
	static ArrayList<SClient> clients = new ArrayList<SClient>();
	static ArrayList<String> msg = new ArrayList<String>();

	public static void main(String[] args) throws IOException
	{		
		ServerSocket ss = new ServerSocket(726);
		ServerSender ss1 = new ServerSender(clients, msg);
		while(true)
		{
			Socket cs = ss.accept();
			clients.add( new SClient(cs, msg) );
		}
	}
}
