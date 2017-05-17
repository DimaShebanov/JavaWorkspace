package client.connection;

import java.io.DataOutputStream;
import java.io.IOException;

public class CWriter
{
	DataOutputStream write;
	public CWriter(DataOutputStream write)
	{
		this.write = write;
		send("test");
	}
	public void send(String msg)
	{
		try
		{
			write.writeUTF(msg);
			write.flush();

		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
