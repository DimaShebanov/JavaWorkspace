import javax.swing.JOptionPane;

public class Sixth_test {

	public static void main(String[] args) {
		double sum=0;
		int num=0;
		String text="";
		for(int i=1;i<100;i++)
		{
			if(i%2==0)
			{
				sum+=i;
				num++;
				text=text+"|"+i;
			}
			else
				continue;
		}
		JOptionPane.showMessageDialog(null, "Количество четных чисел в диапазоне от 1 до 99="+num+"\nИх сумма="+sum+"\nИ вот они"+text);
	}

}
