import javax.swing.JFrame;

public class PFrame extends JFrame
{
	public PFrame()
	{
		PCommand cmd = new PCommand();
		
		setLayout(null);
		setBounds(200,200,800,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		PPanel ppan = new PPanel(cmd);
		PButtonPanel pbpn = new PButtonPanel(cmd);
		add(ppan);
		add(pbpn);
	}
}
