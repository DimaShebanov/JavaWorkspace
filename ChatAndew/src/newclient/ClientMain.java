package newclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.ClientInfoStatus;

import javax.swing.JOptionPane;

public class ClientMain
{
	public static void main(String[] args) throws UnknownHostException, IOException
	{
		Socket cs = new Socket( InetAddress.getByName("127.0.0.1"), 726);
		new ClientReader( new DataInputStream(cs.getInputStream()) );
		new ClientWriter( new DataOutputStream(cs.getOutputStream()) );
	}
}
