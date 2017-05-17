import static org.junit.Assert.*;

import org.junit.Test;

public class usloper1Test {

	@Test
	public void chetnoe() 
	{
		int s=usloper1.usl(10,24);
		System.out.println(s);
		assertEquals(240, s);
	}
	
	@Test
	public void nechetnoe() 
	{
		int s=usloper1.usl(11,24);
		System.out.println(s);
		assertEquals(35, s);
	}

}
