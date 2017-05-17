import javax.swing.JOptionPane;

public class Fourteenth_test {

	public static void main(String[] args) 
	{
		int[] mas=new int[10];
		int min=100000,index=0;
		String text="DO: |";
		for (int i=0;i<10;i++)
		{
			mas[i]=(int)(Math.random()*1000);
			text=text+mas[i]+" | ";
		}
		for(int i=0;i<10;i++)
		{
			if(mas[i]<min)
			{
				min=mas[i];
				index=i+1;
			}
		}
		text=text+"\nMinimal element of this massive is: "+min+", and its index is: "+index;
		
		JOptionPane.showMessageDialog(null, text);

	}

}