package server.core;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SClient extends Thread
{
	int id;
	Socket sock;
	DataInputStream in;
	DataOutputStream out;
	SingleToneMessages messages;
	public SClient(Socket sock, int id)
	{
		this.id = id;
		this.sock = sock;
		messages = SingleToneMessages.getInstance();
		System.out.println("we have the new client:" + id);
		try
		{
			in = new DataInputStream(sock.getInputStream());
			out = new DataOutputStream(sock.getOutputStream());
			System.out.println("in and out of " + id + " inited");
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		start();
	}

	@Override
	public void run()
	{
		String line = "";
		System.out.println("listening to " + id);
		while(true)
		{
			try
			{
				sleep(100);
				line = in.readUTF();
				System.out.println(id + " wrote this:" + line);
				line = id + ";" + line;
				messages.addMessage(line);
			}
			catch (InterruptedException | IOException e)
			{
				e.printStackTrace();
			}
		}
	}

}
