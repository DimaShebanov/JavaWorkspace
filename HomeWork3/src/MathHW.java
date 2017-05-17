public class MathHW
{

	public static void main(String[] args) 
	{
		double DegrDist=MathHW.ShootingDegrees(5,7);
		System.out.println(DegrDist+"\n");
		double RadDist=MathHW.ShootingRadians(1.5,726);
		System.out.println(RadDist+"\n");
		double AutoDist=MathHW.AutoDistance(55,101,250,0);
		System.out.println(AutoDist+"\n");
		System.out.println(LongFunc(3)+"\n");
		String LET=LETTERS();
		System.out.println(LET);
		String let=letters();
		System.out.println(let);
		String Rlet=rusLetters();
		System.out.println(Rlet);
		String nums=numbers();
		System.out.println(nums);
		String ascii=ASCII();
		System.out.println(ascii);
	}


	public static double ShootingDegrees (double angle,double speed) 
	{
		if (angle>=180) 
		{
			throw new IllegalArgumentException();
		}
		else
		{
			final double g=9.81;
			double speedMetr=speed*1000/3600;
			double RadAngle=Math.toRadians(angle);
			double dist=((Math.pow(speedMetr,2)) * (Math.sin(2*RadAngle) )  )/g;	
			return dist;
		}
	}

	public static double ShootingRadians (double angle,double speed) 
	{
		if(Math.toDegrees(angle*2)>=180)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			final double g=9.81;
			double speedMetr=speed*1000/3600;
			double dist=((Math.pow(speedMetr,2)) * (Math.sin(2*angle)))/g;	
			return dist;
		}
	}

	public static double AutoDistance(double v1,double v2,double distance,double time) 
	{
		if(time<0||distance<0)
		{
			throw new IllegalArgumentException();
		}
		else
		{
		double distanceNew=distance+(v1*time)+(v2*time);
		return distanceNew;
		}
	}

	public static double LongFunc(int x) 
	{
		
		double z=((6*Math.log(Math.sqrt(Math.pow(Math.E,(x+1))+2*Math.pow(Math.E, x)* Math.cos(x))))/
				Math.log(x-Math.pow(Math.E,(x-1))*Math.sin(x)))+
				Math.abs(Math.cos(x)/(Math.pow(Math.E,(Math.sin(x)))));
		return z;
	}

	public static String LETTERS() 
	{
		String text="|";
		char pos='A';
		while(pos<='Z')
		{
			text+=pos+"|";
			pos++;
		}
		return text;
	}

	public static String letters() 
	{
		String text="|";
		char pos='a';
		while(pos<='z')
		{
			text+=pos+"|";
			pos++;
		}
		return text;
	}

	public static String rusLetters() 
	{
		String text="|";
		char pos='à';
		while(pos<='ÿ')
		{
			text+=pos+"|";
			pos++;
		}
		return text;
	}

	public static String numbers() 
	{
		String text="|";
		int i=0;
		while(i<=9)
		{
			text+=i+"|";
			i++;
		}
		return text;
	}

	public static String ASCII() 
	{
		String text="|";
		char pos=32;
		while(pos<=127)
		{
			text+=pos+"|";
			pos++;
		}
		return text;
	}

}
