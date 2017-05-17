import javax.swing.JFrame;

public class RRFrame extends JFrame
{
	public RRFrame()
	{
		setBounds(100, 100, 600, 600);
		RRPanel rmp = new RRPanel();
		add(rmp);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
