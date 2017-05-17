import javax.swing.JFrame;

public class ButFrame extends JFrame
{
	public ButFrame()
	{
		setBounds(300,300,400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new ButPanel());
		setVisible(true);
	}
}
