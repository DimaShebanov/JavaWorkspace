package frame.controls;
import java.awt.Color;
import java.awt.Component;
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

import frame.RMPanel;
import logic.RMCommand;

public class RMButtonPanel extends JPanel
{
	public RMButtonPanel(RMCommand rmc)
	{


		setLayout(null);
		setBounds(0, 50, 200, 600);

		JButton addTab = new JButton("Add Tab");
		addTab.setBounds(0, 0, getWidth() / 2, 50);
		addTab.setBackground(Color.green);
		addTab.setFocusable(false);
		addTab.addActionListener(rmc.addTabLst);
		add(addTab);
		
		JButton removeTab = new JButton("Delete Tab");
		removeTab.setBounds(getWidth() / 2, 0, getWidth() / 2, 50);
		removeTab.setBackground(Color.red);
		removeTab.setFocusable(false);
		removeTab.addActionListener(rmc.removeTabLst);
		add(removeTab);
		
		
		
		
		JButton color = new JButton("Choose Color");
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
				
		
		JButton rect = new JButton("Rect");
		rect.setActionCommand("1");
		rect.addActionListener(rmc.typelst);
		rect.setBounds(0, 450, 60, 40);
		rect.setFocusable(false);
		add(rect);

		
		JButton oval = new JButton("Oval");
		oval.setActionCommand("3");
		oval.addActionListener(rmc.typelst);
		oval.setFocusable(false);
		oval.setBounds(70, 450, 80, 40);
		add(oval);
		
		
		JButton line = new JButton("Line");
		line.setActionCommand("2");
		line.addActionListener(rmc.typelst);
		line.setFocusable(false);
		line.setBounds(0, 500, 60, 40);
		add(line);
		
		
		
		JButton rrect = new JButton("RRect");
		rrect.setActionCommand("4");
		rrect.addActionListener(rmc.typelst);
		rrect.setFocusable(false);
		rrect.setBounds(70, 500, 80, 40);
		add(rrect);
		
	}
}
