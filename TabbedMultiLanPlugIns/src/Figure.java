
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class Figure extends JPanel implements MouseListener, MouseMotionListener
{
	public RMData data = null;
	public Rectangle r;
	int dx = 0;
	int dy = 0;

	public Figure(Rectangle r, RMData data, RMCommand rmc)
	{
		setLayout(null);
		setOpaque(false);

		if(r.width < 0)
		{
			r.x += r.width;
			r.width = Math.abs(r.width);
		}
		if(r.height < 0)
		{
			r.y += r.height;
			r.height = Math.abs(r.height);
		}

		this.r = r;
		this.data = data.dublicate();


		setBounds(r);


		addMouseListener(this);
		addMouseMotionListener(this);
	}

	@Override
	public void paint(Graphics g)
	{
		Graphics2D gg = (Graphics2D) g;
		gg.setStroke(new BasicStroke(data.stroke));
		gg.setColor( data.col );
		gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(data.type == null)
		{
			gg.drawLine(5, 5, getWidth() - 5, getHeight() - 5);
		}
		else
		{
			data.type.draw(gg, this);
		}
		gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
		super.paint(g);

	}
	
	
	
	@Override
	public void mouseDragged(MouseEvent e)
	{
		int x = (int) r.getX();
		int y = (int) r.getY();

		x += e.getX() - dx;
		y += e.getY() - dy;

		r.setLocation(x, y);
		setBounds(r);
	}

	@Override
	public void mouseMoved(MouseEvent arg0)
	{}

	@Override
	public void mousePressed(MouseEvent e)
	{
		requestFocus();
		dx = e.getX();
		dy = e.getY();
		RMPanel rmp = (RMPanel) getParent();
		rmp.curfig = this;
		if(e.getButton() == e.BUTTON3)
		{
			getComponentPopupMenu().show();
		}

	}
	@Override
	public void mouseReleased(MouseEvent e){}
	@Override
	public void mouseClicked(MouseEvent arg0){}
	@Override
	public void mouseEntered(MouseEvent arg0){}
	@Override
	public void mouseExited(MouseEvent arg0){}
}
