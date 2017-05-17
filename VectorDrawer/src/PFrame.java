import javax.swing.JFrame;

public class PFrame extends JFrame
{
	public PFrame()
	{
		PCommand cmd = new PCommand();
		
		setLayout(null);
		setBounds(200,100,800,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		PPanel ppan = new PPanel(cmd);
		PButtonPanel pbpn = new PButtonPanel(cmd);
		PMenuPanel pmenu = new PMenuPanel(cmd);
		
		add(ppan);
		add(pbpn);
		add(pmenu);
		
		setVisible(true);
	}
}
