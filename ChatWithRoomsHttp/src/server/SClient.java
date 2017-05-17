package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class SClient extends Thread
{
	DataInputStream read;
	DataOutputStream write;
	Socket ss;
	ArrayList<String> specialMsg;
	ArrayList<String> roomMSG;
	String login;
	public SClient( Socket ss, ArrayList<String> specialMsg)
	{
		this.ss = ss;
		this.specialMsg = specialMsg;
		try
		{
			read = new DataInputStream(ss.getInputStream());
			write = new DataOutputStream(ss.getOutputStream());

		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		start();
	}
	
	public void send(String msg)
	{
		try
		{
			write.writeUTF(msg);
			write.flush();

		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	@Override
	public void run()
	{
		try
		{
			login = read.readUTF();
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		} 
		while(true)
		{
			try
			{
				String line = read.readUTF();

				if(line.contains("msg:") && roomMSG != null)
				{
					synchronized (roomMSG)
					{
						String[] arr = line.split(":", 2);
						roomMSG.add(arr[1]);
					}
				}
				else
				{
					synchronized (specialMsg)
					{
						specialMsg.add(line);
					}
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
