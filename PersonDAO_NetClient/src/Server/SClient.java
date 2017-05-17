package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SClient extends Thread
{
	Socket sock;
	DataInputStream read;
	DataOutputStream write;
	CommandHandler ch;
	public SClient(Socket sock, CommandHandler ch)
	{
		this.sock = sock;
		this.ch = ch;
		try
		{
			read = new DataInputStream(sock.getInputStream());
			write = new DataOutputStream(sock.getOutputStream());
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
		while(true)
		{
			try
			{
				String message = read.readUTF();
				String resp = ch.handle(message);
				write.writeUTF(resp);
			} 
			catch (IOException e)
			{
				try
				{
					join();
				} 
				catch (InterruptedException e1)
				{
					e1.printStackTrace();
				}
			}
		}
	}
}
