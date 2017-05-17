import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Figure extends JPanel
{
	int x;
	int y;
	int width;
	int height;
	int color;
	int stroke;
	
	public Figure(int x, int y, int width, int height, int color, int stroke)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.stroke = stroke;
		

	}
	
	
	
	public void draw(Graphics2D gg)
	{
		gg.setColor(new Color(color));
		gg.setStroke(new BasicStroke(stroke));
		gg.fillRect(x, y, width, height);
		
	}
}
