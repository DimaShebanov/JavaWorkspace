package Arrays_tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArraysMinAndMaxIndexTest 
{

	@Test (expected = IllegalArgumentException.class)
	public void testMinIndex_null() 
	{
		int[] arr=null;
		ArraysMinAndMaxIndex.MinIndex(arr);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testMinIndex_0() 
	{
		int[] arr={};
		ArraysMinAndMaxIndex.MinIndex(arr);
	}
	@Test
	public void testMinIndex_1() 
	{
		int[] arr={21};
		int minIndex=ArraysMinAndMaxIndex.MinIndex(arr);
		System.out.println(minIndex);
		assertEquals(0, minIndex);
	}
	@Test
	public void testMinIndex_2() 
	{
		int[] arr={21,2};
		int minIndex=ArraysMinAndMaxIndex.MinIndex(arr);
		System.out.println(minIndex);
		assertEquals(1, minIndex);
	}
	@Test
	public void testMinIndex_many() 
	{
		int[] arr={21,213,456,77,12};
		int minIndex=ArraysMinAndMaxIndex.MinIndex(arr);
		System.out.println(minIndex);
		assertEquals(4, minIndex);
	}
	@Test
	public void testMinIndex_minus() 
	{
		int[] arr={21,-213,456,-77,12};
		int minIndex=ArraysMinAndMaxIndex.MinIndex(arr);
		System.out.println(minIndex);
		assertEquals(1, minIndex);
	}
	
//===================================================================
	@Test (expected = IllegalArgumentException.class)
	public void testMaxIndex_null() 
	{
		int[] arr=null;
		ArraysMinAndMaxIndex.MaxIndex(arr);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testMaxIndex_0() 
	{
		int[] arr={};
		ArraysMinAndMaxIndex.MaxIndex(arr);
	}
	@Test
	public void testMaxIndex_1() 
	{
		int[] arr={21};
		int maxIndex=ArraysMinAndMaxIndex.MaxIndex(arr);
		System.out.println(maxIndex);
		assertEquals(0, maxIndex);
	}
	@Test
	public void testMaxIndex_2() 
	{
		int[] arr={21,213};
		int maxIndex=ArraysMinAndMaxIndex.MaxIndex(arr);
		System.out.println(maxIndex);
		assertEquals(1, maxIndex);
	}
	@Test
	public void testMaxIndex_many() 
	{
		int[] arr={21,213,456,669,77,12};
		int maxIndex=ArraysMinAndMaxIndex.MaxIndex(arr);
		System.out.println(maxIndex);
		assertEquals(3, maxIndex);
	}
	@Test
	public void testMaxIndex_minus() 
	{
		int[] arr={21,-213,456,-77,12};
		int maxIndex=ArraysMinAndMaxIndex.MaxIndex(arr);
		System.out.println(maxIndex);
		assertEquals(2, maxIndex);
	}

}
