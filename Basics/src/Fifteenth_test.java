import javax.swing.JOptionPane;

public class Fifteenth_test {

	public static void main(String[] args) {
		int[] mas=new int[10];
		int max=0,index=0;
		String text="DO: |";
		for (int i=0;i<10;i++)
		{
			mas[i]=(int)(Math.random()*100);
			text=text+mas[i]+" | ";
		}
		for(int i=0;i<10;i++)
		{
			if(mas[i]>max)
			{
				max=mas[i];
				index=i+1;
			}
		}
		text=text+"\nMaximal element of this massive is :"+max+", and its index is: "+index;
		JOptionPane.showMessageDialog(null, text);

	}

}
