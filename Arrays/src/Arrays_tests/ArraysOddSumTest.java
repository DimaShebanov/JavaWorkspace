package Arrays_tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArraysOddSumTest 
{

	@Test
	public void TestOddInd_many_odd() 
	{
		int[] arr={2,4,5654,3,435,7,12034};
		int sum=ArraysOddSum.SumOdd(arr);
		System.out.println(sum);
		assertEquals(16, sum);
	}
	@Test
	public void TestOddInd_many_even() 
	{
		int[] arr={2,4,5654,3,435,7};
		int sum=ArraysOddSum.SumOdd(arr);
		System.out.println(sum);
		assertEquals(16, sum);
	}
	@Test (expected=IllegalArgumentException.class)
	public void TestOddInd_null() 
	{
		int[] arr=null;
		ArraysOddSum.SumOdd(arr);
	}
	@Test (expected=IllegalArgumentException.class)
	public void TestOddInd_0() 
	{
		int[] arr={};
		ArraysOddSum.SumOdd(arr);
	}
	@Test
	public void TestOddInd_1() 
	{
		int[] arr={2};
		int sum=ArraysOddSum.SumOdd(arr);
		System.out.println(sum);
		assertEquals(2, sum);
	}
	@Test
	public void TestOddInd_2() 
	{
		int[] arr={2,4};
		int sum=ArraysOddSum.SumOdd(arr);
		System.out.println(sum);
		assertEquals(6, sum);
	}
}
