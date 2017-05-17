package tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestsForBalls
{

	@Test
	public void testy0()
	{
		SPanel pan = new SPanel(600, 600);

		BaloonPan bal1 = new BaloonPan(30, 70, 30, pan, 5, 0);
		BaloonPan bal2 = new BaloonPan(100, 70, 30, pan, -5, 0);
		pan.add(bal1);
		pan.add(bal2);

		pan.baloons.add(bal1);
		pan.baloons.add(bal2);


		System.out.println("bal1?0:" + bal1.x);
		System.out.println("bal2?0:" + bal2.x + "\n");
		
		for (int i = 0; i <= 7; i++)
		{
			bal1.move();
			bal2.move();
			System.out.println(i + " move");
			System.out.println("bal1:" + bal1.x);
			System.out.println("bal2:" + bal2.x + "\n");
		}
		assertEquals(40, bal1.x);
		assertEquals(90, bal2.x);
		
	}
	
	@Test
	public void testx0()
	{
		SPanel pan = new SPanel(600, 600);

		BaloonPan bal1 = new BaloonPan(70, 30, 30, pan, 0, 5);
		BaloonPan bal2 = new BaloonPan(70, 100, 30, pan, 0, -5);
		pan.add(bal1);
		pan.add(bal2);

		pan.baloons.add(bal1);
		pan.baloons.add(bal2);


		System.out.println("bal1?0:" + bal1.y);
		System.out.println("bal2?0:" + bal2.y + "\n");
		
		for (int i = 0; i <= 7; i++)
		{
			bal1.move();
			bal2.move();
			System.out.println(i + " move");
			System.out.println("bal1:" + bal1.y);
			System.out.println("bal2:" + bal2.y + "\n");
		}
		assertEquals(40, bal1.y);
		assertEquals(90, bal2.y);
		
	}
	
	@Test
	public void test()
	{
		SPanel pan = new SPanel(600, 600);

		BaloonPan bal1 = new BaloonPan(70, 30, 30, pan, 0, 5);
		BaloonPan bal2 = new BaloonPan(70, 100, 30, pan, 0, -5);
		pan.add(bal1);
		pan.add(bal2);

		pan.baloons.add(bal1);
		pan.baloons.add(bal2);


		System.out.println("bal1?0:" + bal1.y);
		System.out.println("bal2?0:" + bal2.y + "\n");
		
		for (int i = 0; i <= 7; i++)
		{
			bal1.move();
			bal2.move();
			System.out.println(i + " move");
			System.out.println("bal1:" + bal1.y);
			System.out.println("bal2:" + bal2.y + "\n");
		}
		assertEquals(40, bal1.y);
		assertEquals(90, bal2.y);
		
	}

}
