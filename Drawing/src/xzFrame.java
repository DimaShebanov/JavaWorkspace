import javax.swing.JFrame;

public class xzFrame extends JFrame
{
	public xzFrame()
	{	
		setTitle("Drawing");
		setBounds(250, 250, 400, 400);
		add(new xzPanel());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
