
public class Triangles 
{

	public static void main(String[] args) 
	{
		Triangle1();
		System.out.println("");
		Triangle1_111();
		System.out.println("");
		Triangle1_777();
		System.out.println("");
		Triangle2();
		System.out.println("");
		Triangle2_111();
		System.out.println("");
		Triangle2_777();
		System.out.println("");
		Triangle3();
		System.out.println("");
		Triangle3_111(); 
		System.out.println("");
		Triangle3_777();
		System.out.println("");
		Triangle4();		
	}

	public static void Triangle1() 
	{
		int end=7;
		for(int i=0;i<7;i++)
		{
			for(int j=0;j<end-i;j++)
			{
				System.out.print("* ");
			}
			System.out.println("");
		}
	}
	
	public static void Triangle1_111() 
	{
		int end=8;
		for(int i=1;i<8;i++)
		{
			for(int j=0;j<end-i;j++)
			{
				System.out.print(i+" ");
			}
			System.out.println("");
		}
	}
	
	public static void Triangle1_777() 
	{
		int end=8;
		int q=7;
		for(int i=1;i<8;i++)
		{
			for(int j=0;j<end-i;j++)
			{
				System.out.print(q+" ");
			}
			System.out.println("");
			q--;
		}
	}


	public static void Triangle2() 
	{
		for(int i=0;i<=7;i++)
		{
			for(int j=0;j<i;j++)
			{
				System.out.print("* ");
			}
			System.out.println("");
		}
	}
	
	public static void Triangle2_111() 
	{
		for(int i=0;i<=7;i++)
		{
			for(int j=0;j<i;j++)
			{
				System.out.print(i+" ");
			}
			System.out.println("");
		}
	}
	
	
	public static void Triangle2_777() 
	{
		for(int i=8;i>0;i--)
		{
			for(int j=8;j>i;j--)
			{
				System.out.print(i+" ");
			}
			System.out.println("");
		}
	}

	public static void Triangle3() 
	{
		for(int i=0;i<=7;i++)
		{
			if(i!=0)
			{
				for(int j=0;j<i;j++)
				{
					System.out.print("  ");
				}
			}
			for(int j=i;j<7;j++)
			{
				System.out.print("* ");
			}
			System.out.println("");
		}
	}
	
	public static void Triangle3_111() 
	{
		for(int i=1;i<=8;i++)
		{
			if(i!=1)
			{
				for(int j=1;j<i;j++)
				{
					System.out.print("  ");
				}
			}
			for(int j=i;j<8;j++)
			{
				System.out.print(i+" ");
			}
			System.out.println("");
		}
	}

	
	public static void Triangle3_777() 
	{
		int q=7;
		for(int i=1;i<=8;i++)
		{
			if(i!=1)
			{
				for(int j=1;j<i;j++)
				{
					System.out.print("  ");
				}
			}
			for(int j=i;j<8;j++)
			{
				System.out.print(q+" ");
			}
			System.out.println("");
			q--;
		}
	}

	public static void Triangle4() 
	{
		for(int i=0;i<=7;i++)
		{
			if(i!=7)
			{
				for(int j=i;j<7;j++)
				{
					System.out.print("  ");
				}			
			}
			for(int j=0;j<i;j++)
			{
				System.out.print("* ");
			}
			System.out.println("");
		}
	}


}
