package frame.controls;
import java.awt.Color;
import java.awt.Component;import java.awt.Font;
import java.awt.Insets;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import frame.Localisation;
import frame.RMPanel;
import logic.RMCommand;

public class RMButtonPanel extends JPanel
{
	public RMButtonPanel(RMCommand rmc, Localisation local)
	{


		setLayout(null);
		setBounds(0, 50, 240, 600);

		JButton addTab = new JButton(local.toolBarButtonAddTab);
		addTab.setMargin(new Insets(0, 0, 0, 0));
		addTab.setBounds(0, 0, getWidth() / 2, 50);
		addTab.setBackground(Color.green);
		addTab.setFocusable(false);
		addTab.addActionListener(rmc.addTabLst);
		add(addTab);
		
		JButton removeTab = new JButton(local.toolBarButtonDeleteTab);
		removeTab.setMargin(new Insets(0, 0, 0, 0));
		removeTab.setBounds(getWidth() / 2, 0, getWidth() / 2, 50);
		removeTab.setBackground(Color.red);
		removeTab.setFocusable(false);
		removeTab.addActionListener(rmc.removeTabLst);
		add(removeTab);
		
		
		
		
		JButton color = new JButton(local.toolBarButtonChooseColor);
		color.setBounds(0, 50, getWidth(), 50);
		color.setFocusable(false);
		color.addActionListener(rmc.aclrChooser);
		add(color);	


		JSlider strkslide = new JSlider(SwingConstants.VERTICAL, 1, 15, 5);

		strkslide.setBounds(0, 100, 50, 350);
		strkslide.setPaintLabels(true);
		strkslide.setPaintTicks(true);
		strkslide.setLabelTable(strkslide.createStandardLabels(1));
		strkslide.setFocusable(false);
		add(strkslide);
		strkslide.addChangeListener(rmc.sldchangelst);
				
		
		JButton rect = new JButton(local.toolBarButtonRect);
		rect.setMargin(new Insets(0, 0, 0, 0));
		rect.setActionCommand("1");
		rect.addActionListener(rmc.typelst);
		rect.setBounds(0, 450, 100, 40);
		rect.setFocusable(false);
		add(rect);

		
		JButton oval = new JButton(local.toolBarButtonOval);
		oval.setMargin(new Insets(0, 0, 0, 0));
		oval.setActionCommand("3");
		oval.addActionListener(rmc.typelst);
		oval.setFocusable(false);
		oval.setBounds(100, 450, 100, 40);
		add(oval);
		
		
		JButton line = new JButton(local.toolBarButtonLine);
		line.setMargin(new Insets(0, 0, 0, 0));
		line.setActionCommand("2");
		line.addActionListener(rmc.typelst);
		line.setFocusable(false);
		line.setBounds(0, 500, 100, 40);
		add(line);
		
		
		
		JButton rrect = new JButton(local.toolBarButtonRRect);
		rrect.setMargin(new Insets(0, 0, 0, 0));
		rrect.setActionCommand("4");
		rrect.addActionListener(rmc.typelst);
		rrect.setFocusable(false);
		rrect.setBounds(100, 500, 100, 40);
		add(rrect);
		
	}
}
