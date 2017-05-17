import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class PMenuPanel extends JPanel
{
	public PMenuPanel(PCommand cmd) 
	{
		setBounds(0, 0, 600, 30);
		setLayout(null);
		JMenuBar menubar = new JMenuBar();
		JMenu strokemenu = new JMenu("Stroke");
		
		
		
		
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
		
		strokemenu.add(thin);
		strokemenu.add(middle);
		strokemenu.add(thick);
		strokemenu.add(defaultstrk);
		
		
		
		
		
		
		JMenu colormenu = new JMenu("Color");
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
		
		colormenu.add(blue);
		colormenu.add(red);
		colormenu.add(green);
		colormenu.add(defaultclr);
		
		
		
		menubar.add(strokemenu);
		menubar.add(colormenu);
		menubar.setBounds(0, 0, 100, 30);
		add(menubar);
		
		
		
		
	}
}
