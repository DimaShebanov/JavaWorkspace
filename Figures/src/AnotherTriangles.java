
public class AnotherTriangles 
{

	public static void main(String[] args) 
	{
		ATriangle1();
		ATriangle2();
		ATriangle3();
//		ATriangle4();
	}

	public static void ATriangle1() 
	{
		int beg=0;
		int end=7;
		for (int i=0;i<7;i++)
		{
			for(int j=0;j<=7;j++)
			{
				if(j>=beg+i&&j<end-i)
				{
					System.out.print("* ");
				}
				else
				{
					System.out.print("__");
				}
			}
			System.out.println("");
		}
	}


	public static void ATriangle2() 
	{		
		int end=7;
		for (int i=0;i<7;i++)
		{
			for(int j=0;j<end-i;j++)
			{
				if(j<=i)
				{
					System.out.print("* ");
				}
			}
			System.out.println("");
		}
	}


	public static void ATriangle3() 
	{		
		int end=7;
		int mid=7-(7/2);
		for(int i=0;i<=7;i++)
		{
			for(int j=i;j<7;j++)
			{
				System.out.print("  ");
			}
			
			for(int j=0;j<i;j++)
			{
				System.out.print("* ");
			}
			System.out.println("");
		}
	}
}
