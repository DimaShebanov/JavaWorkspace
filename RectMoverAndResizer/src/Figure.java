import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Figure extends JPanel implements FocusListener
{
	int x;
	int y;
	int width;
	int height;
	int color;
	int stroke;
	ArrayList<Mark> marks = new ArrayList<>();
	String type;
	
	public Figure(int x, int y, int width, int height, int color, int stroke, String type)
	{

		this.x = x;
		this.y = y;
		this.width = Math.abs(width);
		this.height = Math.abs(height);
		this.color = color;
		this.stroke = stroke;
		setLayout(null);
		this.type = type;
		if(width < 0)
		{
			this.x = x - this.width;
		}

		if(height < 0)
		{
			this.y = y - this.height;
		}


		setBounds(this.x, this.y, this.width, this.height);
		repaint();
		addFocusListener(this);
	}

	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D gg = (Graphics2D) g;
		gg.setStroke(new BasicStroke(stroke));
		gg.setColor(new Color(color));
		switch(type)
		{
			case "Rect": gg.drawRect(5, 5, width - 10, height - 10);			break;
			case "Line": gg.drawLine(5, 5, width - 10, height - 10); 	break;
			case "Oval": gg.drawOval(5, 5, width - 10, height - 10);  System.out.println("sds");  		break;
			case "RoundRect": gg.drawRoundRect(5, 5, width - 5, height - 5, 30, 30); break;	
		}
	}


	public void moveRect(int newx, int newy)
	{
		x = newx;
		y = newy;
		setBounds(x, y, width, height);
		repaint();
	}

	@Override
	public void focusGained(FocusEvent e)
	{
		setCursor(new Cursor(Cursor.MOVE_CURSOR));
		putMarks();

	}

	@Override
	public void focusLost(FocusEvent e)
	{
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		removeMarks();
	}

	public void wider(int newx)
	{
		width = newx;
		setBounds(x, y, width, height);
	}
	
	
	public void longer(int newy)
	{
		height = newy;
		setBounds(x, y, width, height);

	}
	
	public void shorter(int newy)
	{
		height -= newy;
		y += newy;
		setBounds(x, y, width, height);

	}
	
	public void narrow(int newx)
	{
		width -= newx;
		x += newx;
		setBounds(x, y, width, height);

	}
	
	
	private void putMarks()
	{
		int size = (width + height) / 20;
		int[] cursors = 
			{
					0,
					Cursor.NW_RESIZE_CURSOR, 
					Cursor.N_RESIZE_CURSOR,
					Cursor.NE_RESIZE_CURSOR,
					Cursor.W_RESIZE_CURSOR,
					Cursor.E_RESIZE_CURSOR,
					Cursor.SW_RESIZE_CURSOR,
					Cursor.S_RESIZE_CURSOR,
					Cursor.SE_RESIZE_CURSOR
			};

		Mark mrk = null;
		int positionOfMark = 1;
		while(positionOfMark <= 8 )
		{
			switch (positionOfMark)
			{
				case 1:
					mrk = new Mark(0, 0,  size, this, cursors[positionOfMark]);
					add(mrk);
					break;

				case 2:
					mrk = new Mark((width - size) / 2 , 0, size , this, cursors[positionOfMark]);
					add(mrk);
					break;

				case 3:
					mrk = new Mark(width - size, 0, size , this, cursors[positionOfMark]);
					add(mrk);
					break;

				case 4:
					mrk = new Mark(0, (height - size) / 2, size , this, cursors[positionOfMark]);
					add(mrk);
					break;

				case 5:
					mrk = new Mark(width - size, (height - size) / 2 , size , this, cursors[positionOfMark]);
					add(mrk);
					break;

				case 6:
					mrk = new Mark(0, (height - size), size , this, cursors[positionOfMark]);
					add(mrk);
					break;

				case 7:
					mrk = new Mark((width - size) / 2, height - size, size , this, cursors[positionOfMark]);
					add(mrk);
					break;

				case 8:
					mrk = new Mark(width - size, height - size, size , this, cursors[positionOfMark]);
					add(mrk);
					break;

				default:
					break;
			}
			positionOfMark++;
		}
		repaint();
	}


	private void removeMarks()
	{
		removeAll();
		repaint();
	}

	class Mark extends JPanel implements MouseMotionListener, MouseListener
	{
		int x;
		int y;
		int size;
		int cursor;
		Figure fig;
		
		int dxclick = 0;
		int dyclick = 0;
		
		public Mark(int MRKx, int MRKy, int size, Figure fig, int cursor)
		{
			this.x = MRKx;
			this.y = MRKy;
			this.size = size;
			this.cursor = cursor;
			this.fig = fig;
			
			setBounds(x, y, size, size);
			setBackground(Color.red);
			setCursor(new Cursor(cursor));
			addMouseMotionListener(this);
			addMouseListener(this);

			
		}
		
		
		
		private void MoveMark(int newx, int newy)
		{
			switch (cursor)
			{
				case Cursor.E_RESIZE_CURSOR: 			wider(newx); 					break;
				case Cursor.S_RESIZE_CURSOR: 			longer(newy);					break;
				case Cursor.N_RESIZE_CURSOR: 			shorter(newy); 					break;
				case Cursor.W_RESIZE_CURSOR: 			narrow(newx); 					break;
				
				case Cursor.SE_RESIZE_CURSOR: 			wider(newx);  	longer(newy); 	break;
				case Cursor.NE_RESIZE_CURSOR: 			shorter(newy);	wider(newx); 	break;
				case Cursor.SW_RESIZE_CURSOR: 			shorter(newy);	narrow(newx); 	break;
				case Cursor.NW_RESIZE_CURSOR: 			longer(newy);	narrow(newx); 	break;
				default:																break;
			}
			repaint();
		}
		
		
		@Override
		public void mouseMoved(MouseEvent e)
		{}
		
		@Override
		public void mouseDragged(MouseEvent e)
		{
			int newx = x + e.getX();
			int newy = y + e.getY();
			MoveMark(newx, newy);	
		}



		@Override
		public void mouseClicked(MouseEvent arg0)
		{}



		@Override
		public void mouseEntered(MouseEvent arg0)
		{}



		@Override
		public void mouseExited(MouseEvent arg0)
		{}



		@Override
		public void mousePressed(MouseEvent arg0)
		{}



		@Override
		public void mouseReleased(MouseEvent arg0)
		{
			removeMarks();
			putMarks();
		}
	}
}
