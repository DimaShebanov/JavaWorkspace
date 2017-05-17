package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import model.MFigure;

public class Server
{
	public static void main(String[] args) throws IOException
	{
		ServerSocket ss = new ServerSocket(7888);
		System.out.println("Waiting for a new client");
		ArrayList<SClient> clients = new ArrayList<SClient>();
		ArrayList<String> msg = new ArrayList<String>();
		ArrayList<MFigure> figs = new ArrayList<>();

		ServerSender ssend = new ServerSender(clients, msg, figs);
		int id = 0;
		while(true)
		{
			Socket sock = ss.accept();
			System.out.println("we've got a new client");
			clients.add(new SClient(sock, msg, ssend.lastMessage, id++, figs));
		}
	}
}
