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
		
		RMPanel rmpp = new RMPanel();

		JTabbedPane tabs = new JTabbedPane();
		tabs.setBounds(200, 50, 600, 600);
		tabs.addTab("1", rmp);
		tabs.addTab("2", rmpp);
		add(tabs);
				
		RMCommand rmc = new RMCommand(tabs);
		

		for(int i = 0; i < tabs.getComponentCount(); i++)
		{
			RMPanel tmprmp = (RMPanel) tabs.getComponentAt(i);
			tmprmp.rmc = rmc;
			tmprmp.setComponentPopupMenu(new RMPopUp(rmc));
		}
		
		setJMenuBar(new RMMainMenuPan(rmc));
		
		RMButtonPanel rmbt = new RMButtonPanel(rmc);
		add(rmbt);
		
		RMShortCutMenu rmsht = new RMShortCutMenu(rmc);
		add(rmsht);
		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
