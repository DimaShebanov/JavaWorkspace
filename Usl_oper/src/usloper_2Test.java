import static org.junit.Assert.*;

import org.junit.Test;

public class usloper_2Test 
{

	@Test
	public void first() 
	{
		int quarter=usloper_2.qua(10,10);
		System.out.println(quarter);
		assertEquals(1, quarter);
	}
	@Test
	public void second() 
	{
		int quarter=usloper_2.qua(-10,15);
		System.out.println(quarter);
		assertEquals(2, quarter);
	}
	
	
	@Test
	public void third() 
	{
		int quarter=usloper_2.qua(-10,-23);
		System.out.println(quarter);
		assertEquals(3, quarter);
	}
	
	
	@Test
	public void fourth() 
	{
		int quarter=usloper_2.qua(10,-1);
		System.out.println(quarter);
		assertEquals(4, quarter);
	}
	
	
	@Test (expected = IllegalArgumentException.class)
	public void exception_x0() 
	{
		int quarter=usloper_2.qua(0,15);
		System.out.println(quarter);
	}
	
	
	@Test (expected = IllegalArgumentException.class)
	public void exception_y0() 
	{
		int quarter=usloper_2.qua(18,0);
		System.out.println(quarter);
	}

}
