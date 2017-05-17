public class Usloper_3 
{

	public static void main(String[] args) 
	{
		int a=0;
		int b=0;
		int c=0;
		int s=polozh(a,b,c);
		System.out.println(s);
	}


	public static int polozh(int a,int b,int c) 
	{
		int s=0;
		if(a==0&&b==0&&c==0) s=0;
		if(a>0)	s+=a;
		if(b>0)	s+=b;
		if(c>0)	s+=c;
		return s;
	}

}
