import javax.swing.JOptionPane;

public class Seventh_test {

	public static void main(String[] args) {
		double num=Double.parseDouble(JOptionPane.showInputDialog("Введите число в диапазоне 1-999,999,999 которое вы хотите проверить: "));
		int count=0;
		String text="Число делится на: ";
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
			text=text+" и не является простым";
		else
			text=text+" и является простым";
		
		JOptionPane.showMessageDialog(null,text);
	}

}
