import static org.junit.Assert.*;

import org.junit.Test;

public class Usloper_3Test 
{

	@Test
	public void bminus() 
	{
		int s=Usloper_3.polozh(13,-156,22);
		System.out.println(s);
		assertEquals(35, s);
	}
	@Test
	public void vseplus() 
	{
		int s=Usloper_3.polozh(13,56,22);
		System.out.println(s);
		assertEquals(91, s);
	}
	@Test
	public void vseminus() 
	{
		int s=Usloper_3.polozh(-13,-156,-22);
		System.out.println(s);
		assertEquals(0, s);
	}
	@Test
	public void vse0() 
	{
		int s=Usloper_3.polozh(0,0,0);
		System.out.println(s);
		assertEquals(0, s);
	}
	@Test
	public void plus1() 
	{
		int s=Usloper_3.polozh(13,-156,-22);
		System.out.println(s);
		assertEquals(13, s);
	}
	@Test
	public void plus2() 
	{
		int s=Usloper_3.polozh(-13,156,-22);
		System.out.println(s);
		assertEquals(156, s);
	}
	@Test
	public void plus3() 
	{
		int s=Usloper_3.polozh(-13,-156,22);
		System.out.println(s);
		assertEquals(22, s);
	}
	@Test
	public void minus3_vse0() 
	{
		int s=Usloper_3.polozh(0,0,-22);
		System.out.println(s);
		assertEquals(0, s);
	}
	

}
