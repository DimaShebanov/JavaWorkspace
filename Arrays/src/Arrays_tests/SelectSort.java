package Arrays_tests;

import java.util.Arrays;

public class SelectSort 
{
	public static void main(String[] args) 
	{
		int[] arr={312,54,77,5,3,42,678,1};
		SelectSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void SelectSort(int[] arr) 
	{
		if (arr==null||arr.length==0){return ;}
		if(arr.length<=1){return;}
		int min;
		int minInd;
		for(int i=0;i<arr.length-1;i++)
		{
			min=arr[i];
			minInd=i;
			for(int j=i;j<arr.length;j++)
			{
				if(arr[j]<min)
				{
					min=arr[j];
					minInd=j;
				}
				else
				{
					continue;
				}
			}
			arr[minInd]=arr[i];
			arr[i]=min;
		}
	}
}
