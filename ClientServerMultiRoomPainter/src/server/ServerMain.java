package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import client.model.CMFigure;

public class ServerMain
{
	public static void main(String[] args)
	{
		ArrayList<SClient> clients = new ArrayList<SClient>();
		ArrayList<String> msg = new ArrayList<String>();
		ArrayList<CMFigure> figs = new ArrayList<>();
		ArrayList<SRoom> rooms = new ArrayList<>();
		PictureIO pio = new PictureIO();
		ServerListener slist = new ServerListener(clients, msg, figs, rooms);
		ServerSender ssend = new ServerSender(clients, msg, figs, rooms, pio);
	}
}
