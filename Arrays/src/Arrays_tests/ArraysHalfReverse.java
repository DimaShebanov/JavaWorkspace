package Arrays_tests;

import java.util.Arrays;

public class ArraysHalfReverse 
{

	public static void main(String[] args) 
	{
		int[] arr={1,11,111,333,222,22};
		HalfReverse(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void HalfReverse(int[] arr) 
	{
		if (arr==null||arr.length==0){return ;}
		if(arr.length<=1){return;}
		int temp=0;
		int mid=arr.length-(arr.length/2);
		for(int i=0;i<arr.length/2;i++)
		{
			temp=arr[i];
			arr[i]=arr[mid+i];
			arr[mid+i]=temp;
		}
	}

}
