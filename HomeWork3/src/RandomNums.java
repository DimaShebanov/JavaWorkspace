
public class RandomNums 
{
	public static void main(String[] args) 
	{
		Random1();
		System.out.println("______________");
		Random10();
		System.out.println("______________");
		RandomZeroToTen10();
		System.out.println("______________");
		RandomTwentyToFifty_10();
		System.out.println("______________");
		RandomMinusTenToTen_10();
		System.out.println("______________");
		RandomMinusTenTo35_ThreeTo15();
		System.out.println("______________");
	}

	public static void Random1() 
	{
		System.out.println((int) (Math.random()*1089));
	}

	public static void Random10() 
	{
		for(int i=1;i<=10;i++)
		{
			System.out.println((int) (Math.random()*1089));
		}
	}

	public static void RandomZeroToTen10() 
	{
		for(int i=1;i<=10;i++)
		{
			System.out.println((int) (Math.random()*11));
		}
	}

	public static void RandomTwentyToFifty_10() 
	{
		for(int i=1;i<=10;i++)
		{
			System.out.println((int) (20+Math.random()*(51-20)));
		}	
	}

	public static void RandomMinusTenToTen_10() 
	{
		for(int i=1;i<=10;i++)
		{
			System.out.println((int) ((-10)+Math.random()*(11-(10))));
		}	
	}

	public static void RandomMinusTenTo35_ThreeTo15() 
	{
		int end=(int)(3+Math.random()*(16-3));
		for(int i=1;i<=end;i++)
		{
			System.out.println((int) ((-10)+Math.random()*(36-(-10))));
		}	
	}



}
