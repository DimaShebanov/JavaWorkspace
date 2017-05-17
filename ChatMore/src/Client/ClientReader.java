package Client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class ClientReader extends Thread
{
	DataInputStream in;
	JTextArea resp;
	CFrame frame;
	public ClientReader(InputStream is, JTextArea resp2, CFrame frame)
	{
		this.frame = frame;
		in = new DataInputStream(is);
		this.resp = resp2;
		start();
	}

	@Override
	public void run()
	{
		try
		{
			while(true)
			{
				String line = in.readUTF();
				if(line.equals("exitservernahren"))
				{
					System.out.println(line);
					frame.exitNahren();
				}
				String hist = resp.getText();
				line = hist + "\n" + line;
				resp.setText(line);
				sleep(100);
			}
		} 
		catch (IOException | InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
