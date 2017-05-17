package logic;

import java.util.List;

import UserConnectModule.SClient;

public class checkCliens extends Thread
{
	public volatile	List<SClient> sclients = null;
	volatile 	Messager listener =null;
	public checkCliens(List<SClient> sclients,Messager listener) 
	{
		this.listener= listener;
		this.sclients = sclients;
		this.start();
	}
	@Override
	public synchronized void run() 
	{
		while(true)
		{
			try
			{
				Thread.sleep(100);
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
