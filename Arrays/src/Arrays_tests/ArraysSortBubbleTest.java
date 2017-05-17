package Arrays_tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ArraysSortBubbleTest 
{

	@Test
	public void SortBubbleTest_null() 
	{
		int[] arr=null;
		ArraysSortBubble.SortBubble(arr);
		int[] arrTest=null;
		assertArrayEquals(arrTest,arr);
	}
	@Test
	public void SortBubbleTest_0() 
	{
		int[] arr={};
		ArraysSortBubble.SortBubble(arr);
		int[] arrTest={};
		assertArrayEquals(arrTest,arr);
	}
	@Test
	public void SortBubbleTest_1() 
	{
		int[] arr={23};
		ArraysSortBubble.SortBubble(arr);
		System.out.println(Arrays.toString(arr));
		int[] arrTest={23};
		assertArrayEquals(arrTest,arr);
	}
	@Test
	public void SortBubbleTest_2() 
	{
		int[] arr={576,4};
		ArraysSortBubble.SortBubble(arr);
		System.out.println(Arrays.toString(arr));
		int[] arrTest={4,576};
		assertArrayEquals(arrTest,arr);
	}
	@Test
	public void SortBubbleTest_many_even() 
	{
		int[] arr={23,4,576,53,55,322,41,1,2,55};
		ArraysSortBubble.SortBubble(arr);
		System.out.println(Arrays.toString(arr));
		int[] arrTest={1,2,4,23,41,53,55,55,322,576};
		assertArrayEquals(arrTest,arr);
	}
	@Test
	public void SortBubbleTest__odd() 
	{
		int[] arr={23,4,576,53,55,322,41,2,55};
		ArraysSortBubble.SortBubble(arr);
		System.out.println(Arrays.toString(arr));
		int[] arrTest={2,4,23,41,53,55,55,322,576};
		assertArrayEquals(arrTest,arr);
	}

}
