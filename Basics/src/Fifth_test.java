import javax.swing.JOptionPane;

public class Fifth_test {

	public static void main(String[] args) {
		int mark=0;
		char m='a';
		mark=Integer.parseInt(JOptionPane.showInputDialog("Введите оценку студента:"));
		if(mark>0&mark<=19)
			m='F';
		else if(mark>19&mark<=39)
			m='E';
		else if(mark>39&mark<=59)
			m='D';
		else if(mark>59&mark<=74)
			m='C';
		else if(mark>74&mark<=89)
			m='B';
		else if(mark>89&mark<=100)
			m='A';
	JOptionPane.showMessageDialog(null, "Оценка студента "+m);
	
	}	
}
