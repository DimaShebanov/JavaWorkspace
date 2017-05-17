package frame.controls;
import java.awt.Color;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JButton;
import javax.swing.JPanel;

import frame.Localisation;
import frame.RMPanel;
import logic.RMCommand;

public class RMShortCutMenu extends JPanel
{
	
	
	public RMShortCutMenu(RMCommand rmc, Localisation local)
	{
		setLayout(null);
		setBounds(0, 0, 800, 50);
		
		int btnwidht = getWidth() / 10;
		int btnheight = getHeight();
		
		JButton yellow = new JButton(local.shortcutPanelButtonYellow);
		yellow.setBounds(0, 0, btnwidht, btnheight);
		yellow.setMargin(new Insets(0, 0, 0, 0));

		yellow.setFocusable(false);
		yellow.setBackground(Color.yellow);
		yellow.setActionCommand("yellow");
		yellow.addActionListener(rmc.collst);
		add(yellow);
		
		JButton green = new JButton(local.shortcutPanelButtonGreen);
		green.setMargin(new Insets(0, 0, 0, 0));
		green.setBounds(80, 0, btnwidht, btnheight);
		green.setBackground(Color.green);
		green.setFocusable(false);
		green.setActionCommand("green");
		green.addActionListener(rmc.collst);
		add(green);


		JButton red = new JButton(local.shortcutPanelButtonRed);
		red.setMargin(new Insets(0, 0, 0, 0));
		red.setBounds(160, 0, btnwidht, btnheight);
		red.setBackground(Color.red);

		red.setFocusable(false);
		red.setActionCommand("red");
		red.addActionListener(rmc.collst);
		add(red);


		
		
		
		OwnButton rect = new OwnButton("rect");
		rect.setFocusable(false);
		rect.setBounds(240, 0, btnwidht, btnheight);
		rect.setActionCommand("1");
		rect.addActionListener(rmc.typelst);
		add(rect);
		
		
		OwnButton line = new OwnButton("line");
		line.setBounds(320, 0, btnwidht, btnheight);
		line.setFocusable(false);
		line.setActionCommand("3");
		line.addActionListener(rmc.typelst);
		add(line);
		

		OwnButton oval = new OwnButton("oval");
		oval.setBounds(400, 0, btnwidht, btnheight);
		oval.setFocusable(false);
		oval.setActionCommand("2");
		oval.addActionListener(rmc.typelst);
		add(oval);
		

		OwnButton rrect = new OwnButton("rrect");
		rrect.setBounds(480, 0, btnwidht, btnheight);
		rrect.setFocusable(false);
		rrect.setActionCommand("4");
		rrect.addActionListener(rmc.typelst);
		add(rrect);
		
		
		JButton thin = new JButton(local.shortcutPanelButtonThin);
		thin.setMargin(new Insets(0, 0, 0, 0));
		thin.setBounds(560, 0, btnwidht, btnheight);
		thin.setFocusable(false);
		thin.setActionCommand("2");
		thin.addActionListener(rmc.widthlst);
		add(thin);


		JButton middle = new JButton(local.shortcutPanelButtonMiddle);
		middle.setMargin(new Insets(0, 0, 0, 0));
		middle.setBounds(640, 0, btnwidht, btnheight);
		middle.setFocusable(false);
		middle.setActionCommand("8");
		middle.addActionListener(rmc.widthlst);
		add(middle);


		JButton thick = new JButton(local.shortcutPanelButtonThick);
		thick.setMargin(new Insets(0, 0, 0, 0));
		thick.setBounds(720, 0, btnwidht, btnheight);
		thick.setFocusable(false);
		thick.setActionCommand("13");
		thick.addActionListener(rmc.widthlst);
		add(thick);

		
		
		
	}
}
