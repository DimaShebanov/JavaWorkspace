package frame;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.xml.transform.OutputKeys;

import clientserver.CCon;
import frame.controls.RMButtonPanel;
import frame.controls.RMMainMenuPan;
import frame.controls.RMPopUp;
import frame.controls.RMShortCutMenu;
import logic.RMCommand;
import logic.io.LocalisationParser;

public class RMFrame extends JFrame
{
	public RMPanel rmp;
	public RMCommand rmc;
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
		rmp = new RMPanel();

		RMPanel rmpp = new RMPanel();

		JTabbedPane tabs = new JTabbedPane();
		tabs.setBounds(240, 50, 580, 600);
		tabs.addTab("1", rmp);
		tabs.addTab("2", rmpp);
		add(tabs);

		
		CCon con = new CCon(this);

		rmp.con = con;

		
		rmc = new RMCommand(tabs, local, con);
		rmp.rmc = rmc;


		setJMenuBar(new RMMainMenuPan(rmc, local));
		
		RMButtonPanel rmbt = new RMButtonPanel(rmc, local);
		add(rmbt);
		
		RMShortCutMenu rmsht = new RMShortCutMenu(rmc, local);
		add(rmsht);
		

		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
