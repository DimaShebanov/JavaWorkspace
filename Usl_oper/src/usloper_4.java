public class usloper_4 
{	
		public static void main(String[] args) 
		{
			int a=0;
			int b=0;
			int c=0;
			int s=maxi(a,b,c);
			System.out.println(s);
		}
		public static int maxi(int a,int b,int c) 
		{
			int s=Math.max(a*b*c, (a+b+c))+3;
			return s;
		}
}
