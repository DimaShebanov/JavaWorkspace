import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class RMPanel extends JPanel
{
	ArrayList<Figure> figures = new ArrayList<>();
	Figure chosenFIG = null;
	int x = 0;
	int y = 0;
	
	int dxFromCorner = 0;
	int dyFromCorner = 0;
	
	MouseListenerRM mouselst = new MouseListenerRM();
	public RMPanel()
	{
		setLayout(null);
		setBounds(0, 0, 600, 600);
		addMouseListener(mouselst);
		addMouseMotionListener(mouselst);

	}


	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D gg = (Graphics2D) g;
		for (Figure figure : figures)
		{
			figure.draw(gg);
		}
	}

	class MouseListenerRM implements MouseListener,MouseMotionListener
	{

		@Override
		public void mouseClicked(MouseEvent e)
		{}

		@Override
		public void mouseEntered(MouseEvent e)
		{}

		@Override
		public void mouseExited(MouseEvent e)
		{}

		@Override
		public void mousePressed(MouseEvent e)
		{
			int xOfPress = e.getX();
			int yOfPress = e.getY();
			for (Figure figure : figures)
			{
				if(xOfPress >= figure.x && xOfPress <= figure.x + figure.width && yOfPress >= figure.y && yOfPress <= figure.y + figure.height)
				{
					chosenFIG = figure;
					dxFromCorner = xOfPress - figure.x;
					dyFromCorner = yOfPress - figure.y;
					break;
				}
			}
			if(chosenFIG == null)
			{
				x = xOfPress;
				y = yOfPress;
			}
		}

		@Override
		public void mouseReleased(MouseEvent e)
		{
			if(chosenFIG != null)
			{
				chosenFIG = null;
				return;
			}
			Figure fig = new Figure(x, y, e.getX() - x, e.getY() - y, Color.black.getRGB(), 1);
			figures.add(fig);
			repaint();
		}

		@Override
		public void mouseDragged(MouseEvent e)
		{
			if(chosenFIG != null)
			{
				chosenFIG.x = e.getX() - dxFromCorner;
				chosenFIG.y = e.getY() - dyFromCorner;
				repaint();
			}
		}

		@Override
		public void mouseMoved(MouseEvent e)
		{

		}

	}
}
