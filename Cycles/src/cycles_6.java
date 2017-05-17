
public class cycles_6 
{
	public static void main(String[] args) 
	{
		int mir=Integer.parseInt(mirror(2134894));
		System.out.println(mir);
	}
	
	public static String mirror(int num) 
	{
		String text="";
		for(int n=num;n!=0;n/=10)
		{
			text=text+(n%10);
		}
		return text;
	}
}
