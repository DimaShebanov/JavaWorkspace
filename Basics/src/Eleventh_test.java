import javax.swing.JOptionPane;

public class Eleventh_test {

	public static void main(String[] args) {
			int num=Integer.parseInt(JOptionPane.showInputDialog("¬ведите число,которое хотите \"отзеркалить\""));
			
			for(int n=num;n!=0;n/=10)
			{
				text=text+(n%10);
			}
			JOptionPane.showMessageDialog(null, text);

	}

}
