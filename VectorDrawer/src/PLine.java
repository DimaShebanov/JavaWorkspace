import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class PLine 
{
	int x0 = 0;
	int y0 = 0;
	int xend = 0;
	int yend = 0;
	int color = 0;
	int stroke = 0;
	
	
	public PLine(int x0, int y0, int xend, int yend, int color, int stroke) 
	{
		this.x0 = x0;
		this.y0 = y0;
		this.xend = xend;
		this.yend = yend;
		this.color = color;
		this.stroke = stroke;
	}
	
	public void paint(Graphics2D gg)
	{
		gg.setColor(new Color(color));
		gg.setStroke(new BasicStroke(stroke));
		gg.drawLine(x0, y0, xend, yend);
	}
}
