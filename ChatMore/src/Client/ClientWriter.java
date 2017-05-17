package Client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ClientWriter 
{	
	DataOutputStream out;
	public ClientWriter(OutputStream ous) throws IOException
	{
		out = new DataOutputStream(ous);
		String login = JOptionPane.showInputDialog("input your login");
		out.writeUTF("login:" + login);
	}
	public void send(String str)
	{
		try
		{
			if(str.equals("exit"))
			{
				out.writeUTF("exit");
				return;
			}
			out.writeUTF("msg:" + str);
			out.flush();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}


}
