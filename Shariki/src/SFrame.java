import javax.swing.JFrame;

public class SFrame extends JFrame
{
	SPanel SharPan;
	public SFrame()
	{
		setBounds(100, 100, 600, 600);
		SharPan = new SPanel();
		add(SharPan);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
			
	
		
		setVisible(true);
	}
		
}
