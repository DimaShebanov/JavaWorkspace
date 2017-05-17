package PersonDrawer;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.JTable;

public class PPanel extends JPanel
{

	PCommand cmd;
	public PPanel(PCommand cmd) 
	{
		this.cmd = cmd;
		setBounds(5, 60, 700, 660);
		setLayout(null);
		JTable 
		
	}
	
	
	@Override
	public void paint(Graphics g) 
	{
		super.paint(g);
		Graphics2D gg = (Graphics2D) g;
	}
	
	

}
