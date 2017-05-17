import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class xzPanel extends JPanel implements MouseListener, MouseMotionListener
{
	int x = 0;
	int y = 0;

	public xzPanel()
	{		
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		x = e.getX();
		y = e.getY();
	}

	@Override
	public void mouseDragged(MouseEvent e) 
	{
		Graphics2D g = (Graphics2D) getGraphics();
		g.drawLine(x, y, e.getX(), e.getY());
		//g.fillOval(x, y, 20, 20);
		x = e.getX();
		y = e.getY();		
	}

	@Override
	public void mouseMoved(MouseEvent e) {}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

}
