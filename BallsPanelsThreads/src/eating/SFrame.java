package eating;
import javax.swing.JFrame;

public class SFrame extends JFrame
{
	SPanel SharPan;
	public SFrame()
	{
		int width = 900;
		int height = 600;
		setBounds(100, 100, width, height);
		setLayout(null);
		SharPan = new SPanel(width - 15, height - 35);
		add(SharPan);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
			
	
		
		setVisible(true);
	}
		
}
