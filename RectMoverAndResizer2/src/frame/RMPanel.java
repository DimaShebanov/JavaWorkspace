package frame;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.peer.ComponentPeer;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import logic.RMCommand;
import model.MFigure;
import model.RMData;

public class RMPanel extends JPanel implements MouseListener
{
	Point p = null;
	public RMData data = new RMData();
	RMCommand rmc;
	public Figure curfig = null;

	public RMPanel()
	{
		setLayout(null);
		setBounds(200, 50, 600, 500);
		addMouseListener(this);
	}
	
	
	public ArrayList<MFigure> getMemento()
	{
		ArrayList<MFigure> mfigs = new ArrayList<>();
		Component[] comps = getComponents();
		for (Component comp : comps)
		{
			Figure fig = (Figure) comp;
			mfigs.add(fig.getMemento());
		}
		return mfigs;
	}
	
	
	
	public void setMemento(ArrayList<MFigure> figs)
	{
		for (MFigure mfig : figs)
		{
			Rectangle r = new Rectangle(mfig.x, mfig.y, mfig.width, mfig.height);
			RMData data = new RMData(mfig.stroke, mfig.type, new Color(mfig.color));
			add(new Figure(r, data));
		}
		repaint();
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.black);
		g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		if(e.getButton() == e.BUTTON3)
		{
			getComponentPopupMenu().show();
		}
		curfig = null;
		p = e.getPoint();
		requestFocus();
	}
	@Override
	public void mouseReleased(MouseEvent e)
	{
		Rectangle r = new Rectangle(p, new Dimension(e.getX()-(int)p.getX(), e.getY()-(int)p.getY()));
		add( new Figure( r, data ) );
		repaint();
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0){}
	@Override
	public void mouseEntered(MouseEvent arg0){}
	@Override
	public void mouseExited(MouseEvent arg0){}
}
