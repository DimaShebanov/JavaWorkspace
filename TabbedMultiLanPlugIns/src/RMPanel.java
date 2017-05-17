
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class RMPanel extends JPanel implements MouseListener
{
	Point p = null;
	public RMData data = new RMData();
	public RMCommand rmc;
	public Figure curfig = null;

	public RMPanel()
	{
		setLayout(null);
		setBounds(201, 100, 600, 500);
		addMouseListener(this);
	}

	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.black);
		g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		curfig = null;
		p = e.getPoint();
		requestFocus();
	}
	@Override
	public void mouseReleased(MouseEvent e)
	{
		Rectangle r = new Rectangle(p, new Dimension(e.getX()-(int)p.getX(), e.getY()-(int)p.getY()));
		add( new Figure(r, data, rmc) );
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent arg0){}
	@Override
	public void mouseEntered(MouseEvent arg0){}
	@Override
	public void mouseExited(MouseEvent arg0){}
}
