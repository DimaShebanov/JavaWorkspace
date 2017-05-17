package Arrays_tests;

import java.util.Arrays;

public class ArraysReverse 
{
	public static void main(String[] args) 
	{
		int[] arr={1,2,3,4};
		Reverse(arr);
	}
	
	public static void Reverse(int[] arr) 
	{
		if(arr==null) {throw new IllegalArgumentException();}
		if(arr.length==0) return;
		int temp;
		for (int i=0;i<arr.length-(arr.length/2);i++)
		{
			temp=arr[i];
			arr[i]=arr[arr.length-1-i];
			arr[arr.length-1-i]=temp;
		}
		System.out.println(Arrays.toString(arr));
	}
}



