package Client;

import java.io.IOException;
import java.net.Socket;

public class CCon
{
	Socket sock;
	ClientReader reader;
	ClientWriter writer;
	CFrame mainFrame;
	public CCon(CFrame mainFrame)
	{
		this.mainFrame = mainFrame;
		try
		{
			sock = new Socket("localhost", 4455);
			reader = new ClientReader(sock, mainFrame);
			writer = new ClientWriter(sock);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
