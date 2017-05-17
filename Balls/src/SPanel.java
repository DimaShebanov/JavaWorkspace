import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;

public class SPanel extends JPanel
{
	ArrayList<BaloonPan> baloons = new ArrayList<BaloonPan>();
	SharikMouseListener mList = new SharikMouseListener();
	SPanel panel;
	BallThread bThread;

	public SPanel(int width, int height)
	{
		setBounds(0, 0, width, height);
		addMouseListener(mList);
		panel = this;

		bThread = new BallThread();
		bThread.start();
	}


	@Override
	public void paint(Graphics g)
	{
		super.paint(g);

		for (BaloonPan baloon : baloons)
		{
			baloon.move();
		}
	}

	class SharikMouseListener implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e)
		{

		}

		@Override
		public void mouseEntered(MouseEvent e)
		{

		}

		@Override
		public void mouseExited(MouseEvent e)
		{

		}

		@Override
		public void mousePressed(MouseEvent e)
		{
			BaloonPan bal = new BaloonPan(e.getX(), e.getY(), panel);
			baloons.add(bal);
			panel.add(bal);
			repaint();
		}

		@Override
		public void mouseReleased(MouseEvent e)
		{

		}

	}

	public class BallThread extends Thread
	{
		@Override
		public void run()
		{
			try
			{
				while(true)
				{


					repaint();
					TimeUnit.SECONDS.sleep(10000);

				}
			} 
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//					BallThread.sleep(100);


		}
	}

}
