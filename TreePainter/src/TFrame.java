import javax.swing.JFrame;

public class TFrame extends JFrame
{
	
	
	public TFrame()
	{
		setBounds(100, 100, 700, 600);
		
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		TPanel TPnl = new TPanel();
		add(TPnl);


		TCommand tc = new TCommand(TPnl);
		TButtonPanel TButtonPanel = new TButtonPanel(tc);
		add(TButtonPanel);
		
		tc.TButtonPanel = TButtonPanel;
		
		setVisible(true);
	}
	
	
	
	
}
