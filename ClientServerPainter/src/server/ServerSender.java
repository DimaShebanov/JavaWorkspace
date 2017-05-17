package server;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.plaf.synth.SynthSpinnerUI;

import com.google.gson.Gson;

import model.MFigure;

public class ServerSender extends Thread
{
	ArrayList<SClient> clients;
	ArrayList<String> msg;
	ArrayList<MFigure> figs;
	String lastMessage = "";
	Gson json = new Gson();

	public ServerSender(ArrayList<SClient> clients, ArrayList<String> msg, ArrayList<MFigure> figs)
	{
		this.clients = clients;
		this.figs = figs;
		this.msg = msg;
		start();
	}

	@Override
	public void run()
	{

		try
		{
			while (true)
			{
				for (SClient client : clients)
				{
					if(msg.size() > 0)
					{
						synchronized (msg)
						{
							for (String line : msg)
							{
								String[] lines = line.split(",", 2);
								if(client.id != Integer.parseInt(lines[0].substring(line.indexOf(":") + 1)))
								{
									line = lines[1].substring(4);
									client.out.writeUTF(line);
									client.out.flush();
								}	
								line = lines[1].substring(4);
								renewFigs(line);
							}
						}
					}
				}
				if(msg.size() > 0)
				{
					lastMessage = msg.get(msg.size() - 1);
				}		
				msg.clear();
				sleep(100);
			}
		} 
		catch (IOException | InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public void renewFigs(String msg)
	{
		MFigure figure = json.fromJson(msg, MFigure.class);
		for (MFigure fig : figs)
		{
			if(fig.equal(figure));
			{
				return;
			}
		}
		figs.add(figure);
	}

}
