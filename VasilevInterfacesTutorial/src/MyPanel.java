import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyPanel extends JPanel 
{
	JLabel lbl1=null;
	JLabel lblop=null;
	JLabel lbl2=null;
	JLabel lblres=null;
	JTextField var1=null;
	JTextField op=null;
	JTextField var2=null;
	static JTextField res=null;
	JButton btn=null;
	
	
	public MyPanel()
	{
		setLayout(null);
		lbl1=new JLabel("Variable 1");
		lbl1.setBounds(1, 1, 60, 20);
		add(lbl1);
		var1=new JTextField();
		var1.setBounds(1,20,150,20);
		add(var1);

		lblop=new JLabel("Operand");
		lblop.setBounds(1, 40, 60, 20);
		add(lblop);

		op=new JTextField();
		op.setBounds(1,60,150,20);
		add(op);


		lbl2=new JLabel("Variable 2");
		lbl2.setBounds(1,80,150,20);
		add(lbl2);

		var2=new JTextField();
		var2.setBounds(1,100,150,20);
		add(var2);

		lblres=new JLabel("Result");
		lblres.setBounds(1,120,150,20);
		add(lblres);

		res=new JTextField();
		res.setBounds(1,140,150,20);
		add(res);

		btn=new JButton("Calculate");
		btn.setBounds(1,165,100,20);
		add(btn);
		btn.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Calculate(var1,op,var2);
			}
		});	

	}
	public static void Calculate(JTextField var1,JTextField op,JTextField var2) 
	{
		double v1=Double.parseDouble(var1.getText());
		String opa=op.getText();
		double v2=Double.parseDouble(var2.getText());
		double res1=0;
		switch(opa)
		{
			case "+": res1=v1+v2; break;
			case "-": res1=v1-v2; break;
			case "/": res1=v1/v2; break;
			case "*": res1=v1*v2; break;
			default: break;
		}
	res.setText(res1+"");
	}
}
