
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class PPanel extends JPanel implements MouseListener, MouseMotionListener
{
	int x = 0;
	int y = 0;
	
	PData data = null;

	ArrayList<Figure> AListLines = null;

	public PPanel(PCommand cmd)
	{
		cmd.pp = this;
		this.data = cmd.data;
		setBounds(0,30,490,530);
		AListLines = new ArrayList<Figure>();

		setComponentPopupMenu(new MyPop(cmd));

		addMouseListener(this);
		addMouseMotionListener(this);
	}

	@Override
	public void paint(Graphics g) 
	{
		super.paint(g);
		Graphics2D gg = (Graphics2D) g;
		for (Figure p : AListLines) 
		{
			p.paint(gg);
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) 
	{
		x = e.getX();
		y = e.getY();
	}
	
	@Override
	public void mouseReleased(MouseEvent e) 
	{
		if(data.type == 0)
			return;
		
		int width = Math.abs(e.getX() - x);
		int height = Math.abs(e.getY() - y);
		if(e.getX() - x < 0)
		{
			x = e.getX();
		}
		if(e.getY() - y < 0)
		{
			y = e.getY();
		}
			

		AListLines.add(new Figure(x, y, width, height, data));
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) 
	{
		if(data.type != 0)
			return;

		AListLines.add(new Figure(x, y, e.getX()-x, e.getY()-y, data));
		x = e.getX();
		y = e.getY();
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {}
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}
