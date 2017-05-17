public class cycles_4 
{
	public static void main(String[] args) 
	{
		int num=0;
		long sum=fact(num);
		System.out.println(sum);
	}
	
	public static long fact(int num) 
	{
		long sum=1;
		if(num<=0) throw new IllegalArgumentException();
		for (int i=1;i<=num;i++)
		{
			sum=sum*i;
		}
		return sum;
	}

}
