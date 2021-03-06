package frame;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.JRootPane;

import frame.controls.RMPopUp;
import logic.RMCommand;
import model.MFigure;
import model.RMData;

public class Figure extends JPanel implements FocusListener, MouseListener, MouseMotionListener
{
	public RMData data = null;
	public Rectangle r;
	int dx = 0;
	int dy = 0;

	public Figure(Rectangle r, RMData data, RMCommand rmc)
	{
		setLayout(null);
		setComponentPopupMenu(new RMPopUp( rmc, rmc.local));
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
		addFocusListener(this);
		addMouseMotionListener(this);
	}

	@Override
	public void paint(Graphics g)
	{
		Graphics2D gg = (Graphics2D) g;
		gg.setStroke(new BasicStroke(data.stroke));
		gg.setColor( data.col );
		gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		switch(data.type)
		{
			case 1: gg.drawRect(10, 10, getWidth() - 20, getHeight() - 20);			 break;
			case 2: gg.drawLine(10, 10, getWidth() - 20, getHeight() - 20); 	         break;
			case 3: gg.drawOval(10, 10, getWidth() - 20, getHeight() - 20);    		 break;
			case 4: gg.drawRoundRect(10, 10, getWidth() - 20, getHeight() - 20, 30, 30); break;	
		}
		gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
		super.paint(g);

	}
	
	
	
	public MFigure getMemento()
	{
		MFigure mfig = new MFigure();
		mfig.x = r.x;
		mfig.y = r.y;
		mfig.width = r.width;
		mfig.height = r.height;
		mfig.type = data.type;
		mfig.stroke = data.stroke;
		mfig.color = data.col.getRGB();
		
		return mfig;
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


	@Override
	public void focusGained(FocusEvent e)
	{
		setCursor(new Cursor(Cursor.MOVE_CURSOR));
		putMarks();

	}

	@Override
	public void focusLost(FocusEvent e)
	{
		if(e.getOppositeComponent() != null)
		{
			if (e.getOppositeComponent().getClass() == JRootPane.class)
			{
				requestFocusInWindow();
			}
		}
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		removeMarks();

	}

	public void wider(int newx)
	{
		r.setSize(newx, (int) r.getHeight());
		setBounds(r);
	}


	public void longer(int newy)
	{
		r.setSize((int) r.getWidth(), newy);
		setBounds(r);
	}

	public void shorter(int newy)
	{
		int newheight = (int) (r.getHeight() - newy);
		int y = (int) (r.getY() + newy);
		
		r.setBounds((int) r.getX(), y, (int) r.getWidth(), newheight);
		
		setBounds(r);
	}

	public void narrow(int newx)
	{
		int newwidth = (int) (r.getWidth() - newx);
		int x = (int) (r.getX() + newx);

		r.setBounds(x, (int) r.getY(), newwidth, (int) r.getHeight());

		setBounds(r);
	}

	private void putMarks()
	{
		int size = 10;
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
					mrk = new Mark((getWidth() - size) / 2 , 0, size , this, cursors[positionOfMark]);
					add(mrk);
					break;

				case 3:
					mrk = new Mark(getWidth() - size, 0, size , this, cursors[positionOfMark]);
					add(mrk);
					break;

				case 4:
					mrk = new Mark(0, (getHeight() - size) / 2, size , this, cursors[positionOfMark]);
					add(mrk);
					break;

				case 5:
					mrk = new Mark(getWidth() - size, (getHeight() - size) / 2 , size , this, cursors[positionOfMark]);
					add(mrk);
					break;

				case 6:
					mrk = new Mark(0, (getHeight() - size), size , this, cursors[positionOfMark]);
					add(mrk);
					break;

				case 7:
					mrk = new Mark((getWidth() - size) / 2, getHeight() - size, size , this, cursors[positionOfMark]);
					add(mrk);
					break;

				case 8:
					mrk = new Mark(getWidth() - size, getHeight() - size, size , this, cursors[positionOfMark]);
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


	private void moveMarks()
	{
		int width = getWidth();
		int height = getHeight();
		int size = 10;
		Mark mrk = null;
		int positionOfMark = 1;
		int index = 0;
		Component[] marks = getComponents();
		while(index < getComponentCount() )
		{
			mrk = (Mark) marks[index];
			switch (positionOfMark)
			{
				case 1:
					mrk.x = 0;
					mrk.y = 0;
					mrk.setBounds(mrk.x, mrk.y, size, size);
					break;
				case 2:					
					mrk.x = (width - size) / 2;
					mrk.y = 0;
					mrk.setBounds(mrk.x, mrk.y, size, size);
					break;

				case 3:
					mrk.x = width - size;
					mrk.y = 0;
					mrk.setBounds(mrk.x, mrk.y, size, size);
					break;

				case 4:
					mrk.x = 0;
					mrk.y = (height - size) / 2;
					mrk.setBounds(mrk.x, mrk.y, size, size);
					break;

				case 5:
					mrk.x = width - size;
					mrk.y = (height - size) / 2;
					mrk.setBounds(mrk.x, mrk.y, size, size);
					break;

				case 6:
					mrk.x = 0;
					mrk.y = height - size;
					mrk.setBounds(mrk.x, mrk.y, size, size);
					break;

				case 7:
					mrk.x = (width - size) / 2;
					mrk.y = height - size;
					mrk.setBounds(mrk.x, mrk.y, size, size);
					break;

				case 8:					
					mrk.x = width - size;
					mrk.y = height - size;
					mrk.setBounds(mrk.x, mrk.y, size, size);
					break;

				default:
					break;
			}
			positionOfMark++;
			index++;
		}
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



		private void Resize(int newx, int newy)
		{
			switch (cursor)
			{
				case Cursor.E_RESIZE_CURSOR: 			wider(newx); 					break;
				case Cursor.S_RESIZE_CURSOR: 			longer(newy);					break;
				case Cursor.N_RESIZE_CURSOR: 			shorter(newy); 					break;
				case Cursor.W_RESIZE_CURSOR: 			narrow(newx); 					break;

				case Cursor.SE_RESIZE_CURSOR: 			wider(newx);  	longer(newy); 	break;
				case Cursor.NE_RESIZE_CURSOR: 			shorter(newy);	wider(newx); 	break;
				case Cursor.SW_RESIZE_CURSOR: 			longer(newy);	narrow(newx); 	break;
				case Cursor.NW_RESIZE_CURSOR: 			shorter(newy);	narrow(newx); 	break;

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
			Resize(newx, newy);	
			moveMarks();
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
		{}
	}




}
