package clientserver;

import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.Socket;
import java.util.ArrayList;

import com.google.gson.Gson;

import frame.RMPanel;
import model.MFigure;

public class ClientWriter
{
	DataOutputStream write;
	String login;
	Gson json = new Gson();
	
	public ClientWriter(Socket sock)
	{
		try
		{
			write = new DataOutputStream(sock.getOutputStream());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public String MakeJSON(MFigure arr)
	{
		String ret = json.toJson(arr);
		
		
		return ret;
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