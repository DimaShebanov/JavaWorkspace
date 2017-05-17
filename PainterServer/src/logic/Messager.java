package logic;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import UserConnectModule.SClient;

public class Messager extends Thread
{
	public String lastMessadge = "";
	volatile List<SClient> sockets = new ArrayList<>();
	DataOutputStream out1 =null;
	public Messager(List<SClient> sockets)
	{
		this.sockets = sockets;
		this.start();
	}

	public synchronized void sendMessage(String message)
	{
		for (SClient socket : sockets)
		{
			try {
				out1 = new DataOutputStream(socket.scOut.outPut);
				out1.writeUTF(message);
				out1.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run()
	{
		while (true)
		{
			try
			{
				for (SClient socket : sockets)
				{
					if(socket.scIn.answerFromClient.size()>0)
					{
						this.sendMessage(socket.scIn.answerFromClient.get(0));
						lastMessadge = socket.scIn.answerFromClient.get(0);
						socket.scIn.answerFromClient.remove(0);
					}
				}
				Thread.sleep(100);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
