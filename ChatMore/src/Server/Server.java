package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server
{
	public static void main(String[] args) throws IOException
	{
		ServerSocket ss = new ServerSocket(7888);
		System.out.println("Waiting for a new client");
		ArrayList<SClient> clients = new ArrayList<SClient>();
		ArrayList<String> msg = new ArrayList<String>();
		ServerSender ssen = new ServerSender(clients, msg);
		SocketListener sl = new SocketListener(clients,msg,ss);
		ServerScanner sc = new ServerScanner(msg, ss, ssen, sl);
	}
}
