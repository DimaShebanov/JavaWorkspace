package server.core;

import java.io.IOException;

public class ServerSender
{
	private static ServerSender instance = new ServerSender();
	SingleToneDB db;
	public ServerSender()
	{
		db = SingleToneDB.getInstance();
	}

	public static ServerSender getInstance()
	{
		return instance;
	}

	public void send(String line)
	{
		String[] partsOfLine = line.split(";", 3);
		String targetName = partsOfLine[1];
		
		SRoom targetRoom = db.getRoom(targetName);
		SClient targetClient = db.getClient(targetName);
		
		if(targetRoom != null)
		{
			sendInRoom(line, targetRoom);
		}
		else if(targetClient != null)
		{
			sendToClient(line, targetClient);
		}
		
	}

	public void sendInRoom(String line, SRoom targetRoom)
	{
		for (SClient client : targetRoom.clientsTakingPart)
		{
			try
			{
				client.out.writeUTF(line);
				client.out.flush();
				System.out.println("sent to client " + client.id + ":" + line);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	public void sendToClient(String line, SClient targetClient)
	{
		try
		{
			targetClient.out.writeUTF(line);
			targetClient.out.flush();
			System.out.println("sent to client " + targetClient.id + ":" + line);

		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
