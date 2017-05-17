package frame.controls;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;

public class OwnButton extends JButton
{
	String type;
	public OwnButton(String type)
	{
		this.type = type;
	}
	
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D gg = (Graphics2D) g;
		gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		switch(type)
		{
			case "rect": gg.drawRect(5, 5, getWidth() - 10, getHeight() - 10);			 		break;
			case "oval": gg.drawLine(5, 5, getWidth() - 10, getHeight() - 10); 	         		break;
			case "line": gg.drawOval(5, 5, getWidth() - 10, getHeight() - 10);    		 		break;
			case "rrect": gg.drawRoundRect(5, 5, getWidth() - 10, getHeight() - 10, 30, 30); 	break;	
		}
		gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

	}
}
