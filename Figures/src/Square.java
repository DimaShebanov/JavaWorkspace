
public class Square {

	public static void main(String[] args) 
	{
		Squa();
		System.out.println("");
		Squanobord_111();
		System.out.println("");
		Squanobord_777();
		System.out.println("");
		Squanobord_123();
		System.out.println("");
		Squanobord_765();
	}


	public static void Squa() 
	{
		for(int i=0;i<=7;i++)
		{
			if(i>=1&&i<=6)
			{
				System.out.print("|");	
			}
			if(i==0||i==7)
			{
				System.out.print(" ");
			}
			for(int j=0;j<=7;j++)
			{
				if(i==0||i==7)
				{
					System.out.print("--");
				}
				else
				{
					System.out.print("* ");
				}
			}
			if(i>=1&&i<=6)
			{
				System.out.println("|");	
			}
			else if(i==0||i==7)
			{
				System.out.println("");
			}
		}
	}




	public static void Squanobord_111() 
	{
		for(int i=1;i<8;i++)
		{
			for(int j=0;j<7;j++)
			{
				System.out.print(i+" ");
			}
			System.out.println("");
		}
	}
	
	
	public static void Squanobord_777() 
	{
		for(int i=7;i>0;i--)
		{
			for(int j=0;j<7;j++)
			{
				System.out.print(i+" ");
			}
			System.out.println("");
		}
	}
	
	public static void Squanobord_123() 
	{
		for(int i=1;i<8;i++)
		{
			for(int j=1;j<8;j++)
			{
				System.out.print(j+" ");
			}
			System.out.println("");
		}
	}
	
	public static void Squanobord_765() 
	{
		for(int i=7;i>0;i--)
		{
			for(int j=7;j>0;j--)
			{
				System.out.print(j+" ");
			}
			System.out.println("");
		}
	}
}
