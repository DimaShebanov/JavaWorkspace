package client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientReader extends Thread
{
	DataInputStream read;
	CFrame mainFrame;
	public ClientReader(Socket sock, CFrame mainFrame)
	{
		this.mainFrame = mainFrame;
		try
		{
			read = new DataInputStream(sock.getInputStream());
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		start();
	}

	@Override
	public void run()
	{
		while(true)
		{
			try
			{
				String line = read.readUTF();
				if(line.equals("roomisdeleted"))
				{
					mainFrame.rooms.setVisible(true);
					mainFrame.chatpan.curroom.setText("");
					mainFrame.chatpan.chat.setText("");
				}
				
				else if(line.contains("Rooms:") && line != null)
				{
					String[] arr = line.split(":", 2);
					mainFrame.adapt.adapt(arr[1]);
				}
				else
				{
					mainFrame.chatpan.chat.append("\n" + line);
				}
			}
			catch (IOException e)
			{
				stop();
				e.printStackTrace();
			}
		}
	}
}
