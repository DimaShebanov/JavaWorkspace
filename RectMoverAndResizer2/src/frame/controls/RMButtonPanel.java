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
	RMPanel rmp = null;
	public RMButtonPanel(RMPanel rmp, RMCommand rmc)
	{

		this.rmp = rmp;

		setLayout(null);
		setBounds(0, 50, 200, 600);

		JButton color = new JButton("Choose Color");
		color.setBounds(0, 0, getWidth(), 50);
		color.setFocusable(false);
		color.addActionListener(rmc.aclrChooser);
		add(color);	


//		JTextArea curCol = new JTextArea();
//		curCol.setBounds(0, 50, getWidth(), 50);
//		curCol.setBackground (rmp.data.col);
//		curCol.setFocusable(false);
//		setEnabled(false);
//		curCol.addMouseListener(new MouseListener()
//		{
//			
//			@Override
//			public void mouseReleased(MouseEvent e)
//			{}			
//			@Override
//			public void mousePressed(MouseEvent e)
//			{
//				Figure fig = null;
//
//				Component comp = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
//
//				if(comp.getClass() == Figure.class)
//				{
//					fig = (Figure) comp;
//				}
//				
//				if(fig == null)
//				{
//					rmp.data.col = curCol.getBackground();
//				}
//				if(fig != null)
//				{
//					fig.data.col = curCol.getBackground();
//					fig.repaint();
//				}
//			}			
//			@Override
//			public void mouseExited(MouseEvent e)
//			{}			
//			@Override
//			public void mouseEntered(MouseEvent e)
//			{}
//			@Override
//			public void mouseClicked(MouseEvent e)
//			{}
//		});
//		add(curCol);
//

//		color.addActionListener(new ActionListener()
//		{
//
//			@Override
//			public void actionPerformed(ActionEvent e)
//			{
//				Figure fig = null;
//
//				if(KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner().getClass() == Figure.class)
//				{
//					fig = (Figure) KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
//				}
//
//				Color clr = JColorChooser.showDialog(rmp, "Choose your color", Color.BLACK);
//				if(clr != null)
//				{
//					if(fig == null)
//					{
//						curCol.setBackground(clr);
//						rmp.data.col = clr;
//					}
//					if(fig != null)
//					{
//						fig.data.col = clr;
//					}
//				}
//
//				repaint();
//			}
//		});


		JSlider strkslide = new JSlider(SwingConstants.VERTICAL, 1, 15, rmp.data.stroke);
		strkslide.setBounds(0, 100, 50, 350);
		strkslide.setPaintLabels(true);
		strkslide.setPaintTicks(true);
		strkslide.setLabelTable(strkslide.createStandardLabels(1));
		strkslide.setFocusable(false);
		add(strkslide);

		strkslide.addChangeListener(rmc.sldchangelst);
				
				
				
				
				
//				new ChangeListener()
//		{
//
//			@Override
//			public void stateChanged(ChangeEvent e)
//			{
//				Figure fig = null;
//
//				if(KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner().getClass() == Figure.class)
//				{
//					fig = (Figure) KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
//				}
//
//
//				if(fig == null)
//				{
//					rmp.data.stroke = strkslide.getValue();
//				}
//				if(fig != null)
//				{
//					fig.data.stroke = strkslide.getValue();
//					fig.repaint();
//				}
//			}
//		});
		
		
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
