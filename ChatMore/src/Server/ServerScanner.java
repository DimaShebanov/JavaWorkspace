package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Scanner;

public class ServerScanner extends Thread
{
	Scanner sc;
	ArrayList<String> msg;
	ServerSocket ss;
	ServerSender ssen;
	SocketListener sl;
	
	public ServerScanner(ArrayList<String> msg, ServerSocket ss, ServerSender ssen, SocketListener sl)
	{
		this.msg = msg;
		this.ss = ss;
		this.ssen = ssen;
		this.sl = sl;
		sc = new Scanner(System.in);
		start();
	}

	@Override
	public void run()
	{
		while(true)
		{
			if(sc.hasNext())
			{
				String messaga = sc.nextLine();
				if(messaga.equals("exit"))
				{
					
					try
					{
						msg.add("exitservernahren");
						sleep(100);
						sl.stop();
						ssen.stop();
						ss.close();
					} 
					catch (IOException | InterruptedException e)
					{
						e.printStackTrace();
					}
					break;
				}
			}
		}
		this.stop();
	}
}
