package PersonDrawer;

import javax.swing.JFrame;

public class PFrame extends JFrame
{
	public PFrame()
	{	
		setBounds(100, 50, 700, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		PCommand cmd = new PCommand();
		PPanel ppan = new PPanel(cmd);
		PButtonPanel pbtn = new PButtonPanel(cmd);
		cmd.pbtn = pbtn;
		cmd.ppan = ppan;
		add(ppan);
		add(pbtn);
		setVisible(true);
	}
}
