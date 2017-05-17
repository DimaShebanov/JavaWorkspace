package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CFrame extends JFrame
{


	JTextField msg;
	JTextArea resp;
	ClientReader read;	
	ClientWriter write;
	JButton send;
	JButton exit;

	public CFrame() throws UnknownHostException, IOException
	{
		setBounds(100, 100, 300, 500);
		setLayout(null);
		Socket sock = new Socket("127.0.0.1", 7888);



		msg = new JTextField();
		msg.setBounds(0, 0, 70, 20);
		add(msg);

		resp = new JTextArea();
		resp.setEditable(false);
		resp.setBounds(0, 30, 400, 400);
		add(resp);

		read = new ClientReader(sock.getInputStream(), resp, this);	
		write = new ClientWriter(sock.getOutputStream());


		send = new JButton("send");
		send.setBounds(70, 0, 70, 20);
		send.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				write.send(msg.getText());
				msg.setText("");
			}
		});
		add(send);


		exit = new JButton("exit");
		exit.setBounds(150, 0, 70, 20);
		exit.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				write.send("exit");
				exitNahren();
			}
		});
		add(exit);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}

	public void exitNahren()
	{
		try
		{
			write.out.close();
			read.in.close();
			read.stop();
			setVisible(false);
		} 
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
	}
}
