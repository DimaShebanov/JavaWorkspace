import javax.swing.JOptionPane;

public class Func_1 {

	public static void day(int number)
	{
		switch(number)
		{
		case 1:
			JOptionPane.showMessageDialog(null, "�� ������� �����������");
			break;
		case 2:
			JOptionPane.showMessageDialog(null, "�� ������� �������");
			break;
		case 3:
			JOptionPane.showMessageDialog(null, "�� ������� �����");
			break;
		case 4:
			JOptionPane.showMessageDialog(null, "�� ������� �������");
			break;
		case 5:
			JOptionPane.showMessageDialog(null, "�� ������� �������");
			break;
		case 6:
			JOptionPane.showMessageDialog(null, "�� ������� �������");
			break;
		case 7:
			JOptionPane.showMessageDialog(null, "�� ������� �����������");
			break;
		default:
			JOptionPane.showMessageDialog(null, "�� ����� �������� ����� � � �� ���� ����� ���� ������!");
		}
	}
	
	public static void main(String[] args) {
		int choose=Integer.parseInt(JOptionPane.showInputDialog("������� ����� ��� ������: "));
		day(choose);
		
	}

}
