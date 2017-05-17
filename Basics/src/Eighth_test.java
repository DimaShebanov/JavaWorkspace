public class Eighth_test {

	public static void main(String[] args) {
		int num=2278;
		int res=square(num);
		System.out.println(res);
	}

	public static int square(int num) 
	{
		int res=0;
		for (double i=1;i<=num;i+=0.5)
		{
			if (num/i>=i&&num/i<=i+0.99)
			{
				res=(int)i;
			}
		}
		return res;
	}
}
