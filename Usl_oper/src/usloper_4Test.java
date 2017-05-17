import static org.junit.Assert.*;

import org.junit.Test;

public class usloper_4Test 
{

	@Test
	public void multi() 
	{
		int s=usloper_4.maxi(12,1,4);
		System.out.println(s);
		assertEquals(51, s);
	}
	@Test
	public void plus() 
	{
		int s=usloper_4.maxi(1,3,1);
		System.out.println(s);
		assertEquals(8, s);
	}
	@Test
	public void vse0() 
	{
		int s=usloper_4.maxi(0,0,0);
		System.out.println(s);
		assertEquals(3, s);
	}

}
