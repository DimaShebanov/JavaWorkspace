package Functions;

public class FunctionsNumToStringDays 
{

	public static void main(String[] args) 
	{
		int num=1;
		String day=DayOfWeek(num);
		System.out.println(day);
	}
	
	public static String DayOfWeek(int num) 
	{
		if(num<=0||num>=8){throw new IllegalArgumentException();}
		String[] days={"","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
		return days[num];
	}

}
