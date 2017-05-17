
public class Converters 
{

	public static void main(String[] args) 
	{
		int stnum=StringToNum("234080");
		System.out.println(stnum);
		
		
		double Stdouble=StringToDouble("23411.0033");

	}



	public static int StringToNum(String text) 
	{
		char[] arr = {'0','1','2','3','4','5','6','7','8','9'};
		int arrlenght=arr.length;
		int textlenght=text.length();
		int res=0;
		int zeros=(int)(Math.pow(10, textlenght-1));
		for(int i=0;i<textlenght;i++)
		{
			for (int j=0;j<arrlenght;j++)
			{
				if(arr[j]==text.charAt(i))
				{
					res+=j*zeros;
				}
			}
			zeros/=10;
		}
		return res;
	}
	
	
	public static double StringToDouble(String text) 
	{
		char[] arr = {'0','1','2','3','4','5','6','7','8','9'};
		int dotochki;
		double res=0;
		for (int i=0;i<=)
		
		
		
		
		
		return res;
	}
}
