import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class BaloonPan extends JPanel
{
	int x;
	int y;
	int dx = 5;
	int dy = 5;
	private int radius = 30;
	SPanel sp;
	public BaloonPan(int x1, int y1, SPanel mainpan)
	{
		this.x = x1;
		this.y = y1;
		setBounds(x, y, radius, radius);
		this.sp = mainpan;
		repaint();
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D gg = (Graphics2D) g;
		gg.fillOval(0, 0, radius, radius);
	}
	
	public void move()
	{
		if(x + dx + radius >= sp.getWidth()  || x + dx <= 0)
		{
			dx = -dx;
		}
		if(y + dy + radius >= sp.getHeight()  || y + dy <= 0 )
		{
			dy = -dy;
		}
		
		x += dx;
		y += dy;
		setBounds(x, y, radius, radius);
	}
}
