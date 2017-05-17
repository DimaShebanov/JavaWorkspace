package Arrays_tests;

public class ArraysOddElem 
{
	public static void main(String[] args) 
	{
		int[] arr={3,3,3,4,4,314777};
		int count=OddElemCount(arr);
		System.out.println(count);
	}
	
	public static int OddElemCount(int[] arr) 
	{
		if (arr==null||arr.length==0){return 0;}
		int count=0;
		for (int i=0;i<arr.length;i++)
		{
			if(arr[i]%2-1>=0)
			{
			count++;
			}
		}
		return count;
	}
}
