import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class RMPanel extends JPanel
{
	ArrayList<Figure> figures = new ArrayList<>();
	Figure chosenFIG = null;
	int x = 0;
	int y = 0;
	
	int dxFromCorner = 0;
	int dyFromCorner = 0;
	String currentType = "Rect";
	JButton oval;
	
	
	
	MouseListenerRM mouselst = new MouseListenerRM();
	public RMPanel()
	{
		setLayout(null);
		setBounds(0, 0, 600, 600);
		
		oval = new JButton("Oval");
		oval.setBounds(0, 0, 50, 50);
		add(oval);
		oval.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(chosenFIG != null)
				{
					chosenFIG.type = "Oval";
					chosenFIG.repaint();
				}
			}
		});
		
		
		addMouseListener(mouselst);
		addMouseMotionListener(mouselst);
		
		
	}


	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D gg = (Graphics2D) g;
		
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
					chosenFIG.requestFocus();
					break;
				}
				else
				{
					chosenFIG = null;
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
//			if(chosenFIG != null)
//			{
//				chosenFIG = null;
//				return;
//			}
			if (chosenFIG == null)
			{
				Figure fig = new Figure(x, y, e.getX() - x, e.getY() - y, Color.black.getRGB(), 5, currentType);
				figures.add(fig);
				add(fig);
				repaint();
			}
		}

		@Override
		public void mouseDragged(MouseEvent e)
		{
			if(chosenFIG != null)
			{
				int newx = e.getX() - dxFromCorner;
				int newy = e.getY() - dyFromCorner;
				chosenFIG.moveRect(newx, newy);
				repaint();
			}
		}

		@Override
		public void mouseMoved(MouseEvent e)
		{

		}

	}
}
