package Arrays_tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArraysReverseTest 
{
	@Test (expected=IllegalArgumentException.class)
	public void Reverse_null() 
	{
		int[] arr=null;
		ArraysReverse.Reverse(arr);
	}
	@Test 
	public void Reverse_0() 
	{
		int[] arr={};
		ArraysReverse.Reverse(arr);
		int[] arrAct={};
		assertArrayEquals(arrAct, arr);
	}
	@Test 
	public void Reverse_1() 
	{
		int[] arr={1};
		ArraysReverse.Reverse(arr);
		int[] arrAct={1};
		assertArrayEquals(arrAct, arr);
	}
	@Test 
	public void Reverse_2() 
	{
		int[] arr={1,2};
		ArraysReverse.Reverse(arr);
		int[] arrAct={2,1};
		assertArrayEquals(arrAct, arr);
	}
	@Test 
	public void Reverse_many_even() 
	{
		int[] arr={1,2,3,4,4,1,2,3};
		ArraysReverse.Reverse(arr);
		int[] arrAct={3,2,1,4,4,3,2,1};
		assertArrayEquals(arrAct, arr);
	}
	@Test 
	public void Reverse_many_odd() 
	{
		int[] arr={1,2,3,4,4,1,2,3,3};
		ArraysReverse.Reverse(arr);
		int[] arrAct={3,3,2,1,4,4,3,2,1};
		assertArrayEquals(arrAct, arr);
	}
}
