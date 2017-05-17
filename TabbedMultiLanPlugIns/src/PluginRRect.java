import java.awt.Graphics2D;

import javax.swing.JButton;

public class PluginRRect implements Plugin
{
	String buttonText = "rrect";
	@Override
	public void draw(Graphics2D gg, Figure fig)
	{
		gg.drawRoundRect(10, 10, fig.getWidth() - 20, fig.getHeight() - 20, 30, 30);
	}

	@Override
	public void invoke(RMButtonPanel rmbp, RMCommand rmc)
	{
		JButton rrect = new JButton(buttonText);
		rrect.setActionCommand(getClass().getName());
		rrect.addActionListener(rmc.typelst);
		rmbp.add(rrect);
	}
	
}
