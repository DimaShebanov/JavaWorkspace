import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class PMenuType extends JMenuBar
{

	public PMenuType(PCommand cmd) 
	{
		JMenu type = new JMenu("Choose type");

		JMenuItem line = new JMenuItem("Line");
		JMenuItem rect = new JMenuItem("Rectangle");
		JMenuItem oval = new JMenuItem("Oval");
		JMenuItem roundrect = new JMenuItem("Round rect");
		JMenuItem fillrect = new JMenuItem("Filled rectangle");
		JMenuItem filloval = new JMenuItem("Filled oval");
		JMenuItem fillroundrect = new JMenuItem("Filled round rect");

		line.setActionCommand("line");
		rect.setActionCommand("rect");
		oval.setActionCommand("oval");
		roundrect.setActionCommand("rrect");
		fillrect.setActionCommand("fillrect");
		filloval.setActionCommand("filloval");
		fillroundrect.setActionCommand("fillrrect");

		line.addActionListener(cmd.aType);
		rect.addActionListener(cmd.aType);
		oval.addActionListener(cmd.aType);
		roundrect.addActionListener(cmd.aType);
		fillrect.addActionListener(cmd.aType);
		filloval.addActionListener(cmd.aType);
		fillroundrect.addActionListener(cmd.aType);


		type.add(line);
		type.add(rect);
		type.add(oval);
		type.add(roundrect);
		type.add(fillrect);
		type.add(filloval);
		type.add(fillroundrect);


		setBounds(0, 360, 160, 30);

		add(type);
		
		
		JMenu SaveAsMenu = new JMenu("Save as...");
		
		
		JMenuItem itemXML = new JMenuItem("XML");
		JMenuItem itemJSon = new JMenuItem("JSon");
		JMenuItem itemyml = new JMenuItem("YAML");
		
		itemXML.setActionCommand("xml");
		itemJSon.setActionCommand("json");
		itemyml.setActionCommand("yml");
		
		itemXML.addActionListener(cmd.aSaveAs);
		itemJSon.addActionListener(cmd.aSaveAs);
		itemyml.addActionListener(cmd.aSaveAs);
		
		
		SaveAsMenu.add(itemXML);
		SaveAsMenu.add(itemJSon);
		SaveAsMenu.add(itemyml);
		add(SaveAsMenu);
		
	}

}
