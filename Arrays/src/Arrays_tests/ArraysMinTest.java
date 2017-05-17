package Arrays_tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArraysMinTest 
{

	@Test
	public void testmin_1() 
	{
		int[] arr={2};
		int min=ArraysMin.min(arr);
		System.out.println(min);
		assertEquals(2, min);
	}
	@Test
	public void testmin_2() 
	{
		int[] arr={2,1};
		int min=ArraysMin.min(arr);
		System.out.println(min);
		assertEquals(1, min);
	}
	@Test (expected=IllegalArgumentException.class)
	public void testmin_null() 
	{
		int[] arr=null;
		int min=ArraysMin.min(arr);
	}
	@Test (expected=IllegalArgumentException.class)
	public void testmin_0() 
	{
		int[] arr={};
		int min=ArraysMin.min(arr);

	}
	@Test
	public void testmin_many() 
	{
		int[] arr={13,456,2,443,679,1,2};
		int min=ArraysMin.min(arr);
		System.out.println(min);
		assertEquals(1, min);
	}
	@Test
	public void testmin_minus_many() 
	{
		int[] arr={12,555,-185,-2639,-1};
		int min=ArraysMin.min(arr);
		System.out.println(min);
		assertEquals(-2639, min);
	}
}
