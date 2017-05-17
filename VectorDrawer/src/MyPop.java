import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class MyPop extends JPopupMenu
{
	public MyPop(PCommand cmd) 
	{
		JMenuItem thin = new JMenuItem("Set thin stroke");
		JMenuItem middle = new JMenuItem("Set middle stroke");
		JMenuItem thick = new JMenuItem("Set thick stroke");
		JMenuItem defaultstrk = new JMenuItem("Set default stroke");
		
		thin.setActionCommand("thin");
		middle.setActionCommand("middle");
		thick.setActionCommand("thick");
		defaultstrk.setActionCommand("default");
		
		thin.addActionListener(cmd.aWdth);
		middle.addActionListener(cmd.aWdth);
		thick.addActionListener(cmd.aWdth);
		defaultstrk.addActionListener(cmd.aWdth);
		
		add(thin);
		add(middle);
		add(thick);
		add(defaultstrk);
		
		
		JMenuItem red = new JMenuItem("Set red color");
		JMenuItem blue = new JMenuItem("Set blue color");
		JMenuItem green = new JMenuItem("Set green color");
		JMenuItem defaultclr = new JMenuItem("Set default color");
		
		blue.setActionCommand("blue");
		red.setActionCommand("red");
		green.setActionCommand("green");
		defaultclr.setActionCommand("default");
		
		blue.addActionListener(cmd.aClr);
		red.addActionListener(cmd.aClr);
		green.addActionListener(cmd.aClr);
		defaultclr.addActionListener(cmd.aClr);
		
		add(blue);
		add(red);
		add(green);
		add(defaultclr);
	}
}
