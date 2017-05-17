import javax.swing.JOptionPane;

public class Nineth_test {

	public static void main(String[] args) 
	{
		long sum=1,num=Long.parseLong(JOptionPane.showInputDialog("¬ведите число,факториал которого хотите узнать"));
		
		for (int i=1;i<=num;i++)
		{
			sum=sum*i;
		}
		JOptionPane.showMessageDialog(null, "‘акториал введенного числа равен: "+sum);
	}

}
