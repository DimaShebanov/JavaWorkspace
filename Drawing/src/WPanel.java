import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class WPanel extends JPanel implements MouseListener, FocusListener
{
	public WPanel()
	{
		setBackground(Color.red);
		addMouseListener(this);
		addFocusListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		requestFocus();
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
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
	}

	@Override
	public void focusGained(FocusEvent e) 
	{
		setBackground(Color.YELLOW);
	}

	@Override
	public void focusLost(FocusEvent e) 
	{
		setBackground(Color.red);
 	}
}
