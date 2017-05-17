import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class ChooseColor extends JFrame
{
	public ChooseColor(PCommand cmd)
	{
		setLayout(null);
		setBounds(0,0,900,800);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JColorChooser choose = new JColorChooser(Color.BLACK);
		choose.setBounds(0, 0, 800, 500);
		add(choose);
		
//		JButton btnchoose = new JButton("Want this color");
//		btnchoose.setBounds(150, 500, 150, 35);
//		btnchoose.addActionListener(new ActionListener() 
//		{
//			
//			@Override
//			public void actionPerformed(ActionEvent e) 
//			{
//				cmd.data.clr = choose.getColor().getRGB();
//				setVisible(false);
//			}
//		});
//		
//		add(btnchoose);
		
		
		setVisible(true);
	}
}
