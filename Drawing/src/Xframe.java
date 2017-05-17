import javax.swing.JFrame;

public class Xframe extends JFrame
{
	public Xframe()
	{
		setVisible(true);	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200,200,500,500);
		setLayout(null);
		setTitle("Focuses");
		
		
		WPanel p1 = new WPanel();
		p1.setBounds(20, 20, 70, 70);
		add(p1);
		
		WPanel p2 = new WPanel();
		p2.setBounds(20, 120, 70, 70);
		add(p2);
	
		WPanel p3 = new WPanel();
		p3.setBounds(120, 20, 70, 70);
		add(p3);
	}
}
