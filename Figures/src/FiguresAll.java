
public class FiguresAll {

	public static void main(String[] args) 
	{
		X();
		System.out.println("");
		Square();
		System.out.println("");
		Square111();
		System.out.println("");
		Square777();
		System.out.println("");
		Square123();
		System.out.println("");
		Square765();
		System.out.println("");
		Triangle1();
		System.out.println("");
		Triangle2();
		System.out.println("");
		Triangle3();
		System.out.println("");
		Triangle4();
		System.out.println("");
		LessTriangle1();
		System.out.println("");
		LessTriangle2();
		System.out.println("");
		LessTriangle3();
		System.out.println("");
		LessTriangle4();
		System.out.println("");
	}

	public static void X()
	{
		for (int i=1;i<=7;i++)
		{
			for (int j=1;j<=7;j++)
			{
				if(i==j||i+j==8)
				{
					System.out.print("* ");
				}
				else
				{
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
	
	public static void Square()
	{
		for (int i=1;i<=7;i++)
		{
			for (int j=1;j<=7;j++)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
	public static void Square111()
	{
		for (int i=1;i<=7;i++)
		{
			for (int j=1;j<=7;j++)
			{
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
	
	public static void Square777()
	{
		for (int i=1;i<=7;i++)
		{
			for (int j=1;j<=7;j++)
			{
				System.out.print(8-i+" ");
			}
			System.out.println();
		}
	}
	
	public static void Square123()
	{
		for (int i=1;i<=7;i++)
		{
			for (int j=1;j<=7;j++)
			{
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	
	public static void Square765()
	{
		for (int i=1;i<=7;i++)
		{
			for (int j=1;j<=7;j++)
			{
				System.out.print(8-j+" ");
			}
			System.out.println();
		}
	}
	
	public static void Triangle1()
	{
		for (int i=1;i<=7;i++)
		{
			for (int j=1;j<=7;j++)
			{
				if(i+j==8||j==1||i==1)
				{
					System.out.print("* ");
				}
				else
				{
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
	public static void Triangle2()
	{
		for (int i=1;i<=7;i++)
		{
			for (int j=1;j<=7;j++)
			{
				if(i==j||j==1||i==7)
				{
					System.out.print("* ");
				}
				else
				{
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
	public static void Triangle3()
	{
		for (int i=1;i<=7;i++)
		{
			for (int j=1;j<=7;j++)
			{
				if(i==j||j==7||i==1)
				{
					System.out.print("* ");
				}
				else
				{
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
	public static void Triangle4()
	{
		for (int i=1;i<=7;i++)
		{
			for (int j=1;j<=7;j++)
			{
				if(i+j==8||i==7||j==7)
				{
					System.out.print("* ");
				}
				else
				{
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
	public static void LessTriangle1()
	{
		for (int i=1;i<=4;i++)
		{
			for (int j=1;j<=7;j++)
			{
				if(i==1||i==j||i+j==8)
				{
					System.out.print("* ");
				}
				else 
				{
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
	public static void LessTriangle2()
	{
		for (int i=1;i<=7;i++)
		{
			for (int j=1;j<=4;j++)
			{
				if(j==1||i==j||i+j==8)
				{
					System.out.print("* ");
				}
				else 
				{
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
	public static void LessTriangle3()
	{
		for (int i=4;i<=7;i++)
		{
			for (int j=1;j<=7;j++)
			{
				if(i==7||i==j&&i+j==8)
				{
					System.out.print("* ");
				}
				else 
				{
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
	public static void LessTriangle4()
	{
		for (int i = 1 ; i <= 7 ; i++)
		{
			for (int j = 4 ; j <= 7 ; j++)
			{
				if(j == 7 || i == j || i + j == 8)
				{
					System.out.print("* ");
				}
				else 
				{
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
	
	
}
