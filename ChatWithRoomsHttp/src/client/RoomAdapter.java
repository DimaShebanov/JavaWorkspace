package client;

public class RoomAdapter
{
	CFrame mainFrame;
	public RoomAdapter(CFrame cFrame)
	{
		this.mainFrame = cFrame;
	}


	public void adapt(String src)
	{
		String[] rooms = src.split(":");
		if(src.equals(" ") || src.equals(""))
		{
			mainFrame.rooms.removeAll();
			mainFrame.rooms.add(mainFrame.rooms.CreateRoom);
			mainFrame.rooms.yofnewroom = 60;
			mainFrame.rooms.repaint();
			System.out.println("shit");
		}
		else
		{
			mainFrame.rooms.removeAll();
			mainFrame.rooms.add(mainFrame.rooms.CreateRoom);
			mainFrame.rooms.yofnewroom = 60;
			for (String string : rooms)
			{
				mainFrame.rooms.add(new CRoom(string, mainFrame.rooms.yofnewroom, mainFrame));		
				mainFrame.rooms.yofnewroom += 60;
			}
			mainFrame.rooms.revalidate();
		}
	}
}
