package Functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class FunctionsNumToStringDaysTest 
{

	@Test
	public void DayOfWeekTest_Monday() 
	{
		int num=1;
		String day=FunctionsNumToStringDays.DayOfWeek(num);
		System.out.println(day);
		assertEquals("Monday", day);
	}
	@Test
	public void DayOfWeekTest_Tuesday() 
	{
		int num=2;
		String day=FunctionsNumToStringDays.DayOfWeek(num);
		System.out.println(day);
		assertEquals("Tuesday", day);
	}
	@Test
	public void DayOfWeekTest_Wednesday() 
	{
		int num=3;
		String day=FunctionsNumToStringDays.DayOfWeek(num);
		System.out.println(day);
		assertEquals("Wednesday", day);
	}
	@Test
	public void DayOfWeekTest_Thursday() 
	{
		int num=4;
		String day=FunctionsNumToStringDays.DayOfWeek(num);
		System.out.println(day);
		assertEquals("Thursday", day);
	}
	@Test
	public void DayOfWeekTest_Friday() 
	{
		int num=5;
		String day=FunctionsNumToStringDays.DayOfWeek(num);
		System.out.println(day);
		assertEquals("Friday", day);
	}
	@Test
	public void DayOfWeekTest_Saturday() 
	{
		int num=6;
		String day=FunctionsNumToStringDays.DayOfWeek(num);
		System.out.println(day);
		assertEquals("Saturday", day);
	}
	@Test
	public void DayOfWeekTest_Sunday() 
	{
		int num=7;
		String day=FunctionsNumToStringDays.DayOfWeek(num);
		System.out.println(day);
		assertEquals("Sunday", day);
	}
	@Test (expected=IllegalArgumentException.class)
	public void DayOfWeekTest_LessThan1() 
	{
		int num=0;
		String day=FunctionsNumToStringDays.DayOfWeek(num);
	}
	@Test (expected=IllegalArgumentException.class)
	public void DayOfWeekTest_MoreThan7() 
	{
		int num=8;
		String day=FunctionsNumToStringDays.DayOfWeek(num);
	}

}
