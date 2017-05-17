package server.core;

import java.util.ArrayList;

public class SingleToneDB
{
	private static SingleToneDB instance = new SingleToneDB();
	
	public ArrayList<SClient> clients = new ArrayList<>();
	public ArrayList<SRoom> rooms = new ArrayList<>();
	
	public static SingleToneDB getInstance()
	{
		return instance;
	}
	
	public synchronized void addClient(SClient client)
	{
		clients.add(client);
	}
	
	public synchronized void addRoom(SRoom room)
	{
		rooms.add(room);
	}
	
	
	public SClient getClient(String clientID)
	{
		SClient ret = null;
		for (SClient client : clients)
		{
			if(client.id == (Integer.parseInt(clientID)))
			{
				ret = client;
			}
		}
		return ret;
	}
	
	public SRoom getRoom(String roomName)
	{
		SRoom ret = null;
		for (SRoom room : rooms)
		{
			if(room.roomName.equals(roomName))
			{
				ret = room;
			}
		}
		return ret;
	}
}
