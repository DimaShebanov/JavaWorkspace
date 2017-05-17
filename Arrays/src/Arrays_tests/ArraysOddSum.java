package Arrays_tests;

public class ArraysOddSum 
{
	public static void main(String[] args) 
	{
		int[] arr={};
		int sum=SumOdd(arr);
		System.out.println(sum);
	}

	public static int SumOdd(int[] arr) 
	{
		if(arr==null||arr.length==0) {throw new IllegalArgumentException();}
		int sum=arr[0];
		if(arr.length>0)
		{
			for (int i=0;i<arr.length;i++)
			{
				if(i%2!=0)
				{
					sum+=arr[i];
				}
			}
		}
		return sum;	
	}
}
