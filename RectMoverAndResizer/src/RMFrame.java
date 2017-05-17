import javax.swing.JFrame;

public class RMFrame extends JFrame
{
	public RMFrame()
	{
		setLayout(null);
		setBounds(0, 0, 2000, 900);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		RMPanel rmp = new RMPanel();
		add(rmp);
		
		
		setVisible(true);
	}
}
