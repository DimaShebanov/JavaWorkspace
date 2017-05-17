package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import model.MFigure;
import model.NastedSquare;
import view.control.PContextMenu;

public class FPanelDraw  extends JPanel implements MouseListener, MouseMotionListener
{
	Boolean ischeckSizeLeftTopCorner = false; 
	Boolean ischeckSizeLeftSide = false; 
	Boolean ischeckSizeLeftBottomCorner= false; 
	Boolean ischeckSizeBottomSide = false; 
	Boolean ischeckSizeRightBottomCorner = false; 
	Boolean ischeckSizeRightSide = false; 
	Boolean ischeckSizeRightTopCorner = false; 
	Boolean ischeckSizeTopSide = false; 
	Boolean isCheked = false;
	Boolean isPresed = false;
	
	PContextMenu pContextMenu= null;
	Point p = null;
	public Figure moveSq=null;
	
	public FPanelDraw(FFrame fFrame) 
	{
		setLayout(null);
		this.setPreferredSize(new Dimension(600,600));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.setBackground(Color.WHITE);
		this.setVisible(true);
		fFrame.add(this,BorderLayout.EAST);
	}
	
	public ArrayList<MFigure> getMemento()
	{
		ArrayList<MFigure> pp = new ArrayList<MFigure>();
		System.out.println( getComponentCount());
		for (Component cc : getComponents())
		{
			pp.add( ((Figure)cc).getMemento() );
		}
		return pp;
	}
	public void setMemento(ArrayList<MFigure> pp)
	{
		removeAll();
		for (MFigure f : pp)
		{
			add( new Figure(f) );
		}
		repaint();
	}
	
	public void SetPContextMenuObject(PContextMenu pContextMenu)
	{
		this.pContextMenu = pContextMenu;
	}
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
	}
	@Override
	public void mouseClicked(MouseEvent e){}		
	@Override
	public void mouseEntered(MouseEvent e){}

	@Override
	public void mouseExited(MouseEvent e){}
	@Override
	public void mousePressed(MouseEvent e)
	{
		isPresed= true;
		p = e.getPoint();

		if (SwingUtilities.isRightMouseButton(e))
			pContextMenu.show(this, p.x, p.y);
		
		Component []  squares = getComponents();
		for (int i = 0; i < squares.length; i++) 
		{
			Figure square =(Figure)squares[i];
			isCheked 					 = square.checkPosition(p.x,p.y);

			ischeckSizeLeftTopCorner 	 = square.checkSizeLeftTopCorner(p.x, p.y); 
			ischeckSizeLeftSide			 = square.checkSizeLeftSide(p.x, p.y); 
			ischeckSizeLeftBottomCorner  = square.checkSizeLeftBottomCorner(p.x, p.y); 
			ischeckSizeBottomSide		 = square.checkSizeBottomSide(p.x, p.y); 
			ischeckSizeRightBottomCorner = square.checkSizeRightBottomCorner(p.x, p.y); 
			ischeckSizeRightSide 		 = square.checkSizeRightSide(p.x, p.y); 
			ischeckSizeRightTopCorner 	 = square.checkSizeRightTopCorner(p.x, p.y); 
			ischeckSizeTopSide 			 = square.checkSizeTopSide(p.x, p.y); 
			if(isCheked)
			{
				isPresed=false;
				moveSq = square;
				break;
			}
			if(ischeckSizeLeftTopCorner||ischeckSizeLeftSide||ischeckSizeLeftBottomCorner||ischeckSizeBottomSide||ischeckSizeRightBottomCorner||ischeckSizeRightSide||ischeckSizeRightTopCorner||ischeckSizeTopSide)
			{
				isPresed=false;
				moveSq = square;
				break;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		CreateSq(e);
		NullAllVar();
	}

	public void CreateSq(MouseEvent e)
	{
		Rectangle r = null;
		if(isPresed)
		{
			int height=e.getY()-(int)p.getY();
			int width= e.getX()-(int)p.getX();

			if(height<0&&width<0)
			{
				height = -height;
				width =- width;
				r = new Rectangle(p.x-width, p.y-height, width, height);
			}
			else if(width<0)
			{
				width=- width;
				r = new Rectangle(p.x-width, p.y, width, height);
			}
			else if(height<0)
			{
				height= -height;
				r = new Rectangle(p.x, p.y-height, width, height);
			}
			else 
			{
				r = new Rectangle(p.x, p.y, width, height);
			}
			this.add(new Figure(r));
		}
		repaint();
	}
	int prevX = 0;
	int prevY = 0;
	@Override
	public void mouseDragged(MouseEvent e)
	{
		if(isCheked)
		{
		int	x= e.getX();
		int	y= e.getY(); 
			if(prevX!=0&&prevY!=0)
			{
				moveSq.movePosition(x - prevX,y - prevY );
			}
			prevX = x;
			prevY = y;
		}
		if(ischeckSizeLeftTopCorner)
		{
			int	x= e.getX();
			int	y= e.getY(); 
			if(prevX!=0&&prevY!=0)
			{
				moveSq.moveSizeLeftTopCorner( prevX - x, prevY - y);
			}
			prevX = x;
			prevY = y;
		}
		if(ischeckSizeLeftSide)
		{
			int	x= e.getX();
			int	y= e.getY(); 
			if(prevX!=0&&prevY!=0)
			{
				moveSq.moveSizeLeftSide( prevX - x ,y - prevY );
			}
			prevX = x;
			prevY = y;
		}
		if(ischeckSizeLeftBottomCorner)
		{
			int	x= e.getX();
			int	y= e.getY(); 
			if(prevX!=0&&prevY!=0)
			{
				moveSq.moveSizeLeftBottomCorner( prevX - x ,y - prevY );
			}
			prevX = x;
			prevY = y;
		}
		if(ischeckSizeBottomSide)
		{
			int	x= e.getX();
			int	y= e.getY(); 
			if(prevX!=0&&prevY!=0)
			{
				moveSq.moveSizeBottomSide(x - prevX,y - prevY );
			}
			prevX = x;
			prevY = y;
		}
		if(ischeckSizeRightBottomCorner)
		{
			int	x= e.getX();
			int	y= e.getY(); 
			if(prevX!=0&&prevY!=0)
			{
				moveSq.moveSizeRightBottomCorner(x - prevX,y - prevY );
			}
			prevX = x;
			prevY = y;
		}
		if(ischeckSizeRightSide)
		{
			int	x= e.getX();
			int	y= e.getY(); 
			if(prevX!=0&&prevY!=0)
			{
				moveSq.moveSizeRightSide(x - prevX,y - prevY );
			}
			prevX = x;
			prevY = y;
		}
		if(ischeckSizeRightTopCorner)
		{
			int	x= e.getX();
			int	y= e.getY(); 
			if(prevX!=0&&prevY!=0)
			{
				moveSq.moveSizeRightTopCorner(x - prevX,prevY -y );
			}
			prevX = x;
			prevY = y;
		}
		if(ischeckSizeTopSide)
		{
			int	x= e.getX();
			int	y= e.getY(); 
			if(prevX!=0&&prevY!=0)
			{
				moveSq.moveSizeTopSide(x - prevX,prevY -y );
			}
			prevX = x;
			prevY = y;
		}
		if(moveSq!=null)
		{
			moveSq.ChengesPositionNastedSquare();
		}
	}
	@Override
	public void mouseMoved(MouseEvent e) 
	{
		int  getX = e.getX();
		int  getY = e.getY();

		Component []  squares = getComponents();
		for (int i = 0; i < squares.length; i++) 
		{
			Figure square =(Figure)squares[i];
			if(square.checkFocus(getX, getY))
			{
				for (NastedSquare nastedSquare : square.nastedSq) 
				{
					nastedSquare.setVisible(true);
				}
			}
			else
			{
				for (NastedSquare nastedSquare : square.nastedSq) 
				{
					nastedSquare.setVisible(false);
				}
			}
		}
	}
	private void NullAllVar()
	{
		ischeckSizeLeftTopCorner = false; 
		ischeckSizeLeftSide = false; 
		ischeckSizeLeftBottomCorner= false; 
		ischeckSizeBottomSide = false; 
		ischeckSizeRightBottomCorner = false; 
		ischeckSizeRightSide = false; 
		ischeckSizeRightTopCorner = false; 
		ischeckSizeTopSide = false;
		prevX = 0;
		prevY = 0;
		isCheked= false;
		isPresed = false;
	}
}
