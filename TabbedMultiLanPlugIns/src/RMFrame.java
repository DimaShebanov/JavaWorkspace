
import java.awt.Color;

import javax.swing.JFrame;

public class RMFrame extends JFrame
{
	public RMFrame()
	{
		setLayout(null);
		setTitle("RESIZE");

		setBounds(0, 0, 850, 730);
		RMPanel rmp = new RMPanel();
		add(rmp);

		RMCommand rmc = new RMCommand(rmp);
		
		
		RMButtonPanel rmbt = new RMButtonPanel(rmc);
		add(rmbt);

		Plugin oval = new PluginOval();
		oval.invoke(rmbt, rmc);
		
		Plugin rect = new PluginRRect();
		rect.invoke(rmbt, rmc);
		
		rmc.rmbt = rmbt;
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
