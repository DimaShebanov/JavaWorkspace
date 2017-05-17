
public class Iks 
{

	public static void main(String[] args) 
	{
		Krest();
	}

	public static void Krest() 
	{
		int beg=0;
		int end=8;
		for(int i=1;i<=7;i++)
		{
			for(int j=1;j<=7;j++)
			{
				if(j==end-i||j==beg+i)
				{
					System.out.print("* ");
				}
				else
				{
					System.out.print("  ");
				}
			}
			System.out.println("");
		}
	}
}
