package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.xml.ws.ServiceMode;

import model.MFigure;
import model.NastedSquare;
import model.RMdata;


public class Figure extends JPanel implements Cloneable, Serializable
{
	final int  sizeClick = 10;
	public	RMdata data = null;
	int  RightTopBottomIntend;
	int  LeftTopBottomIntend;
	public  ArrayList<NastedSquare> nastedSq = null;
	public Figure()
	{
	
	}
	
	public MFigure getMemento()
	{
		MFigure fm = new MFigure();
		fm.color = data.color.getRGB();
		fm.type = data.type;
		fm.stroke = data.stroke;
		fm.rect = getBounds();
		return fm;
	}
	public Figure(MFigure fm)
	{
		setLayout(null);
		nastedSq = new   ArrayList<NastedSquare>();
		setBounds(fm.rect);
		this.setBackground(Color.WHITE);
		data = new RMdata();
		this.CreateNastedSquare(fm.rect.x , fm.rect.y, fm.rect.width, fm.rect.height,this);
		data.color = new Color(fm.color);
		data.type = fm.type;
		data.stroke = fm.stroke;
	}
	
	
	public Figure(Rectangle r )
	{
		nastedSq = new   ArrayList<NastedSquare>();
		setLayout(null);
		setBounds(r);
		this.setBackground(Color.WHITE);
		data = new RMdata();
		this.CreateNastedSquare(r.x , r.y, r.width, r.height,this);
	}
	
	
	public static Figure clone(int x, int y, int height, int weight, int type, Color color, int stroke)  
	{
		Rectangle r        = new Rectangle(x, y, height, weight);
		Figure figure      = new Figure(r);
		figure.data.color  = color;
		figure.data.type   = type;
		figure.data.stroke = stroke;
		
		return figure;
	}
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D gg = (Graphics2D) g;
		gg.setStroke(new BasicStroke(data.stroke));
		gg.setColor( data.color );
		switch (data.type)
		{
		case 1: gg.drawLine(5, 5, getWidth() - 10, getHeight() - 10); 	         break;
		case 2: gg.drawRect(5, 5, getWidth() - 10, getHeight() - 10);			 break;
		case 3: gg.drawRoundRect(5, 5, getWidth() - 5, getHeight() - 5, 30, 30); break;	
		case 4: gg.drawOval(5, 5, getWidth() - 10, getHeight() - 10);    		 break;
		}		
	}
	private void CreateNastedSquare(int x , int y, int width, int  height,Figure sq)
	{
		RightTopBottomIntend = getWidth()/8;
		LeftTopBottomIntend  = getWidth()/25;
		nastedSq.add(new NastedSquare(LeftTopBottomIntend, LeftTopBottomIntend, width/10, width/10,sq));
		nastedSq.add(new NastedSquare(width/2, LeftTopBottomIntend, width/10, width/10,sq));
		nastedSq.add(new NastedSquare(width-RightTopBottomIntend, LeftTopBottomIntend, getWidth()/10, width/10,sq));
		nastedSq.add(new NastedSquare(LeftTopBottomIntend, height/2, width/10, width/10,sq));
		nastedSq.add(new NastedSquare(width-RightTopBottomIntend, height/2, width/10, width/10,sq));
		nastedSq.add(new NastedSquare(LeftTopBottomIntend, height-RightTopBottomIntend, width/10, width/10,sq));
		nastedSq.add(new NastedSquare(width/2, height-RightTopBottomIntend, width/10, width/10,sq));
		nastedSq.add(new NastedSquare(width-RightTopBottomIntend, height-RightTopBottomIntend, width/10, width/10,sq));
	}
	public void ChengesPositionNastedSquare()
	{
		RightTopBottomIntend = getWidth()/8;
		LeftTopBottomIntend  = getWidth()/25;
		nastedSq.get(0).SetParams(LeftTopBottomIntend, LeftTopBottomIntend, 10, 10);
		nastedSq.get(1).SetParams(getWidth()/2, LeftTopBottomIntend, 10, 10);
		nastedSq.get(2).SetParams(getWidth()-RightTopBottomIntend, LeftTopBottomIntend, 10, 10);
		nastedSq.get(3).SetParams(LeftTopBottomIntend, getHeight()/2, 10, 10);
		nastedSq.get(4).SetParams(getWidth()-RightTopBottomIntend, getHeight()/2, 10, 10);
		nastedSq.get(5).SetParams(LeftTopBottomIntend, getHeight()-RightTopBottomIntend, 10, 10);
		nastedSq.get(6).SetParams(getWidth()/2, getHeight()-RightTopBottomIntend, 10, 10);
		nastedSq.get(7).SetParams(getWidth()-RightTopBottomIntend, getHeight()-RightTopBottomIntend, 10, 10);
	}
	public void SetParams(int x,int y,int width,int height)
	{
		this.setBounds(x, y, width, height);
	}

	public Boolean checkFocus(int posX, int posY)
	{
		Boolean result = false;

		if((this.getX()<=posX)&&(posX<=this.getX()+getHeight())&&(this.getY()<=posY)&&(posY<=this.getY()+getHeight()))
		{
			result = true;
		}
		return result;
	}
	public Boolean checkPosition(int posX, int posY)
	{
		Boolean result = false;

		if(((this.getX()+sizeClick<=posX)&&(posX<=this.getX()+getWidth()-sizeClick))&&((this.getY()+sizeClick<=posY)&&(posY<=this.getY()+getHeight()-sizeClick)))
		{
			result= true;
		}
		return result;
	}
	public Boolean checkSizeLeftTopCorner(int posX, int posY)
	{
		Boolean result = false;

		if((this.getX()+sizeClick>=posX)&&(this.getY()+sizeClick>=posY)&&(posY>=this.getY()&&posX>=this.getX()))
		{
			result= true;
		}
		return result;
	}
	public Boolean checkSizeLeftSide(int posX, int posY)
	{
		Boolean result = false;

		if((this.getX()+sizeClick>=posX)&&(this.getY()+getHeight()-sizeClick>=posY)&&(posY>=this.getY()&&posX>=this.getX()))
		{
			result= true;
		}
		return result;
	}
	public Boolean checkSizeLeftBottomCorner(int posX, int posY)
	{
		Boolean result = false;

		if((this.getX()+sizeClick>=posX)&&(this.getY()+getHeight()-sizeClick<=posY)&&(posY>=this.getY()&&posX>=this.getX()))
		{
			result= true;
		}
		return result;
	}
	public Boolean checkSizeBottomSide(int posX, int posY)
	{
		Boolean result = false;

		if((this.getX()+sizeClick<=posX)&&(this.getX()+getWidth()-sizeClick>=posX)&&(this.getY()+getHeight()-sizeClick<=posY)&&(posY <=this.getY()+getHeight()))
		{
			result= true;
		}
		return result;
	}
	public Boolean checkSizeRightBottomCorner(int posX, int posY)
	{
		Boolean result = false;

		if((this.getX()+getWidth()-sizeClick<=posX)&&(this.getY()+getHeight()-sizeClick<=posY)&&(posY <=this.getY()+getHeight()&&posX<=this.getX()+getWidth()))
		{
			result= true;
		}
		return result;
	}
	public Boolean checkSizeRightSide(int posX, int posY)
	{
		Boolean result = false;

		if((this.getX()+getWidth()-sizeClick<=posX)&&(this.getY()+getHeight()-sizeClick>=posY)&&(this.getY()+sizeClick<=posY)&&(posX<=this.getX()+getWidth()))
		{
			result= true;
		}
		return result;
	}
	public Boolean checkSizeRightTopCorner(int posX, int posY)
	{
		Boolean result = false;

		if((this.getX()+getWidth()-sizeClick<=posX)&&(this.getY()+sizeClick>=posY)&&(posY>=this.getY()&&posX<=this.getX()+getWidth()))
		{
			result= true;
		}
		return result;
	}
	public Boolean checkSizeTopSide(int posX, int posY)
	{
		Boolean result = false;

		if((this.getX()+getWidth()-sizeClick>=posX)&&(this.getX()+sizeClick<=posX)&&(this.getY()+sizeClick>=posY)&&(posY>=this.getY()&&posX>=this.getX()))
		{
			result= true;
		}
		return result;
	}
	public void movePosition(int posX, int posY)
	{
		this.setBounds(getX() + posX, getY() + posY, getWidth(), getHeight());
	}
	////////////////////////////////////////////////////////////////////////////////////////////
	public void moveSizeLeftTopCorner(int posX, int posY)
	{
		this.setBounds(getX() - posX,getY() - posY, getWidth() + posX, getHeight() + posY);
	}
	public void moveSizeLeftSide(int posX, int posY)
	{
		this.setBounds(getX() - posX, getY(), getWidth() + posX, getHeight());
	}
	public void moveSizeLeftBottomCorner(int posX, int posY)
	{
		this.setBounds(getX() - posX, getY(), getWidth() + posX, getHeight() + posY);
	}
	public void moveSizeBottomSide(int posX, int posY)
	{
		this.setBounds(getX(), getY(), getWidth() + posX, getHeight() + posY);
	}
	public void moveSizeRightBottomCorner(int posX, int posY)
	{
		this.setBounds(getX(), getY(), getWidth() + posX, getHeight() + posY);
	}
	public void moveSizeRightSide(int posX, int posY)
	{
		this.setBounds(getX(), getY(), getWidth() + posX, getHeight());
	}
	public void moveSizeRightTopCorner(int posX, int posY)
	{
		this.setBounds(getX(),getY()-posY, getWidth() + posX, getHeight() + posY);
	}
	public void moveSizeTopSide(int posX, int posY)
	{
		this.setBounds(getX(), getY() - posY, getWidth(), getHeight()+posY);
	}
}
