import static org.junit.Assert.*;

import org.junit.Test;

public class cycles_4Test {

	@Test
	public void fact3() {
		long sum=cycles_4.fact(3);
		System.out.println(sum);
		assertEquals(6, sum);
	}
	@Test
	public void fact12() {
		long sum=cycles_4.fact(12);
		System.out.println(sum);
		assertEquals(479001600, sum);
	}
	@Test (expected=IllegalArgumentException.class)
	public void fact0() {
		long sum=cycles_4.fact(0);
		System.out.println(sum);
	}
}
