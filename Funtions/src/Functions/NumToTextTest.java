package Functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumToTextTest 
{

	@Test
	public void testNumToText_1() 
	{
		int num=1;
		String numT=NumToText.NumToText(num);
		System.out.println(numT);
		assertEquals("один", numT);
	}
	@Test
	public void testNumToText_2() 
	{
		int num=2;
		String numT=NumToText.NumToText(num);
		System.out.println(numT);
		assertEquals("два", numT);
	}
	@Test
	public void testNumToText_3() 
	{
		int num=3;
		String numT=NumToText.NumToText(num);
		System.out.println(numT);
		assertEquals("три", numT);
	}
	@Test
	public void testNumToText_4() 
	{
		int num=4;
		String numT=NumToText.NumToText(num);
		System.out.println(numT);
		assertEquals("четыре", numT);
	}
	@Test
	public void testNumToText_5() 
	{
		int num=5;
		String numT=NumToText.NumToText(num);
		System.out.println(numT);
		assertEquals("пять", numT);
	}
	@Test
	public void testNumToText_6() 
	{
		int num=6;
		String numT=NumToText.NumToText(num);
		System.out.println(numT);
		assertEquals("шесть", numT);
	}
	@Test
	public void testNumToText_7() 
	{
		int num=7;
		String numT=NumToText.NumToText(num);
		System.out.println(numT);
		assertEquals("семь", numT);
	}
	@Test
	public void testNumToText_8() 
	{
		int num=8;
		String numT=NumToText.NumToText(num);
		System.out.println(numT);
		assertEquals("восемь", numT);
	}
	@Test
	public void testNumToText_9() 
	{
		int num=9;
		String numT=NumToText.NumToText(num);
		System.out.println(numT);
		assertEquals("девять", numT);
	}
	@Test
	public void testNumToText_10() 
	{
		int num=10;
		String numT=NumToText.NumToText(num);
		System.out.println(numT);
		assertEquals("десять", numT);
	}
	@Test
	public void testNumToText_11() 
	{
		int num=11;
		String numT=NumToText.NumToText(num);
		System.out.println(numT);
		assertEquals("одинадцать", numT);
	}
	@Test
	public void testNumToText_12() 
	{
		int num=12;
		String numT=NumToText.NumToText(num);
		System.out.println(numT);
		assertEquals("двенадцать", numT);
	}
	@Test
	public void testNumToText_13() 
	{
		int num=13;
		String numT=NumToText.NumToText(num);
		System.out.println(numT);
		assertEquals("тринадцать", numT);
	}
	@Test
	public void testNumToText_14() 
	{
		int num=14;
		String numT=NumToText.NumToText(num);
		System.out.println(numT);
		assertEquals("четырнадцать", numT);
	}
	@Test
	public void testNumToText_15() 
	{
		int num=15;
		String numT=NumToText.NumToText(num);
		System.out.println(numT);
		assertEquals("пятнадцать", numT);
	}
	@Test
	public void testNumToText_16() 
	{
		int num=16;
		String numT=NumToText.NumToText(num);
		System.out.println(numT);
		assertEquals("шестнадцать", numT);
	}
	@Test
	public void testNumToText_17() 
	{
		int num=17;
		String numT=NumToText.NumToText(num);
		System.out.println(numT);
		assertEquals("семнадцать", numT);
	}
	@Test
	public void testNumToText_18() 
	{
		int num=18;
		String numT=NumToText.NumToText(num);
		System.out.println(numT);
		assertEquals("восемнадцать", numT);
	}
	@Test
	public void testNumToText_19() 
	{
		int num=19;
		String numT=NumToText.NumToText(num);
		System.out.println(numT);
		assertEquals("девятнадцать", numT);
	}
	@Test (expected=IllegalArgumentException.class)
	public void testNumToText_less1() 
	{
		int num=-12;
		NumToText.NumToText(num);
	}
	@Test (expected=IllegalArgumentException.class)
	public void testNumToText_more999() 
	{
		int num=1999;
		NumToText.NumToText(num);

	}
	@Test
	public void testNumToText_562() 
	{
		int num=562;
		String numT=NumToText.NumToText(num);
		System.out.println(numT);
		assertEquals("пятсот шестьдесят два", numT);
	}
	@Test
	public void testNumToText_198() 
	{
		int num=198;
		String numT=NumToText.NumToText(num);
		System.out.println(numT);
		assertEquals("сто девяносто восемь", numT);
	}
	@Test
	public void testNumToText_225() 
	{
		int num=225;
		String numT=NumToText.NumToText(num);
		System.out.println(numT);
		assertEquals("двести двадцать пять", numT);
	}
	@Test
	public void testNumToText_499() 
	{
		int num=499;
		String numT=NumToText.NumToText(num);
		System.out.println(numT);
		assertEquals("четыреста девяносто девять", numT);
	}
	@Test
	public void testNumToText_721() 
	{
		int num=721;
		String numT=NumToText.NumToText(num);
		System.out.println(numT);
		assertEquals("семсот двадцать один", numT);
	}
	@Test
	public void testNumToText_816() 
	{
		int num=816;
		String numT=NumToText.NumToText(num);
		System.out.println(numT);
		assertEquals("восемсот шестнадцать", numT);
	}
	@Test
	public void testNumToText_355() 
	{
		int num=355;
		String numT=NumToText.NumToText(num);
		System.out.println(numT);
		assertEquals("триста пятьдесят пять", numT);
	}
	@Test
	public void testNumToText_71() 
	{
		int num=71;
		String numT=NumToText.NumToText(num);
		System.out.println(numT);
		assertEquals("семдесят один", numT);
	}


}
