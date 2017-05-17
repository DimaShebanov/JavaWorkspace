import static org.junit.Assert.*;

import org.junit.Test;

public class usloper_5Test 
{
	@Test
	public void Fmid()
	{
		char m=usloper_5.mark(15);
		assertEquals('F', m);
	}
	@Test
	public void Fbeg()
	{
		char m=usloper_5.mark(1);
		assertEquals('F', m);
	}
	@Test
	public void Fend()
	{
		char m=usloper_5.mark(19);
		assertEquals('F', m);
	}
	@Test
	public void Emid()
	{
		char m=usloper_5.mark(22);
		assertEquals('E', m);
	}
	@Test
	public void Ebeg()
	{
		char m=usloper_5.mark(20);
		assertEquals('E', m);
	}
	@Test
	public void Eend()
	{
		char m=usloper_5.mark(39);
		assertEquals('E', m);
	}
	@Test
	public void Dmid()
	{
		char m=usloper_5.mark(43);
		assertEquals('D', m);
	}
	@Test
	public void Dbeg()
	{
		char m=usloper_5.mark(40);
		assertEquals('D', m);
	}
	@Test
	public void Dend()
	{
		char m=usloper_5.mark(59);
		assertEquals('D', m);
	}
	@Test
	public void Cmid()
	{
		char m=usloper_5.mark(64);
		assertEquals('C', m);
	}
	@Test
	public void Cbeg()
	{
		char m=usloper_5.mark(60);
		assertEquals('C', m);
	}
	@Test
	public void Cend()
	{
		char m=usloper_5.mark(74);
		assertEquals('C', m);
	}
	@Test
	public void Bmid()
	{
		char m=usloper_5.mark(81);
		assertEquals('B', m);
	}
	@Test
	public void Bbeg()
	{
		char m=usloper_5.mark(75);
		assertEquals('B', m);
	}
	@Test
	public void Bend()
	{
		char m=usloper_5.mark(89);
		assertEquals('B', m);
	}
	@Test
	public void Amid()
	{
		char m=usloper_5.mark(95);
		assertEquals('A', m);
	}
	@Test
	public void Abeg()
	{
		char m=usloper_5.mark(90);
		assertEquals('A', m);
	}
	@Test
	public void Aend()
	{
		char m=usloper_5.mark(100);
		assertEquals('A', m);
	}
	@Test (expected=IllegalArgumentException.class)
	public void morethan100()
	{
		char m=usloper_5.mark(101);
	}
	@Test (expected=IllegalArgumentException.class)
	public void lessthan0()
	{
		char m=usloper_5.mark(-10);
	}


}