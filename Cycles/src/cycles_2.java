public class cycles_2 
{
	public static void main(String[] args) 
	{
		int num=2;
		boolean prostoe=proverka(num);
		System.out.println(prostoe);
	}

	public static boolean proverka(int num) 
	{
		int count=0;
		if(num<=0) throw new IllegalArgumentException();
		for (int i=1;i<=999999999;i++)
		{
			if(num%i==0)
			{
				count++;
			}	
			if (num==i)
				break;			
		}

		if(count>2)
			return false;
		else
			return true;
	}
}
