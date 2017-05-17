import javax.swing.JOptionPane;

public class Twelwth_test {

	public static void main(String[] args) {
		int[] mas=new int[10];
		int min=100000;
		String text="DO: |";
		for (int i=0;i<10;i++)
		{
			mas[i]=(int)(Math.random()*100);
			text=text+mas[i]+" | ";
		}
		for(int i=0;i<10;i++)
		{
			if(mas[i]<min)
			{
				min=mas[i];
			}
		}
		text=text+"\nMinimal element of this massive is :"+min;
		
		JOptionPane.showMessageDialog(null, text);

	}

}
