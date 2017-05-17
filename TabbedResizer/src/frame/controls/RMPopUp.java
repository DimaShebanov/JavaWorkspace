package frame.controls;
import java.awt.event.FocusListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import logic.RMCommand;

public class RMPopUp extends JPopupMenu
{
	RMCommand rmc;
	public RMPopUp(RMCommand rmc)
	{
		this.rmc = rmc;
		setFocusable(false);
		
		
		JMenu type = new JMenu("Change type to..."); 
		type.setFocusable(false);
		add(type);
		
		JMenuItem rect = new JMenuItem("Rectangle");
		rect.setFocusable(false);
		rect.setActionCommand("1");
		type.add(rect);
		rect.addActionListener(rmc.typelst);
		
		JMenuItem line = new JMenuItem("Line");
		line.setFocusable(false);
		line.setActionCommand("2");
		type.add(line);
		line.addActionListener(rmc.typelst);

		JMenuItem oval = new JMenuItem("Oval");
		oval.setFocusable(false);
		oval.setActionCommand("3");
		type.add(oval);
		oval.addActionListener(rmc.typelst);

		JMenuItem rrect = new JMenuItem("Round Rectangle");
		rrect.setFocusable(false);
		rrect.setActionCommand("4");
		type.add(rrect);
		rrect.addActionListener(rmc.typelst);

		
		JMenu color = new JMenu("Change color to..."); 
		color.setFocusable(false);
		add(color);
		
		JMenuItem yellow = new JMenuItem("Yellow");
		yellow.setFocusable(false);
		yellow.setActionCommand("yellow");
		color.add(yellow);
		yellow.addActionListener(rmc.collst);
		
		JMenuItem green = new JMenuItem("Green");
		green.setFocusable(false);
		green.setActionCommand("green");
		color.add(green);
		green.addActionListener(rmc.collst);

		JMenuItem red = new JMenuItem("Red");
		red.setFocusable(false);
		red.setActionCommand("red");
		color.add(red);
		red.addActionListener(rmc.collst);

		JMenuItem blue = new JMenuItem("Blue");
		blue.setFocusable(false);
		blue.setActionCommand("blue");
		color.add(blue);
		blue.addActionListener(rmc.collst);
		
		
		
		
		
		JMenu width = new JMenu("Change width to..."); 
		width.setFocusable(false);
		add(width);
		
		JMenuItem defaultthk = new JMenuItem("Default");
		defaultthk.setFocusable(false);
		defaultthk.setActionCommand("5");
		width.add(defaultthk);
		defaultthk.addActionListener(rmc.widthlst);
		
		JMenuItem thin = new JMenuItem("Thin");
		thin.setFocusable(false);
		thin.setActionCommand("2");
		width.add(thin);
		thin.addActionListener(rmc.widthlst);

		JMenuItem middle = new JMenuItem("Middle");
		middle.setFocusable(false);
		middle.setActionCommand("8");
		width.add(middle);
		middle.addActionListener(rmc.widthlst);

		JMenuItem thick = new JMenuItem("Thick");
		thick.setFocusable(false);
		thick.setActionCommand("13");
		width.add(thick);
		thick.addActionListener(rmc.widthlst); 
	}
	
}
