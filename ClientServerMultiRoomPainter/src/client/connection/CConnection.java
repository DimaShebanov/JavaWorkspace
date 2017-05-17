package client.connection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import client.gui.CContentPanel;

public class CConnection
{
	Socket sock;
	public CReader reader;
	public CWriter writer;
	public CContentPanel content;

	public CConnection(CContentPanel content)
	{
		this.content = content;
		try
		{
			sock = new Socket("localhost", 7111);
			reader = new CReader(new DataInputStream(sock.getInputStream()), content);
			writer = new CWriter(new DataOutputStream(sock.getOutputStream()));
			
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}