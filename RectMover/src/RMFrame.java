import javax.swing.JFrame;

public class RMFrame extends JFrame
{
	public RMFrame()
	{
		setBounds(100, 100, 600, 600);
		RMPanel rmp = new RMPanel();
		add(rmp);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
