import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JButton;

public class PluginOval implements Plugin
{
	String buttonText = "oval";

	@Override
	public void draw(Graphics2D gg, Figure fig)
	{
		gg.drawOval(10, 10, fig.getWidth() - 15, fig.getHeight() - 15);
	}

	@Override
	public void invoke(RMButtonPanel rmbp, RMCommand rmc)
	{
		JButton oval = new JButton(buttonText);
		
		oval.setMargin(new Insets(0, 0, 0, 0));
		oval.setActionCommand(getClass().getName());
		oval.addActionListener(rmc.typelst);
		rmbp.add(oval);
	} 

}
