import static org.junit.Assert.*;

import org.junit.Test;

public class cycles_3Test 
{

	@Test
	public void lessthan100() 
	{
		int res=cycles_3.square(17);
		System.out.println(res);
		assertEquals(4, res);
	}
	@Test
	public void lessthan1000() 
	{
		int res=cycles_3.square(834);
		System.out.println(res);
		assertEquals(28, res);
	}
	@Test
	public void morethan10000() 
	{
		int res=cycles_3.square(39785);
		System.out.println(res);
		assertEquals(199, res);
	}
	@Test (expected=IllegalArgumentException.class)
	public void noll() 
	{
		int res=cycles_3.square(0);
		System.out.println(res);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void minusovoe() 
	{
		int res=cycles_3.square(-43);
		System.out.println(res);
	}

}
