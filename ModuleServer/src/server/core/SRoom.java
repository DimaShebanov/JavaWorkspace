package server.core;

import java.util.ArrayList;

public class SRoom
{
	public String roomName;
	ArrayList<SClient> clientsTakingPart = new ArrayList<>();
	
	public SRoom(String roomName)
	{
		this.roomName = roomName;
	}
}
