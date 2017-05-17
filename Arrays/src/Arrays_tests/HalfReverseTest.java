package Arrays_tests;
import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;
public class HalfReverseTest 
{

	@Test
	public void HalfReverseTest_null() 
	{
		int[] arr=null;
		ArraysHalfReverse.HalfReverse(arr);
		int[] arrtest=null;
		assertArrayEquals(arrtest, arr);
	}
	@Test
	public void HalfReverseTest_0() 
	{
		int[] arr={};
		ArraysHalfReverse.HalfReverse(arr);
		int[] arrtest={};
		assertArrayEquals(arrtest, arr);
	}
	@Test
	public void HalfReverseTest_1() 
	{
		int[] arr={1};
		ArraysHalfReverse.HalfReverse(arr);
		System.out.println(Arrays.toString(arr));
		int[] arrtest={1};
		assertArrayEquals(arrtest, arr);
	}
	@Test
	public void HalfReverseTest_2() 
	{
		int[] arr={1,2};
		ArraysHalfReverse.HalfReverse(arr);
		System.out.println(Arrays.toString(arr));
		int[] arrtest={2,1};
		assertArrayEquals(arrtest, arr);
	}
	@Test
	public void HalfReverseTest_many_even() 
	{
		int[] arr={1,11,111,222,22,2};
		ArraysHalfReverse.HalfReverse(arr);
		System.out.println(Arrays.toString(arr));
		int[] arrtest={222,22,2,1,11,111};
		assertArrayEquals(arrtest, arr);
	}
	@Test
	public void HalfReverseTest_many_odd() 
	{
		int[] arr={1,11,111,333,222,22,2};
		ArraysHalfReverse.HalfReverse(arr);
		System.out.println(Arrays.toString(arr));
		int[] arrtest={222,22,2,333,1,11,111};
		assertArrayEquals(arrtest, arr);
	}

}
