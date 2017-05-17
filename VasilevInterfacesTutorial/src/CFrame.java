import javax.swing.JFrame;

public class CFrame extends JFrame
{
	private static final long serialVersionUID = 1L;

	public CFrame()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200,200,400,400);
		add(new CPanel());
		setVisible(true);
	}
}
