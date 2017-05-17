package newclient;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ClientReader extends Thread
{

	DataInputStream in = null;
	public ClientReader( DataInputStream ins) 
	{
		in = ins;
		this.start();
	}

	@Override
	public void run() 
	{
		try 
		{
			while(true)
			{
				String str = in.readUTF();
				System.out.println( str );
				Thread.sleep(100);
			}
		} 
		catch (IOException | InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}
