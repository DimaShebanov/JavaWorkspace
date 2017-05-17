package Server;

import java.io.IOException;
import java.util.ArrayList;

public class ServerSender extends Thread
{
	ArrayList<SClient> clients;
	ArrayList<Room> rooms;
	ArrayList<String> specialMsg;
	public ServerSender(ArrayList<SClient> clients, ArrayList<Room> rooms, ArrayList<String> specialMsg)
	{
		this.rooms = rooms;
		this.specialMsg = specialMsg;
		this.clients = clients;
		start();
	}

	@Override
	public void run()
	{
		int sizeOfClients = clients.size();
		while(true)
		{
			synchronized (specialMsg)
			{
				for (String string : specialMsg)
				{
					String[] arr = string.split(":");

					if(arr[0].equals("exit"))
					{
						String loginOfExited = arr[1];
						SClient clientexited = null;
						for (SClient client : clients)
						{
							if(client.login.equals(loginOfExited))
							{
								clientexited = client;
								client.stop();
								System.out.println(client.login + " is out!");
								break;
							}
						}
						for (Room room : rooms)
						{
							if(room.clientstakingpart.contains(clientexited) && clientexited != null)
							{
								room.clientstakingpart.remove(clientexited);
								break;
							}
						}
						clients.remove(clientexited);
						clientexited.roomMSG = null;
					}

					if(arr[0].equals("deleteroom"))
					{
						String nameofroomtodelete = arr[1];
						Room roomtodelete = null;
						for (Room room : rooms)
						{
							if(room.nameOfRoom.equals(nameofroomtodelete))
							{
								roomtodelete = room;
								break;
							}
						}
						if(roomtodelete != null)
						{
							for (SClient client : roomtodelete.clientstakingpart)
							{
								try
								{
									client.write.writeUTF("roomisdeleted");
									client.write.flush();
								} 
								catch (IOException e)
								{
									e.printStackTrace();
								}
							}
							synchronized (roomtodelete.clientstakingpart)
							{
								roomtodelete.clientstakingpart.clear();
							}
							synchronized (rooms)
							{
								rooms.remove(roomtodelete);
							}
							sendRooms();
						}
					}
					if(arr[0].equals("leaveroom"))
					{
						String nameofroomtoLeave = arr[1];
						String loginofleavingclient = arr[2];
						SClient clienttoleave = null;
						for (SClient client : clients)
						{
							if(client.login.equals(loginofleavingclient))
							{
								clienttoleave = client;
								break;
							}
						}
						for (Room room : rooms)
						{
							if(room.nameOfRoom.equals(nameofroomtoLeave) && room.clientstakingpart.contains(clienttoleave))
							{
								room.clientstakingpart.remove(clienttoleave);
								room.messagesForThisRoom.add(clienttoleave.login + " left our room");
								clienttoleave.roomMSG = null;
								break;
							}
						}
					}


					if(arr[0].equals("createRoom"))
					{
						String roomname = arr[1];
						String loginofCreator = arr[2];
						SClient clientToJoin = null;
						for (SClient client : clients)
						{
							if(client.login.equals(loginofCreator))
							{
								clientToJoin = client;
								break;
							}
						}
						Room newroom = new Room(roomname);
						newroom.clientstakingpart.add(clientToJoin);
						clientToJoin.roomMSG = newroom.messagesForThisRoom;
						rooms.add(newroom);
						newroom.messagesForThisRoom.add(clientToJoin.login + " joined our room!");
						sendRooms();

					}

					if(arr[0].equals("join"))
					{
						String loginOfClientToJoin = arr[2];
						SClient clientToJoin = null;
						for (SClient client : clients)
						{
							if(client.login.equals(loginOfClientToJoin))
							{
								clientToJoin = client;
								break;
							}
						}
						String roomName = arr[1];
						for (Room room : rooms)
						{
							if(room.clientstakingpart.contains(clientToJoin))
							{
								room.clientstakingpart.remove(clientToJoin);
							}
							if(room.nameOfRoom.equals(roomName) && clientToJoin != null)
							{
								room.clientstakingpart.add(clientToJoin);
								clientToJoin.roomMSG = room.messagesForThisRoom;
								room.messagesForThisRoom.add(clientToJoin.login + " joined our room!");
								break;
							}
						}
					}
				}
				specialMsg.clear();
			}

			for (Room room : rooms)
			{
				synchronized (room.messagesForThisRoom)
				{

					for (SClient roomClient : room.clientstakingpart)
					{
						for (String msg : room.messagesForThisRoom)
						{
							roomClient.send("in " + room.nameOfRoom + ": " + msg);
						}
					}
					room.messagesForThisRoom.clear();
				}
			}
			if(clients.size() > sizeOfClients)
			{
				sendRooms();
				sizeOfClients = clients.size();
			}
		}
	}

	public void sendRooms()
	{
		String roomsstr = "Rooms:";
		for (Room room : rooms)
		{
			roomsstr += room.nameOfRoom + ":";
		}
		for (SClient client : clients)
		{
			client.send(roomsstr);
		}
	}
}
