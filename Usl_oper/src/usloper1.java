public class usloper1 {

	public static void main(String[] args) 
	{
		int a=11;
		int b=24;
		int s;
		s=usl(a,b);
				System.out.println(s);
	}


	public static int usl(int a,int b) 
	{
		if(a%2==0)
		{
			return a*b;
		}
		else
		{
			return a+b;
		}
	}
}
