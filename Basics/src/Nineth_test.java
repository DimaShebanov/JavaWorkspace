import javax.swing.JOptionPane;

public class Nineth_test {

	public static void main(String[] args) 
	{
		long sum=1,num=Long.parseLong(JOptionPane.showInputDialog("������� �����,��������� �������� ������ ������"));
		
		for (int i=1;i<=num;i++)
		{
			sum=sum*i;
		}
		JOptionPane.showMessageDialog(null, "��������� ���������� ����� �����: "+sum);
	}

}
