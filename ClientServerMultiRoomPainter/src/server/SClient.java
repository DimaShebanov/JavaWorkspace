package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.plaf.synth.SynthSeparatorUI;

import client.model.CMFigure;

public class SClient extends Thread
{
	ArrayList<String> msg;
	int id;
	DataInputStream in;
	DataOutputStream out;
	SRoom curRoom;
	public SClient(Socket sock, ArrayList<String> msg, int id)
	{
		this.msg = msg;
		this.id = id;
		
		try
		{
			in = new DataInputStream(sock.getInputStream());
			out = new DataOutputStream(sock.getOutputStream());
			System.out.println("client in and out inited");
			String msgnewclient = "new client:" + id;
			System.out.println("newclient message before "+ msgnewclient);
			msg.add(msgnewclient);
			System.out.println("newclient messages after"+msg);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		start();
	}

	@Override
	public void run()
	{
		try
		{
			String line = "";
			System.out.println(line);
			while(true)
			{
				sleep(1000);
				line = in.readUTF();

				if(line.startsWith("exit:"))
				{
					line += id;
				}

				if(line.startsWith("join room:"))
				{
					line+= "," + id;
				}
			}
		} 
		catch (IOException | InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public void send(String str)
	{
		try
		{
			System.out.println("server to client:" + str);
			out.writeUTF(str);
			out.flush();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void exit()
	{
		try
		{
			join();
			out.close();
			in.close();
		} 
		catch (InterruptedException | IOException e)
		{
			e.printStackTrace();
		}

	}
}
