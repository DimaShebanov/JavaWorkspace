import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.plaf.basic.BasicLabelUI;

public class SPanel extends JPanel
{
	ArrayList<Baloon> baloons = new ArrayList<Baloon>();
	SharikMouseListener mList = new SharikMouseListener();
	SPanel panel;
	BallThread bThread;

	public SPanel()
	{
		
		setBounds(0, 0, 600, 600);

		addMouseListener(mList);
		panel = this;
		//		Timer timer = new Timer(50, new ActionListener()
		//		{
		//
		//			@Override
		//			public void actionPerformed(ActionEvent e)
		//			{
		//				repaint();
		//			}
		//		});
		//		timer.start();

		bThread = new BallThread();
		bThread.start();
	}


	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D gg = (Graphics2D) g;
		//		gg.setColor(Color.WHITE);
		//		gg.fillRect(0, 0, 600, 600);
		//		gg.setColor(Color.black);
		for (Baloon baloon : baloons)
		{
			baloon.move();
			baloon.draw(gg);
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
			baloons.add(new Baloon(e.getX(), e.getY(), panel));
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
					panel.repaint();
					Thread.sleep(15);
				}
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
