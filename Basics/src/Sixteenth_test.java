public class Sixteenth_test 
{

	public static void main(String[] args) 
	{
		int[] mas=new int[10];
		int sum=0;
		String text="";
		for (int i=0;i<10;i++)
		{
			mas[i]=(int)(Math.random()*100);
			text=text+mas[i]+" | ";
		}
		text+="\n";
		for (int i=0;i<10;i++)
		{
			if(i%2==0)
			{
				sum+=mas[i];
				text=text+mas[i]+"|";
			}
		}
	}

}
