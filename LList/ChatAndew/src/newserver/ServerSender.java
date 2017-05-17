package newserver;

import java.util.ArrayList;
import java.util.Collections;

public class ServerSender extends Thread
{
	ArrayList<SClient> clients;
	ArrayList<String>  msg;
	
	public ServerSender(ArrayList<SClient> clients, ArrayList<String>  msg)
	{
		//Collections.
		
		this.clients = clients;
		this.msg = msg;
		start();
	}
	
	@Override
	public void run()
	{
		try
		{
			while(true)
			{
				//System.out.println(msg.size());
				if(msg.size() >= 0)
				{
					for(int i = 0; i < clients.size(); i++)
					{
						for(String str: msg)
						{
							clients.get(i).out.writeUTF(str);
							clients.get(i).out.flush();
							
						}
					}
					msg.clear();
				}
				Thread.sleep(100);
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
