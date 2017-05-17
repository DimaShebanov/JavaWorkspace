
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class PPanel extends JPanel implements MouseListener, MouseMotionListener
{
	int x = 0;
	int y = 0;
	BufferedImage bi = new BufferedImage(500, 500, BufferedImage.SCALE_DEFAULT);
	PData data = null;

	public PPanel(PCommand cmd)
	{
		this.data = cmd.data;
		cmd.pp = this;
		setBounds(0,0,500,500);
		Graphics2D gg = (Graphics2D) bi.getGraphics();
		gg.setColor(Color.WHITE);
		gg.fillRect(0, 0, 500, 500);
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	@Override
	public void paint(Graphics g) 
	{
		super.paint(g);
		Graphics2D gg = (Graphics2D) g;
		gg.drawImage(bi, null, 0, 0);
	}

	@Override
	public void mouseDragged(MouseEvent e) 
	{
		Graphics2D gg = (Graphics2D) bi.getGraphics();
		gg.setColor(data.clr);
		gg.setStroke(data.strk);
		gg.drawLine(x, y, e.getX(), e.getY());
		x = e.getX();
		y = e.getY();
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		x = e.getX();
		y = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
