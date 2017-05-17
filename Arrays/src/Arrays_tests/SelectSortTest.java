package Arrays_tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SelectSortTest 
{

	@Test
	public void ArraysSelectSortTest_null() 
	{
		int[] arr=null;
		SelectSort.SelectSort(arr);
		int[] arrTest=null;
		assertArrayEquals(arrTest,arr);
	}
	@Test
	public void ArraysSelectSortTest_0() 
	{
		int[] arr={};
		SelectSort.SelectSort(arr);
		int[] arrTest={};
		assertArrayEquals(arrTest,arr);
	}
	@Test
	public void ArraysSelectSortTest_1() 
	{
		int[] arr={23};
		SelectSort.SelectSort(arr);
		System.out.println(Arrays.toString(arr));
		int[] arrTest={23};
		assertArrayEquals(arrTest,arr);
	}
	@Test
	public void ArraysSelectSortTest_2() 
	{
		int[] arr={576,4};
		SelectSort.SelectSort(arr);
		System.out.println(Arrays.toString(arr));
		int[] arrTest={4,576};
		assertArrayEquals(arrTest,arr);
	}
	@Test
	public void ArraysSelectSortTest_many_even() 
	{
		int[] arr={23,4,576,53,55,322,41,1,2,55};
		SelectSort.SelectSort(arr);
		System.out.println(Arrays.toString(arr));
		int[] arrTest={1,2,4,23,41,53,55,55,322,576};
		assertArrayEquals(arrTest,arr);
	}
	@Test
	public void ArraysSelectSortTest__odd() 
	{
		int[] arr={23,4,576,53,55,322,41,2,55};
		SelectSort.SelectSort(arr);
		System.out.println(Arrays.toString(arr));
		int[] arrTest={2,4,23,41,53,55,55,322,576};
		assertArrayEquals(arrTest,arr);
	}

}
