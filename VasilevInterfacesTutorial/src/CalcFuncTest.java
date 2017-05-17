import static org.junit.Assert.*;

import org.junit.Test;

public class CalcFuncTest 
{

	@Test
	public void CalcTestPlus() 
	{
		double res=CPanel.Calculate(2, "+", 50);
		assertEquals(52.0, res,0);
	}
	@Test
	public void CalcTestMinus() 
	{
		double res=CPanel.Calculate(215, "-", 50);
		assertEquals(165.0, res,0);
	}
	@Test
	public void CalcTestDivide() 
	{
		double res=CPanel.Calculate(174, "/", 5);
		assertEquals(34.8, res,0);
	}
	@Test
	public void CalcTestMultiply() 
	{
		double res=CPanel.Calculate(43, "*", 7);
		assertEquals(301.0, res,0);
	}
	
}
