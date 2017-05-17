public class usloper_2 
{

	public static void main(String[] args) {
		double x=-10,y=-1;
		int quarter=qua(x,y);
		System.out.println(quarter);
	}

	public static int qua(double x,double y) 
	{
		int quarter=0;
		if(x==0||y==0)
		{
			throw new IllegalArgumentException();
		}
		if(x>0&&y>0) {quarter=1;}
		else if(x<0&&y>0) {quarter=2;}
		else if(x<0&&y<0) {quarter=3;}
		else if(x>0&&y<0) {quarter=4;}
		return quarter;
	}


}
