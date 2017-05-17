package newclient;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class ClientWriter
{
	public ClientWriter( DataOutputStream out ) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println( "Login => " );
		String str = sc.nextLine();
		out.writeUTF("login:"+ str);
		out.flush();
		
		while(true)
		{
			str = sc.nextLine();
			if(str.equals("exit"))
			{
				out.writeUTF("exit:");
				out.flush();
				break;
			}
			out.writeUTF("msg:"+ str);
			out.flush();
		}
		sc.close();
		out.close();
	}
}
