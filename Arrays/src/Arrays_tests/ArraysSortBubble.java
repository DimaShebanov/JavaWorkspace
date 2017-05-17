package Arrays_tests;

import java.util.Arrays;

public class ArraysSortBubble 
{
	public static void main(String[] args) 
	{
		int[] arr={23,4,576,53,55,322,41,1,2,55};
		SortBubble(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void SortBubble(int[] arr) 
	{
		if (arr==null||arr.length==0){return ;}
		if(arr.length<=1){return;}
		int temp=0;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr.length-1;j++)
			{
				if(arr[j]>arr[j+1])
				{
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
}
