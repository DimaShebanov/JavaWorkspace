import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.DoublePredicate;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CPanel extends JPanel
{
	static JTextField vvod=null;
	static JButton bt1=null;
	static JButton bt2=null;
	static JButton bt3=null;
	static JButton bt4=null;
	static JButton bt5=null;
	static JButton bt6=null;
	static JButton bt7=null;
	static JButton bt8=null;
	static JButton bt9=null;
	static JButton bt0=null;
	static JButton btpl=null;
	static JButton btmin=null;
	static JButton btdiv=null;
	static JButton btmult=null;
	static JButton bteq=null;
	static JButton btcl=null;	
	static double var1;
	static double var2;
	static String op;
	static double res;


	public CPanel()
	{
		setLayout(null);
		vvod=new JTextField();
		vvod.setSize(300, 30);
		add(vvod);

		bt1=new JButton("1");
		bt1.setBounds(0, 30, 50, 30);
		add(bt1);
		bt1.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				vvod.setText(vvod.getText()+"1");
			}
		});

		bt2=new JButton("2");
		bt2.setBounds(50, 30, 50, 30);
		add(bt2);
		bt2.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				vvod.setText(vvod.getText()+"2");
			}
		});

		bt3=new JButton("3");
		bt3.setBounds(100, 30, 50, 30);
		add(bt3);
		bt3.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				vvod.setText(vvod.getText()+"3");
			}
		});


		btpl=new JButton("+");
		btpl.setBounds(150, 30, 50, 30);
		add(btpl);
		btpl.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				var1=Double.parseDouble(vvod.getText());
				op="+";
				vvod.setText("");
			}
		});


		bt4=new JButton("4");
		bt4.setBounds(0, 60, 50, 30);
		add(bt4);
		bt4.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				vvod.setText(vvod.getText()+"4");
			}
		});


		bt5=new JButton("5");
		bt5.setBounds(50, 60, 50, 30);
		add(bt5);
		bt5.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				vvod.setText(vvod.getText()+"5");
			}
		});


		bt6=new JButton("6");
		bt6.setBounds(100, 60, 50, 30);
		add(bt6);
		bt6.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				vvod.setText(vvod.getText()+"6");
			}
		});


		btmin=new JButton("-");
		btmin.setBounds(150, 60, 50, 30);
		add(btmin);
		btmin.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				var1=Double.parseDouble(vvod.getText());
				op="-";
				vvod.setText("");
			}
		});


		bt7=new JButton("7");
		bt7.setBounds(0, 90, 50, 30);
		add(bt7);
		bt7.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				vvod.setText(vvod.getText()+"7");
			}
		});


		bt8=new JButton("8");
		bt8.setBounds(50, 90, 50, 30);
		add(bt8);
		bt8.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				vvod.setText(vvod.getText()+"8");
			}
		});


		bt9=new JButton("9");
		bt9.setBounds(100, 90, 50, 30);
		add(bt9);
		bt9.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				vvod.setText(vvod.getText()+"9");
			}
		});


		btmult=new JButton("*");
		btmult.setBounds(150, 90, 50, 30);
		add(btmult);
		btmult.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				var1=Double.parseDouble(vvod.getText());
				op="*";
				vvod.setText("");
			}
		});



		
		btcl=new JButton("C");
		btcl.setBounds(0, 120, 50, 30);
		add(btcl);
		btcl.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				vvod.setText("");
			}
		});	


		bt0=new JButton("0");
		bt0.setBounds(50, 120, 50, 30);
		add(bt0);
		bt0.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				vvod.setText(vvod.getText()+"0");
			}
		});


		bteq=new JButton("=");
		bteq.setBounds(100, 120, 50, 30);
		add(bteq);
		bteq.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				var2=Double.parseDouble(vvod.getText());
				vvod.setText(Calculate(var1,op,var2)+"");
			}
		});	
		
		btdiv=new JButton("/");
		btdiv.setBounds(150, 120, 50, 30);
		add(btdiv);
		btdiv.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				var1=Double.parseDouble(vvod.getText());
				op="/";
				vvod.setText("");
			}
		});
	
	
	
	}
	
	


	public static double Calculate(double v1,String opa,double v2)
	{
		double res=0;
		switch(opa)
		{
		case "+": res=v1+v2; break;
		case "-": res=v1-v2; break;
		case "*": res=v1*v2; break;
		case "/": res=v1/v2; break;
		default: break;
		}
		return res;
	}




}