package view.control;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import command.PCommand;

public class PMainMenu extends JMenuBar
{
	PCommand pCommand = null;
	public PMainMenu(PCommand pCommand) 
	{
		this.pCommand = pCommand;
		AddFileMenu(this);
		AddTypeMenu(this);
		AddColorMenu(this);
	
		AddWidthMenu(this);
		
		this.setVisible(true);
	}
	public void AddFileMenu(PMainMenu pMenu)
	{
		JMenu file = new JMenu("File");
		
		JMenuItem loadMenu = new JMenuItem("Load");
		loadMenu.addActionListener(pCommand.actionLoadListener);
		file.add(loadMenu);
		
		file.addSeparator();

		JMenuItem saveMenu = new JMenuItem("Save");
		saveMenu.addActionListener(pCommand.actionSaveListener);
		file.add(saveMenu);

		
		file.addSeparator();
		
		JMenuItem exitMenu = new JMenuItem("Exit");
		exitMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});

		file.add(exitMenu);

		pMenu.add(file);
	}
	
	public void AddTypeMenu(PMainMenu pMenu)
	{
		JMenu type = new JMenu("Type");

		JMenuItem line = new JMenuItem("Line");
		line.addActionListener(pCommand.typeListener);

		type.add(line);

		type.addSeparator();
		JMenuItem rect = new JMenuItem("Rect");
		rect.addActionListener(pCommand.typeListener);
		type.add(rect);

		type.addSeparator();
		JMenuItem roundRect = new JMenuItem("RoundRect");
		roundRect.addActionListener(pCommand.typeListener);
		type.add(roundRect);
		
		
		type.addSeparator();
		JMenuItem oval = new JMenuItem("Oval");
		oval.addActionListener(pCommand.typeListener);
		type.add(oval);
		
		pMenu.add(type);
	}
	public void AddColorMenu(PMainMenu pMenu)
	{
		JMenu color = new JMenu("Color");
		JMenuItem clorChouser = new JMenuItem("ColorChouser");
		clorChouser.addActionListener(pCommand.colorListener);
		color.add(clorChouser);
		
		pMenu.add(color);
	}
	public void AddWidthMenu(PMainMenu pMenu)
	{
		JMenu width = new JMenu("Width");
		
		JMenuItem slaider = new JMenuItem("Slaider");
		slaider.addActionListener(pCommand.widthListener);
		width.add(slaider);
		
		pMenu.add(width);
	}
}
