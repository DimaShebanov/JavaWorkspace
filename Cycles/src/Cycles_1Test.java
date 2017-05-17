import static org.junit.Assert.*;

import org.junit.Test;

public class Cycles_1Test 
{

	@Test
	public void chetnie_chisla() 
	{
		int sum=Cycles_1.chetniesum();
		int count=Cycles_1.chetniecount();
		System.out.println(sum+"\n"+count);
		assertEquals(2450, sum);
		assertEquals(49, count);
	}
}
