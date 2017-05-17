import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Baloon
{
	int x;
	int y;
	int dx;
	int dy;
	private int radius;
	Color clr;
	SPanel sp;
	
	
	public Baloon(int x, int y, SPanel sp)
	{
		this.x = x;
		this.y = y;
		dx = (int)(-10 + Math.random() * 20);
		dy = (int)(-10 + Math.random() * 20);
		this.sp = sp;
		clr = new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
		this.radius = (int)(Math.random() * 50);
	}

	public void draw(Graphics2D gg)
	{
		gg.setRenderingHint ( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
		gg.setColor(clr);
		gg.fillOval(x, y, radius, radius);
	}

	public void move()
	{
		if(x + dx + radius >= sp.getWidth() || x + dx <= 0)
		{
			dx = -dx;
		}
		if(y + dy + radius >= sp.getHeight() || y + dy <= 0 )
		{
			dy = -dy;
		}


		x += dx;
		y += dy;
	}
}
