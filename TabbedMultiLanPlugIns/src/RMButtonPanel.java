
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

public class RMButtonPanel extends JPanel
{
	public RMButtonPanel(RMCommand rmc)
	{

		FlowLayout fwlt = new FlowLayout();
		setLayout(fwlt);
		setBounds(0, 50, 200, 600);

		
		
		
		
		JButton line = new JButton("line");
		line.setMargin(new Insets(0, 0, 0, 0));
		line.setActionCommand("line");
		line.addActionListener(rmc.typelst);
		line.setFocusable(false);
		add(line);
		
		JButton delcurplug = new JButton("Delete current plugin");
		delcurplug.setMargin(new Insets(0, 0, 0, 0));
		delcurplug.addActionListener(rmc.typelst);
		add(delcurplug);



		
//		JButton oval = new JButton(local.toolBarButtonOval);
//		oval.setMargin(new Insets(0, 0, 0, 0));
//		oval.setActionCommand("3");
//		oval.addActionListener(rmc.typelst);
//		oval.setFocusable(false);
//		oval.setBounds(100, 0, 100, 40);
//		add(oval);
//		
//		
//		JButton line = new JButton(local.toolBarButtonLine);
//		line.setMargin(new Insets(0, 0, 0, 0));
//		line.setActionCommand("2");
//		line.addActionListener(rmc.typelst);
//		line.setFocusable(false);
//		line.setBounds(0, 50, 100, 40);
//		add(line);
//		
//		
//		
//		JButton rrect = new JButton(local.toolBarButtonRRect);
//		rrect.setMargin(new Insets(0, 0, 0, 0));
//		rrect.setActionCommand("4");
//		rrect.addActionListener(rmc.typelst);
//		rrect.setFocusable(false);
//		rrect.setBounds(100, 50, 100, 40);
//		add(rrect);
		
	}
}
