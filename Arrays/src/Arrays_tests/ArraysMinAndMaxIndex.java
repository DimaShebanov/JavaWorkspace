package Arrays_tests;
public class ArraysMinAndMaxIndex 
{
	public static void main(String[] args) 
	{
		int[] arr={21,213,456,77,12};
		int minIndex=MinIndex(arr);
		int maxIndex=MaxIndex(arr);
		System.out.println(minIndex);
		System.out.println(maxIndex);
	}

	public static int MinIndex(int[] arr) 
	{
		if (arr==null||arr.length==0) throw new IllegalArgumentException();
		int minIndex=0;
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]<arr[minIndex])
			{
				minIndex=i;
			}
		}
		return minIndex;
	}
	public static int MaxIndex(int[] arr) 
	{
		if (arr==null||arr.length==0) throw new IllegalArgumentException();
		int maxIndex=0;
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]>arr[maxIndex])
			{
				maxIndex=i;
			}
		}
		return maxIndex;
	}
}
