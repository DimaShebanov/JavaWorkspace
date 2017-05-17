package TimeOfLife;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class BaloonPan extends JPanel
{
	int x;
	int y;
	int dx = 5;
	int dy = 5;
	int diameter;
	SPanel sp;
	BallThread bThread;
	BaloonPan self = this;
	int xCentr;
	int yCentr;
	boolean toRemove = false;

	public BaloonPan(int x1, int y1, int DiameterOfBall, SPanel mainpan)
	{
		this.x = x1;
		this.y = y1;
		this.diameter = DiameterOfBall;
		setBounds(x, y, diameter, diameter);
		this.sp = mainpan;
		dx = (int)(-10 + Math.random() * 20) + 1;
		dy = (int)(-10 + Math.random() * 20) + 1;
		repaint();
		setOpaque(false);
		bThread = new BallThread();
		bThread.start();
		
		Timer timer = new Timer(1000, new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Timer tim = new Timer(1000, new ActionListener()
				{
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						if(diameter < 10)
						{
							sp.remove(self);
							sp.baloons.remove(self);
							bThread.stop();
							sp.repaint();
						}
						else
						{
							diameter -= 1;
							repaint();
							sp.repaint();
						}
					}
				});
				tim.start();
			}
		});
		timer.start();
		
		addMouseListener(new MouseListener()
		{

			@Override
			public void mouseReleased(MouseEvent e)
			{}

			@Override
			public void mousePressed(MouseEvent e)
			{
				sp.remove(self);
				sp.baloons.remove(self);
				bThread.stop();
				if(e.getButton() == e.BUTTON3)
				{
					for(int i = 0; i < 8; i++)
					{
						int smallBallRadius = (int)diameter/2;
						BaloonPan bal = new BaloonPan(x + i * 10, y + i * 10, smallBallRadius, sp);
						sp.baloons.add(bal);
						sp.add(bal);
					}
				}
				sp.repaint();
			}

			@Override
			public void mouseExited(MouseEvent e)
			{}

			@Override
			public void mouseEntered(MouseEvent e)
			{}

			@Override
			public void mouseClicked(MouseEvent e)
			{}
		});
	}

	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D gg = (Graphics2D) g;
		gg.setColor(Color.BLACK);
		gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		gg.fillOval(1, 1, diameter - 3, diameter - 3);
	}

	public void move()
	{
		if(x + dx + diameter >= sp.width  || x + dx <= 0)
		{
			dx = -dx;
		}
		if(y + dy + diameter >= sp.height  || y + dy <= 0 )
		{
			dy = -dy;
		}
		if(x + dx + diameter >= sp.width && x + diameter >= sp.width)
		{
			x = sp.width - diameter;
		}
		if(y + dy + diameter >= sp.height && y + diameter >= sp.height)
		{
			y = sp.height - diameter;
		}
		if(x < 0)
		{
			x = 0;
		}
		if(y < 0)
		{
			y = 0;
		}

		x += dx;
		y += dy;
		setBounds(x, y, diameter, diameter);
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
					move();
					sleep(20);
				}
			} 
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
