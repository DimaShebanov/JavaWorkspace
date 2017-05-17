package Arrays_tests;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class ArraysMin 
{
	public static void main(String[] args) 
	{
		int[] arr={3,2,1,-2,11};
		int min=arr[ArraysMinAndMaxIndex.MinIndex(arr)];
		System.out.println(min);
	}

	public static int min(int[] arr) 
	{
		if (arr==null||arr.length==0) throw new IllegalArgumentException();
		int min=arr[0];
		for (int i=0;i<arr.length;i++)
		{
			if(arr[i]<min)
			{
				min=arr[i];
			}
		}
		return min;
	}


}
