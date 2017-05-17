import javax.swing.JOptionPane;

public class Func_1 {

	public static void day(int number)
	{
		switch(number)
		{
		case 1:
			JOptionPane.showMessageDialog(null, "Вы выбрали понедельник");
			break;
		case 2:
			JOptionPane.showMessageDialog(null, "Вы выбрали вторник");
			break;
		case 3:
			JOptionPane.showMessageDialog(null, "Вы выбрали среда");
			break;
		case 4:
			JOptionPane.showMessageDialog(null, "Вы выбрали четверг");
			break;
		case 5:
			JOptionPane.showMessageDialog(null, "Вы выбрали пятница");
			break;
		case 6:
			JOptionPane.showMessageDialog(null, "Вы выбрали суббота");
			break;
		case 7:
			JOptionPane.showMessageDialog(null, "Вы выбрали воскресенье");
			break;
		default:
			JOptionPane.showMessageDialog(null, "Вы ввели неверное число и я не могу найти день недели!");
		}
	}
	
	public static void main(String[] args) {
		int choose=Integer.parseInt(JOptionPane.showInputDialog("Введите номер дня недели: "));
		day(choose);
		
	}

}
