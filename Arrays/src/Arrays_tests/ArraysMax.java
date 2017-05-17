package Arrays_tests;

public class ArraysMax 
{
	public static void main(String[] args) 
	{
		int[] arr={3,21,4,12115,2};
		int max=arr[ArraysMinAndMaxIndex.MaxIndex(arr)];
		System.out.println(max);
	}

	public static int max(int[] arr) 
	{
		if (arr==null||arr.length==0) throw new IllegalArgumentException();
		int max=arr[0];
		for (int i=0;i<arr.length;i++)
		{
			if(arr[i]>max)
			{
				max=arr[i];
			}
		}
		return max;
	}
}
