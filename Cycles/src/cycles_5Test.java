import static org.junit.Assert.*;

import org.junit.Test;

public class cycles_5Test {

	@Test
	public void less100() 
	{
		int sum=cycles_5.sum(741);
		System.out.println(sum);
		assertEquals(12, sum);
	}
	@Test
	public void more10000() 
	{
		int sum=cycles_5.sum(28947);
		System.out.println(sum);
		assertEquals(30, sum);
	}
	@Test
	public void less0() 
	{
		int sum=cycles_5.sum(22147);
		System.out.println(sum);
		assertEquals(16, sum);
	}
	@Test (expected=IllegalArgumentException.class)
	public void test0() 
	{
		int sum=cycles_5.sum(0);
		System.out.println(sum);
	}
	

}
