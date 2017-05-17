import javax.swing.*;
public class Third_test {

	public static void main(String[] args) {
		int a,b,c,s=0;
		a=Integer.parseInt(JOptionPane.showInputDialog("Please input an A:"));
		b=Integer.parseInt(JOptionPane.showInputDialog("Please input a B:"));
		c=Integer.parseInt(JOptionPane.showInputDialog("Please input a C:"));
		if(a>0)
			s+=a;
		if(b>0)
			s+=b;
		if(c>0)
			s+=c;
		JOptionPane.showMessageDialog(null, "Сумма положительных чисел из трех введенных равна: "+s);
	}

}
