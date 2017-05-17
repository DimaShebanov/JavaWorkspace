package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain
{

	public static void main(String[] args) throws IOException
	{
		int port = 3345;
		ServerSocket ss = new ServerSocket(port);
		DBConnection db = new DBConnection();
		CommandHandler ch = new CommandHandler(db);
		System.out.println("Server is god damn started!!!");
		Socket sock = ss.accept();
		System.out.println("we have a client!");
		SClient client = new SClient(sock, ch);
	}

}
