package frame;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

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

		setBounds(0, 0, 850, 730);
		RMPanel rmp = new RMPanel();
						
		RMCommand rmc = new RMCommand(rmp);
		rmp.rmc = rmc;

		rmp.setComponentPopupMenu(new RMPopUp(rmc));
		
		setJMenuBar(new RMMainMenuPan(rmp, rmc));
		
		RMButtonPanel rmbt = new RMButtonPanel(rmp, rmc);
		add(rmbt);
		
		RMShortCutMenu rmsht = new RMShortCutMenu(rmp, rmc);
		add(rmsht);
		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
