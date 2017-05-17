import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;



class MyFrame extends JFrame
{
	public MyFrame() 
	{
		
		setBounds(500,300,400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new MyPanel());
		setVisible(true);
	}
}

public class NewFrame 
{

	public static void main(String[] args) 
	{
		new MyFrame();
	}

}
