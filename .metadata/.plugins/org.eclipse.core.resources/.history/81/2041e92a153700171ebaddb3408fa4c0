package frame.controls;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import frame.Localisation;
import frame.RMPanel;
import logic.RMCommand;

public class RMMainMenuPan extends JMenuBar
{
	public RMMainMenuPan(RMCommand rmc, Localisation local)
	{		
		setFocusable(false);

		JMenu file = new JMenu(local.mainMenuFile);
		add(file);
		
		JMenuItem save = new JMenuItem(local.mainMenuFileSave);
		save.addActionListener(rmc.saverlst);
		file.add(save);
		
		JMenuItem load = new JMenuItem(local.mainMenuFileLoad);
		load.addActionListener(rmc.loaderlst);
		file.add(load);
		
		
		
		
		JMenu type = new JMenu(local.mainMenuType); 
		type.setFocusable(false);
		add(type);
		
		JMenuItem rect = new JMenuItem(local.mainMenuTypeRect);
		rect.setFocusable(false);
		rect.setActionCommand("1");
		type.add(rect);
		rect.addActionListener(rmc.typelst);
		
		JMenuItem line = new JMenuItem(local.mainMenuTypeLine);
		line.setFocusable(false);
		line.setActionCommand("2");
		type.add(line);
		line.addActionListener(rmc.typelst);

		JMenuItem oval = new JMenuItem(local.mainMenuTypeOval);
		oval.setFocusable(false);
		oval.setActionCommand("3");
		type.add(oval);
		oval.addActionListener(rmc.typelst);

		JMenuItem rrect = new JMenuItem(local.mainMenuTypeRoundRect);
		rrect.setFocusable(false);
		rrect.setActionCommand("4");
		type.add(rrect);
		rrect.addActionListener(rmc.typelst);

		
		JMenu color = new JMenu(local.mainMenuColor); 
		color.setFocusable(false);
		add(color);
		
		JMenuItem yellow = new JMenuItem(local.mainMenuColorYellow);
		yellow.setFocusable(false);
		yellow.setActionCommand("yellow");
		color.add(yellow);
		yellow.addActionListener(rmc.collst);
		
		JMenuItem green = new JMenuItem(local.mainMenuColorGreen);
		green.setFocusable(false);
		green.setActionCommand("green");
		color.add(green);
		green.addActionListener(rmc.collst);

		JMenuItem red = new JMenuItem(local.mainMenuColorRed);
		red.setFocusable(false);
		red.setActionCommand("red");
		color.add(red);
		red.addActionListener(rmc.collst);

		JMenuItem blue = new JMenuItem(local.mainMenuColorBlue);
		blue.setFocusable(false);
		blue.setActionCommand("blue");
		color.add(blue);
		blue.addActionListener(rmc.collst);
		
		
		
		
		
		JMenu width = new JMenu(local.mainMenuWidth); 
		width.setFocusable(false);
		add(width);
		
		JMenuItem defaultthk = new JMenuItem(local.mainMenuWidthDefault);
		defaultthk.setFocusable(false);
		defaultthk.setActionCommand("5");
		width.add(defaultthk);
		defaultthk.addActionListener(rmc.widthlst);
		
		JMenuItem thin = new JMenuItem(local.mainMenuWidthThin);
		thin.setFocusable(false);
		thin.setActionCommand("2");
		width.add(thin);
		thin.addActionListener(rmc.widthlst);

		JMenuItem middle = new JMenuItem(local.mainMenuWidthMiddle);
		middle.setFocusable(false);
		middle.setActionCommand("8");
		width.add(middle);
		middle.addActionListener(rmc.widthlst);

		JMenuItem thick = new JMenuItem(local.mainMenuWidthThick);
		thick.setFocusable(false);
		thick.setActionCommand("13");
		width.add(thick);
		thick.addActionListener(rmc.widthlst);
		
		
		
	}
}
