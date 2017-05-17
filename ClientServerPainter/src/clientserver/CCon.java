package clientserver;

import java.io.IOException;
import java.net.Socket;

import frame.RMFrame;
import frame.RMPanel;

public class CCon
{
	public Socket sock;
	public ClientReader reader;
	public ClientWriter writer;
	public RMFrame mainFrame;
	public CCon(RMFrame mainFrame)
	{
		this.mainFrame = mainFrame;
		try
		{
			sock = new Socket("localhost", 7888);
			reader = new ClientReader(sock, mainFrame);
			writer = new ClientWriter(sock);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
