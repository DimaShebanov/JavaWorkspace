package Arrays_tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class OddElemCountTest 
{

	@Test
	public void OddElemCountTest_null() 
	{
		int[] arr=null;
		int count=ArraysOddElem.OddElemCount(arr);
		System.out.println(count);
		assertEquals(0, count);
	}
	@Test
	public void OddElemCountTest_0() 
	{
		int[] arr={};
		int count=ArraysOddElem.OddElemCount(arr);
		System.out.println(count);
		assertEquals(0, count);
	}
	@Test
	public void OddElemCountTest_1() 
	{
		int[] arr={3};
		int count=ArraysOddElem.OddElemCount(arr);
		System.out.println(count);
		assertEquals(1, count);
	}
	@Test
	public void OddElemCountTest_2() 
	{
		int[] arr={3,74};
		int count=ArraysOddElem.OddElemCount(arr);
		System.out.println(count);
		assertEquals(1, count);
	}
	@Test
	public void OddElemCountTest_many_odd() 
	{
		int[] arr={3,3,3,4,4,31,47,77};
		int count=ArraysOddElem.OddElemCount(arr);
		System.out.println(count);
		assertEquals(6, count);
	}
	@Test
	public void OddElemCountTest__even() 
	{
		int[] arr={3,3,3,4,4,31,47,77,157};
		int count=ArraysOddElem.OddElemCount(arr);
		System.out.println(count);
		assertEquals(7, count);
	}

}
