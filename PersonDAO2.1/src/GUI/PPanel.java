package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import blogic.PersonDM;

public class PPanel extends JPanel
{
	PersonDM perdm;
	
	public PPanel(PersonDM perdm) 
	{
		setBounds(5, 60, 600, 600);
		setLayout(null);
		this.perdm = perdm;
		JTable tbl = new JTable(perdm);
		
		
		JScrollPane scroll = new JScrollPane(tbl);
		scroll.setBounds(0, 0, 600, 600);
		add(scroll);
		
	}
}
