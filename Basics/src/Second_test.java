import javax.swing.JOptionPane;

public class Second_test {

	public static void main(String[] args) {
		double x,y;
		int quarter=0;
		x=Double.parseDouble(JOptionPane.showInputDialog("Please insert an \"X\" coordinate: "));
		y=Double.parseDouble(JOptionPane.showInputDialog("Please insert an \"Y\" coordinate: "));
		if(x>=0)
			{if(y>=0)
				quarter=1;
			else if(y<0)
			quarter=2;}
		else if(y>=0)
		{
			if(x<0)
				quarter=4;
		}
		else
			quarter=3;	
		JOptionPane.showMessageDialog(null,"Точка принадлежит "+quarter+" четверти");
	}

}
