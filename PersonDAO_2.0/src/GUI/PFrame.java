package GUI;

import javax.swing.JFrame;

import blogic.PersonDM;
import dal.Person_DAO_JSon_Auto;

public class PFrame extends JFrame
{
	public PFrame()
	{	
//		setBounds(100, 50, 700, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		PersonDM perdm = new PersonDM();
		PPanel ppan = new PPanel(perdm);
		PButtonPanel pbtn = new PButtonPanel(perdm);
		Person_DAO_JSon_Auto pjson = new Person_DAO_JSon_Auto();
		add(ppan);
		add(pbtn);
		perdm.pbtn = pbtn;
		pbtn.pjson = pjson;
		
//		setVisible(true);
	}
}
