package Functions;

import static org.junit.Assert.*;

import org.junit.Test;

public class FunctionsTextToNumTest {

	@Test
	public void TextToNumTest_����() 
	{
		String text="����";
		int num=FunctionsTextToNum.TextToNum(text);
		System.out.println(num);
		assertEquals(1,num);
	}
	@Test
	public void TextToNumTest_����������() 
	{
		String text="����������";
		int num=FunctionsTextToNum.TextToNum(text);
		System.out.println(num);
		assertEquals(13,num);
	}
//	@Test
//	public void TextToNumTest_() 
//	{
//		String text="������������";
//		int num=FunctionsTextToNum.TextToNum(text);
//		System.out.println(num);
//		assertEquals(14,num);
//	}
//	@Test
//	public void TextToNumTest_() 
//	{
//		String text="������������";
//		int num=FunctionsTextToNum.TextToNum(text);
//		System.out.println(num);
//		assertEquals(14,num);
//	}
//	@Test
//	public void TextToNumTest_() 
//	{
//		String text="������������";
//		int num=FunctionsTextToNum.TextToNum(text);
//		System.out.println(num);
//		assertEquals(14,num);
//	}
//	@Test
//	public void TextToNumTest_() 
//	{
//		String text="������������";
//		int num=FunctionsTextToNum.TextToNum(text);
//		System.out.println(num);
//		assertEquals(14,num);
//	}
//	@Test
//	public void TextToNumTest_() 
//	{
//		String text="������������";
//		int num=FunctionsTextToNum.TextToNum(text);
//		System.out.println(num);
//		assertEquals(14,num);
//	}
//	@Test
//	public void TextToNumTest_() 
//	{
//		String text="������������";
//		int num=FunctionsTextToNum.TextToNum(text);
//		System.out.println(num);
//		assertEquals(14,num);
//	}
//	@Test
//	public void TextToNumTest_() 
//	{
//		String text="������������";
//		int num=FunctionsTextToNum.TextToNum(text);
//		System.out.println(num);
//		assertEquals(14,num);
//	}
//	@Test
//	public void TextToNumTest_() 
//	{
//		String text="������������";
//		int num=FunctionsTextToNum.TextToNum(text);
//		System.out.println(num);
//		assertEquals(14,num);
//	}
//	@Test
//	public void TextToNumTest_() 
//	{
//		String text="������������";
//		int num=FunctionsTextToNum.TextToNum(text);
//		System.out.println(num);
//		assertEquals(14,num);
//	}
//	@Test
//	public void TextToNumTest_() 
//	{
//		String text="������������";
//		int num=FunctionsTextToNum.TextToNum(text);
//		System.out.println(num);
//		assertEquals(14,num);
//	}
//	@Test
//	public void TextToNumTest_() 
//	{
//		String text="������������";
//		int num=FunctionsTextToNum.TextToNum(text);
//		System.out.println(num);
//		assertEquals(14,num);
//	}
//	@Test
//	public void TextToNumTest_() 
//	{
//		String text="������������";
//		int num=FunctionsTextToNum.TextToNum(text);
//		System.out.println(num);
//		assertEquals(14,num);
//	}

}
