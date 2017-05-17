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
		Socket cs = new Socket( "127.0.0.1", 725);
		new ClientReader( cs.getInputStream() );
		new ClientWriter( cs.getOutputStream() );
	}
}
