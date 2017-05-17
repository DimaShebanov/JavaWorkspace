package Functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class DekartPointsTest 
{

	@Test
	public void DekartLenghtTest_vseplus() 
	{
		int len=(int)DekartPoints.DekartLenght(5,5,15,15);	
		System.out.println(len);
		assertEquals(14, len);
	}
	@Test
	public void DekartLenghtTest_bx0() 
	{
		int len=(int)DekartPoints.DekartLenght(5,5,0,15);	
		System.out.println(len);
		assertEquals(11, len);
	}
	@Test
	public void DekartLenghtTest_by0() 
	{
		int len=(int)DekartPoints.DekartLenght(5,5,15,0);	
		System.out.println(len);
		assertEquals(11, len);
	}
	@Test
	public void DekartLenghtTest_b0() 
	{
		int len=(int)DekartPoints.DekartLenght(5,5,0,0);	
		System.out.println(len);
		assertEquals(7, len);
	}
	@Test
	public void DekartLenghtTest_ax0() 
	{
		int len=(int)DekartPoints.DekartLenght(0,5,15,15);	
		System.out.println(len);
		assertEquals(18, len);
	}
	@Test
	public void DekartLenghtTest_ay0() 
	{
		int len=(int)DekartPoints.DekartLenght(5,0,15,15);	
		System.out.println(len);
		assertEquals(18, len);
	}
	@Test
	public void DekartLenghtTest_bminus() 
	{
		int len=(int)DekartPoints.DekartLenght(5,5,-15,-15);	
		System.out.println(len);
		assertEquals(28, len);
	}
	@Test
	public void DekartLenghtTest_aminus() 
	{
		int len=(int)DekartPoints.DekartLenght(-5,-5,15,15);	
		System.out.println(len);
		assertEquals(28, len);
	}
	@Test
	public void DekartLenghtTest_axminus() 
	{
		int len=(int)DekartPoints.DekartLenght(-5,5,15,15);	
		System.out.println(len);
		assertEquals(22, len);
	}
	@Test
	public void DekartLenghtTest_ayminus() 
	{
		int len=(int)DekartPoints.DekartLenght(5,-5,15,15);	
		System.out.println(len);
		assertEquals(22, len);
	}
	@Test
	public void DekartLenghtTest_bminus_a0() 
	{
		int len=(int)DekartPoints.DekartLenght(0,0,-15,-15);	
		System.out.println(len);
		assertEquals(21, len);
	}
	@Test
	public void DekartLenghtTest_aminus_b0() 
	{
		int len=(int)DekartPoints.DekartLenght(5,5,0,0);	
		System.out.println(len);
		assertEquals(7, len);
	}
	@Test
	public void DekartLenghtTest_vse0() 
	{
		int len=(int)DekartPoints.DekartLenght(0,0,0,0);	
		System.out.println(len);
		assertEquals(0, len);
	}

}
