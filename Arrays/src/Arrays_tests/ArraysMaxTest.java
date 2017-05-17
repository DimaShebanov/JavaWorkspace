package Arrays_tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArraysMaxTest 
{

	@Test
	public void testmax_1() 
	{
		int[] arr={2};
		int max=ArraysMax.max(arr);
		System.out.println(max);
		assertEquals(2, max);
	}
	@Test
	public void testmax_2() 
	{
		int[] arr={2,39};
		int max=ArraysMax.max(arr);
		System.out.println(max);
		assertEquals(39, max);
	}
	@Test (expected=IllegalArgumentException.class)
	public void testmax_null() 
	{
		int[] arr=null;
		int max=ArraysMax.max(arr);
	}
	@Test (expected=IllegalArgumentException.class)
	public void testmax_0() 
	{
		int[] arr={};
		int max=ArraysMax.max(arr);

	}
	@Test
	public void testmax_many() 
	{
		int[] arr={13,456,2,443,679,1,2};
		int max=ArraysMax.max(arr);
		System.out.println(max);
		assertEquals(679, max);
	}

}
