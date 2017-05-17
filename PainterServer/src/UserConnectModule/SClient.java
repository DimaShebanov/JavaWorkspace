package UserConnectModule;

import java.io.IOException;
import java.net.Socket;
import java.util.List;

import logic.Messager;

public class SClient extends Thread
{
	public volatile String login ="";
	volatile List<SClient> sclients = null;
	Socket sc = null;
	public SClientIn  scIn  = null;
	public SClientOut scOut = null;
	Messager listener = null;
	public SClient(Socket sc,List<SClient> sclients,Messager listener )
	{
		this.sc=sc;
		this.listener= listener;
		this.sclients=sclients;
		try {
			scIn = new SClientIn(sc.getInputStream());
			scOut = new SClientOut(sc.getOutputStream());
			scOut.outPut.writeUTF(listener.lastMessadge);
			scOut.outPut.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() 
	{
		
	}
}
