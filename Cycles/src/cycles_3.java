public class cycles_3 {
	public static void main(String[] args) {
		int num=25;
		int res=sqposl(num);
		System.out.println(res);
	}

	public static int sqposl(int num) 
	{
		int res=0;
		if (num<=0){throw new IllegalArgumentException();}
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
