package frame;
import javax.swing.JFrame;

import frame.controls.RMButtonPanel;
import frame.controls.RMMainMenuPan;
import frame.controls.RMPopUp;
import frame.controls.RMShortCutMenu;
import logic.RMCommand;

public class RMFrame extends JFrame
{
	public RMFrame()
	{
		setLayout(null);
		setTitle("RESIZE");

		setBounds(0, 0, 900, 700);
		RMPanel rmp = new RMPanel();
		add(rmp);
		
		RMCommand rmc = new RMCommand(rmp);

		rmp.setComponentPopupMenu(new RMPopUp(rmc));
		rmp.rmc = rmc;
		
		setJMenuBar(new RMMainMenuPan(rmp, rmc));
		
		RMButtonPanel rmbt = new RMButtonPanel(rmp, rmc);
		add(rmbt);
		
		RMShortCutMenu rmsht = new RMShortCutMenu(rmp, rmc);
		add(rmsht);
		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
