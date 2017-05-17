package frame;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.xml.transform.OutputKeys;

import frame.controls.RMButtonPanel;
import frame.controls.RMMainMenuPan;
import frame.controls.RMPopUp;
import frame.controls.RMShortCutMenu;
import logic.RMCommand;
import logic.io.LocalisationParser;

public class RMFrame extends JFrame
{
	public RMFrame()
	{
		String[] options = {"EN", "RU", "UA"};
		String languageOfUser = (String) JOptionPane.showInputDialog(this, "Choose language", "Language,please", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		
		
		
		Localisation local;
		
		
		
		
		if(languageOfUser != null)
		{
			local = new LocalisationParser().parse(languageOfUser);
		}
		else
		{
			System.out.println("are you ahuel tam???");
			return;
		}
		setLayout(null);
		setTitle("RESIZE");

		setBounds(0, 0, 850, 730);
		RMPanel rmp = new RMPanel();
		
		RMPanel rmpp = new RMPanel();

		JTabbedPane tabs = new JTabbedPane();
		tabs.setBounds(240, 50, 580, 600);
		tabs.addTab("1", rmp);
		tabs.addTab("2", rmpp);
		add(tabs);
				
		RMCommand rmc = new RMCommand(tabs, local);
		

		for(int i = 0; i < tabs.getComponentCount(); i++)
		{
			RMPanel tmprmp = (RMPanel) tabs.getComponentAt(i);
			tmprmp.rmc = rmc;
			tmprmp.setComponentPopupMenu(new RMPopUp(rmc, local));
		}
		
		setJMenuBar(new RMMainMenuPan(rmc, local));
		
		RMButtonPanel rmbt = new RMButtonPanel(rmc, local);
		add(rmbt);
		
		RMShortCutMenu rmsht = new RMShortCutMenu(rmc, local);
		add(rmsht);
		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
