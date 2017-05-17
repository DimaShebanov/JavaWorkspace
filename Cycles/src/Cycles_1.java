public class Cycles_1 {

	public static void main(String[] args) 
	{
		int sum=chetniesum();
		int count=chetniecount();
		System.out.println(sum+" "+count);
	}
	public static int chetniesum() 
	{
		int sum=0;
		for(int i=1;i<=99;i++)
		{
			if(i%2==0)
			{
				sum+=i;
			}
			else continue;
		}
	return sum;
	}
	
	public static int chetniecount() 
	{
		int count=0;
		for(int i=1;i<=99;i++)
		{
			if(i%2==0)
			{
				count++;
			}
			else continue;
		}
	return count;
	}
}
