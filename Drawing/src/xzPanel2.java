import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class xzPanel2 extends JPanel
{
	public xzPanel2()
	{
		setVisible(true);
		setBounds(100, 20, 60, 60);
		setBackground(Color.yellow);
		addMouseListener(new MouseListener() 
		{

			@Override
			public void mouseReleased(MouseEvent e) 
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) 
			{
				setBackground(Color.BLACK);
				
			}

			@Override
			public void mouseExited(MouseEvent e) 
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) 
			{
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) 
			{
				// TODO Auto-generated method stub

			}
		});
	}
}