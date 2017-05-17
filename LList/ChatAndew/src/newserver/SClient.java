package newserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class SClient extends Thread
{
	Socket sc;
	DataInputStream in;
	DataOutputStream out;
	String login;
	ArrayList<String> msg = null;
	
	public SClient(Socket sc, ArrayList<String> msg) throws IOException
	{
		this.sc = sc;
		in = new DataInputStream(sc.getInputStream());
		out = new DataOutputStream(sc.getOutputStream());
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

				String str = in.readUTF();
				System.out.println(str);
				String[] ar = str.split(":");

				String ms = "";
				if(ar[0].equals("login"))
				{
					login = ar[1];
					ms = login + " enter to chat";
				}
				if(ar[0].equals("msg"))
				{
					ms = "Message from " + login + " => " + ar[1];
				}
				if(ar[0].equals("exit"))
				{
					ms = login + " exit our chat";
					msg.add(ms);
					break;
				}
				msg.add(ms);
				Thread.sleep(100);
			}
		} 
		catch (Exception e)
		{
		}		
	}
}
