import javax.swing.JFrame;

public class XZFrame extends JFrame 
{
	public XZFrame() 
	{
		setTitle("My XZ Calc");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200, 200, 1200, 1000);
		add( new XZPanel() );
		setVisible(true);
	}
}
