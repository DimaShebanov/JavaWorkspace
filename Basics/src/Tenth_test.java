public class Tenth_test 
{

	public static void main(String[] args) 
	{
		int num=21536;
		int sum=sum(num);
		System.out.println(sum);
	}

	public static long sum(num) 
	{
		for(int n=num;n!=0;n/=10)
		{
			sum=sum+(n%10);
		}
		return sum;
	}
}
