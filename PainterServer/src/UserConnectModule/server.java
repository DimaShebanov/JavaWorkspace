package UserConnectModule;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import logic.Messager;
import logic.checkCliens;

public class server extends Thread
{
	public volatile	List<SClient> sclients = null;
	Messager listener =null;
	public checkCliens checCliens = null;
	public server()
	{
		sclients = Collections.synchronizedList(new ArrayList<SClient>());
		listener = new Messager(sclients);
		this.start();
	}
	@Override
	public void run()
	{
		try (ServerSocket ss = new ServerSocket(1234))
		{
			while(true)
			{
				Socket sc = ss.accept();
				SClient sclient = new SClient(sc,sclients,listener);
				sclients.add(sclient);
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
