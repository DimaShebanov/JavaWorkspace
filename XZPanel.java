import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class XZPanel extends JPanel 
{
	public XZPanel()
	{
		setLayout(null);
		
		JTextField txt1 = new JTextField();
		txt1.setBounds(10, 10, 200, 40);
		add(txt1);
		
		JButton btn = new JButton("Click");
		btn.setBounds(10, 70, 200, 40);
		add(btn);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null, txt1.getText());
				
			}
		});
	}
}
