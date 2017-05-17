import static org.junit.Assert.*;

import org.junit.Test;

public class cycles_2Test {

	@Test
	public void prostoe()
	{
		boolean prostoe=cycles_2.proverka(2);
		System.out.println(prostoe);
		assertEquals(true, prostoe);
	}
	@Test
	public void neprostoe()
	{
		boolean prostoe=cycles_2.proverka(824);
		System.out.println(prostoe);
		assertEquals(false, prostoe);
	}
	@Test (expected=IllegalArgumentException.class)
	public void menshe0()
	{
		boolean prostoe=cycles_2.proverka(-35);
		System.out.println(prostoe);
	}
	@Test (expected=IllegalArgumentException.class)
	public void raven0()
	{
		boolean prostoe=cycles_2.proverka(0);
		System.out.println(prostoe);
	}

}
