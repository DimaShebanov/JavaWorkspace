package tests;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;

public class BaloonPan extends JPanel
{
	int x;
	int y;
	int dx;
	int dy;
	int diameter;
	SPanel sp;
	BallThread bThread;
	BaloonPan self = this;
	int xCentr;
	int yCentr;

	public BaloonPan(int x, int y, int DiameterOfBall, SPanel mainpan, int dx, int dy)
	{
		this.x = x;
		this.y = y;
		this.diameter = DiameterOfBall;
		setBounds(x, y, diameter, diameter);
		this.sp = mainpan;
		this.dx = dx;
		this.dy = dy;
		repaint();
		setOpaque(false);
//		bThread = new BallThread();
//		bThread.start();
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
		for (BaloonPan bal : sp.baloons)
		{
			if(sp.baloons.size() > 1 && bal != self)
			{
				xCentr = x + diameter / 2;
				yCentr = y + diameter / 2;
				bal.xCentr = bal.x + bal.diameter / 2;
				bal.yCentr = bal.y + bal.diameter / 2;


				int l = (int) Math.sqrt( Math.pow( ( (bal.xCentr) - (xCentr) ) , 2) + Math.pow( (bal.yCentr) - (yCentr), 2));


				if (l <= (bal.diameter / 2) + (diameter / 2) )
				{
					dx = - dx;
					dy = - dy;
				}
			}
		}
		x = x + dx;
		y = y + dy;
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
