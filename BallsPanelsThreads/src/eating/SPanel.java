package eating;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class SPanel extends JPanel
{
	SharikMouseListener mList = new SharikMouseListener();
	SPanel panel;
	ArrayList<BaloonPan> baloons = new ArrayList<BaloonPan>();
	int width;
	int height;
	
	public SPanel(int width, int height)
	{
		setBounds(0, 0, width, height);
		this.width = width;
		this.height = height;
		addMouseListener(mList);
		panel = this;

	
	}


	class SharikMouseListener implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e)
		{

		}

		@Override
		public void mouseEntered(MouseEvent e)
		{

		}

		@Override
		public void mouseExited(MouseEvent e)
		{

		}

		@Override
		public void mousePressed(MouseEvent e)
		{
			if(e.getButton() == e.BUTTON3)
			{
				return;
			}
			BaloonPan bal = new BaloonPan(e.getX(), e.getY(), 70, panel);
			baloons.add(bal);
			panel.add(bal);
			repaint();
		}

		@Override
		public void mouseReleased(MouseEvent e)
		{

		}

	}

	

}
