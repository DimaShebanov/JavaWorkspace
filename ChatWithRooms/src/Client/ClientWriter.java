package Client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientWriter
{
	DataOutputStream write;
	String login;
	public ClientWriter(Socket sock)
	{
		try
		{
			write = new DataOutputStream(sock.getOutputStream());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void send(String msg)
	{
		try
		{
			System.out.println(msg);
			write.writeUTF(msg);
			write.flush();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
