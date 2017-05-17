import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GrPan extends JPanel
{
	JButton draw;
	Graph graph;
	int width = 600;
	int height = 600;
	Graph.Vertex choosedVert = null;
	VMoveLst Mouselst = new VMoveLst();


	public GrPan(Graph graph)
	{
		this.graph = graph;
		setBounds(0, 0, width, height);
		setLayout(null);
		draw = new JButton("Draw");
		draw.setBounds(0, 0, 70, 30);
		add(draw);
		graph.setVertexes(width, height);

		draw.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				graph.setVertexes(width, height);
				repaint();
			}
		});

		addMouseListener(Mouselst);
		addMouseMotionListener(Mouselst);
	}

	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D gg = (Graphics2D) g;
		graph.drawGR(gg);
	}



	class VMoveLst implements MouseMotionListener, MouseListener
	{

		int dyfromtop = 0;
		int dxfromtop = 0;
		
		
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
			int xofpress = e.getX();
			int yofpress = e.getY();


			choosedVert = graph.root;
			while(choosedVert != null)
			{
				int radius = choosedVert.diameter / 2;
				int ycentr = choosedVert.y + radius;
				int xcentr = choosedVert.x + radius;

				if( xofpress <= xcentr + radius && xofpress >= xcentr - radius)
				{
					if(yofpress <= ycentr + radius && yofpress >= ycentr - radius)
					{
						break;
					}
				}
				choosedVert = choosedVert.next;
			}
			
			dxfromtop = xofpress - choosedVert.x;
			dyfromtop = yofpress - choosedVert.y;
		}

		@Override
		public void mouseReleased(MouseEvent e)
		{
			choosedVert = null;
		}

		@Override
		public void mouseDragged(MouseEvent e)
		{
			
			int ex = e.getX();
			int ey = e.getY();
			
			choosedVert.x = ex - dxfromtop;
			choosedVert.y = ey - dyfromtop;
			repaint();
			
		}

		@Override
		public void mouseMoved(MouseEvent e)
		{
			// TODO Auto-generated method stub

		}

	}
}
