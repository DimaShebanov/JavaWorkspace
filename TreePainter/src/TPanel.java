import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class TPanel extends JPanel
{
	BufferedImage bi = new BufferedImage(680, 600, BufferedImage.SCALE_DEFAULT);
	
	public TPanel()
	{
		setBounds(0, 30, 680, 600);
		setLayout(null);
		Graphics2D gg = (Graphics2D) bi.getGraphics();
		gg.setColor(Color.white);
		gg.fillRect(0, 0, 680, 600);
	}
	
	
	@Override
	public void paint(Graphics g) 
	{
		super.paint(g);
		Graphics2D gg = (Graphics2D) g;
		gg.drawImage(bi, null, 0, 0);
	}
	
	

}
