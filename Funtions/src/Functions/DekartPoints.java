package Functions;

import java.lang.Math;

public class DekartPoints 
{

	public static void main(String[] args) 
	{
		int ax=5;
		int ay=5;
		int bx=0;
		int by=15;
		int len=(int)DekartLenght(ax,ay,bx,by);	
		System.out.println(len);
	}

	public static double DekartLenght(int ax,int ay,int bx,int by) 
	{
		if(ax==0&&bx==0&&by==0&&ay==0){return 0;}
		double l=Math.sqrt(Math.pow((bx-ax),2)+Math.pow((by-ay),2));
		return l;
	}

}
