import javax.swing.JOptionPane;

public class Seventh_test {

	public static void main(String[] args) {
		double num=Double.parseDouble(JOptionPane.showInputDialog("������� ����� � ��������� 1-999,999,999 ������� �� ������ ���������: "));
		int count=0;
		String text="����� ������� ��: ";
		for (int i=0;i<=999999999;i++)
		{
			if(num%i==0)
			{
			text=text+i+",";
			count++;
			}	
			if (num==i)
				break;			
		}
		if(count>2)
			text=text+" � �� �������� �������";
		else
			text=text+" � �������� �������";
		
		JOptionPane.showMessageDialog(null,text);
	}

}
