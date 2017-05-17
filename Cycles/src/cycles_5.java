
public class cycles_5 
{
		public static void main(String[] args) 
		{
			int num=-22147;
			int sum=sum(num);
			System.out.println(sum);
		}

		public static int sum(int num)
		{
			int sum=0;
			if (num<0) num=num*-1;
			if (num==0) throw new IllegalArgumentException();
			for(int n=num;n!=0;n/=10)
			{
				sum=sum+(n%10);
			}
			return sum;
		}
	}
