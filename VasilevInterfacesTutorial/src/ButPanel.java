import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ButPanel extends JPanel
{
	public ButPanel()
	{
		
		setLayout(null);
		JLabel lbl=new JLabel("op");
		
		add(lbl);
		
		
		JTextField txt = new JTextField();
		txt.setBounds(1, 1, 80, 20);
		add(txt);
		
		JButton btn1=new JButton("1");
		
		setVisible(true);
	}
}
