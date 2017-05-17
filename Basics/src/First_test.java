import javax.swing.*;
public class First_test {

	public static void main(String[] args) {
	int a,b,s;
	a=Integer.parseInt(JOptionPane.showInputDialog("Please input A:"));
	b=Integer.parseInt(JOptionPane.showInputDialog("Please input B:"));
	if(a%2==0)
		s=a*b;
	else
		s=a+b;
	JOptionPane.showMessageDialog(null, "The result is "+s);
	}

}
