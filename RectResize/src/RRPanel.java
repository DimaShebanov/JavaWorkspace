import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class RRPanel extends JPanel
{
	ArrayList<Figure> figures = new ArrayList<>();
	Figure chosenFIG = null;
	int x = 0;
	int y = 0;

	int dxFromCorner = 0;
	int dyFromCorner = 0;

	MouseListenerRM mouselst = new MouseListenerRM();
	public RRPanel()
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
//		for (Figure figure : figures)
//		{
//			figure.draw(gg);
//		}
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
					chosenFIG.requestFocus();
					repaint();
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
			int width = e.getX() - x;
			int height = e.getY() - y;
			if(width < 30 || height < 30)
			{
				return;
			}
			Figure fig = new Figure(x, y, width, height, Color.black.getRGB(), 1);
			figures.add(fig);
			repaint();
		}

		@Override
		public void mouseDragged(MouseEvent e)
		{
			if(chosenFIG != null)
			{
				int x = e.getX();
				int y = e.getY();

				
				
				if(x < chosenFIG.x + chosenFIG.width && chosenFIG.width < 30)
				{
					return;
				}
				
				if(y < chosenFIG.y + chosenFIG.height && chosenFIG.height < 30)
				{
					return;
				}
				
				
				if(y >= chosenFIG.y + chosenFIG.height - 20)
				{
					chosenFIG.longer(y);
				}
				if(x >= chosenFIG.x + chosenFIG.width - 20)
				{

					chosenFIG.wider(x);
				}
				if(y <= chosenFIG.y + 20)
				{
					
					chosenFIG.shorter(y);
				}
				if(x <= chosenFIG.x + 20)
				{
					chosenFIG.narrow(x);
				}
				repaint();
				
			}
		}

		@Override
		public void mouseMoved(MouseEvent e)
		{}

	}
}
