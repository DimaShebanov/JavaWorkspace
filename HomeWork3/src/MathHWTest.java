import static org.junit.Assert.*;

import org.junit.Test;

public class MathHWTest 
{

	@Test
	public void testShootingDegreesSharpAngle() 
	{
		double DegrDist=MathHW.ShootingDegrees(45,72);
		System.out.println(DegrDist);
		assertEquals(40.77, DegrDist,2);
	}

	@Test
	public void testShootingDegreesMoreAngleHigherSpeed() 
	{
		double DegrDist=MathHW.ShootingDegrees(70,130);
		System.out.println(DegrDist);
		assertEquals(85.44, DegrDist,2);
	}

	@Test
	public void testShootingDegreesLessAngleGreaterSpeed() 
	{
		double DegrDist=MathHW.ShootingDegrees(25,572);
		System.out.println(DegrDist);
		assertEquals(1971.38, DegrDist,2);
	}

	@Test
	public void testShootingDegreesLittleAngleLittleSpeed() 
	{
		double DegrDist=MathHW.ShootingDegrees(5,7);
		System.out.println(DegrDist);
		assertEquals(0.06, DegrDist,2);
	}

	@Test (expected=IllegalArgumentException.class)
	public void testShootingDegreesMoreThan180Angle() 
	{
		MathHW.ShootingDegrees(180,7);
	}
	//=============================================================================================




	@Test
	public void testShootingRadiansNormalAll() 
	{
		double RadDist=MathHW.ShootingRadians(1,72);
		System.out.println(RadDist);
		assertEquals(37.07, RadDist,2);
	}
	@Test
	public void testShootingRadiansHighSpeedNormalAngle() 
	{
		double RadDist=MathHW.ShootingRadians(0.55,726);
		System.out.println(RadDist);
		assertEquals(3694.68, RadDist,2);
	}
	@Test
	public void testShootingRadiansTooBigAngleAndBigSpeed() 
	{
		double RadDist=MathHW.ShootingRadians(1.5,726);
		System.out.println(RadDist);
		assertEquals(585.04, RadDist,2);
	}
	@Test
	public void testShootingRadiansSmallAngleSmallSpeed() 
	{
		double RadDist=MathHW.ShootingRadians(0.15,17);
		System.out.println(RadDist);
		assertEquals(0.67, RadDist,2);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testShootingRadiansMoreThan180() 
	{
		MathHW.ShootingRadians(2,72);
	}

	//=============================================================================================




	@Test
	public void testAutoDistance_Normal() 
	{
		double AutoDist=MathHW.AutoDistance(55,101,300,2);
		System.out.println(AutoDist+"\n");
		assertEquals(612.0, AutoDist,2);
	}
	@Test
	public void testAutoDistance_V1Eq0() 
	{
		double AutoDist=MathHW.AutoDistance(0,101,300,2);
		System.out.println(AutoDist+"\n");
		assertEquals(502.0, AutoDist,2);
	}
	@Test
	public void testAutoDistance_V2Eq0() 
	{
		double AutoDist=MathHW.AutoDistance(55,0,300,2);
		System.out.println(AutoDist+"\n");
		assertEquals(410.0, AutoDist,2);
	}
	@Test
	public void testAutoDistance_DistanceEq0() 
	{
		double AutoDist=MathHW.AutoDistance(55,101,0,2);
		System.out.println(AutoDist+"\n");
		assertEquals(312.0, AutoDist,2);
	}
	@Test (expected=IllegalArgumentException.class)
	public void testAutoDistance_DistanceLess0() 
	{
		MathHW.AutoDistance(55,101,-250,2);
	}
	@Test (expected=IllegalArgumentException.class)
	public void testAutoDistance_TimeLess0() 
	{
		MathHW.AutoDistance(55,101,300,-1);
	}
	//=============================================================================================



	@Test
	public void testLongFunc_x1()
	{
		double res=MathHW.LongFunc(1);
		System.out.println(res+"\n");
		assertEquals(-3.56, res,2);
	}

	@Test
	public void testLongFunc_x3()
	{
		double res=MathHW.LongFunc(3);
		System.out.println(res+"\n");
		assertEquals(12.90, res,2);
	}

	@Test
	public void testLongFunc_x345()
	{
		double res=MathHW.LongFunc(345);
		System.out.println(res+"\n");
		assertEquals(4.47, res,2);
	}
	//=============================================================================================



	@Test
	public void testLETTERS() 
	{
		String LET=MathHW.LETTERS();
		System.out.println(LET);
		assertEquals("|A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z|", LET);
	}
	//=============================================================================================



	@Test
	public void testLetters() 
	{
		String let=MathHW.letters();
		System.out.println(let);	
		assertEquals("|a|b|c|d|e|f|g|h|i|j|k|l|m|n|o|p|q|r|s|t|u|v|w|x|y|z|",let);
	}
	//=============================================================================================




	@Test
	public void testRusLetters() 
	{
		String Rlet=MathHW.rusLetters();
		System.out.println(Rlet);
		assertEquals("|à|á|â|ã|ä|å|æ|ç|è|é|ê|ë|ì|í|î|ï|ð|ñ|ò|ó|ô|õ|ö|÷|ø|ù|ú|û|ü|ý|þ|ÿ|",Rlet);
	}
	//=============================================================================================





	@Test
	public void testNumbers() 
	{
		String nums=MathHW.numbers();
		System.out.println(nums);
		assertEquals("|0|1|2|3|4|5|6|7|8|9|", nums);
	}
	//=============================================================================================




	@Test
	public void testASCII() 
	{
		String ascii=MathHW.ASCII();
		System.out.println(ascii);
		String test="|";
		for(char i=32;i<=127;i++)
		{
			test+=i+"|";
		}
		assertEquals(test, ascii);
	}

}
