import static org.junit.Assert.*;

import org.junit.Test;

public class StringChangingTest 
{

	@Test
	public void ShortWordTest_OneSymb() 
	{
		int theshortest=StringChanging.TheShortestWord("djiwaj dwad,w wfrvtbvyf,tbtgadsrgf,  sfgbdfh, drybdfyh");
		System.out.println(theshortest);
		assertEquals(1, theshortest);
	}
	@Test
	public void ShortWordTest_TwoSymbs() 
	{
		int theshortest=StringChanging.TheShortestWord("djiwaj dwad,ww wfrvtbvyf,tbtgadsrgf,  sfgbdfh, drybdfyh");
		System.out.println(theshortest);
		assertEquals(2, theshortest);
	}
	@Test
	public void ShortWordTest_ThreeSymbs() 
	{
		int theshortest=StringChanging.TheShortestWord("djiwaj dwad,wdw wfrvtbvyf,tbtgadsrgf,  sfgbdfh, drybdfyh");
		System.out.println(theshortest);
		assertEquals(3, theshortest);
	}
	@Test
	public void ShortWordTest_TwoSameWords() 
	{
		int theshortest=StringChanging.TheShortestWord("djiwaj dwad,2w wfrvtbvyf,tbtgadsrgf, ww sfgbdfh, drybdfyh");
		System.out.println(theshortest);
		assertEquals(2, theshortest);
	}
	@Test
	public void ShortWordTest_AllWordsWithSameLenght() 
	{
		int theshortest=StringChanging.TheShortestWord("weee weea wess dkfi jdic , cece pssd");
		System.out.println(theshortest);
		assertEquals(4, theshortest);
	}

	//=========================================================================================================================================
	//=========================================================================================================================================
	//=========================================================================================================================================
	//=========================================================================================================================================

	@Test
	public void DollarsTest_2Words() 
	{
		String[] beforeDoll={"deadedg","rsvsdsss0","vosjr","rvdsinovoidr","uuuny","crrrrsrb","efsddd"};
		String dollars = StringChanging.SymbsToDoll(beforeDoll,5);
		System.out.println(dollars);
		assertEquals("deadedg rsvsdsss0 vo$$$ rvdsinovoidr uu$$$ crrrrsrb efsddd", dollars);
	}
	@Test
	public void DollarsTest_5Words() 
	{
		String[] beforeDoll={"deade","rsvsd","vosjr","rvdsinovoidr","uuuny","crrri","efsddd"};
		String dollars = StringChanging.SymbsToDoll(beforeDoll,5);
		System.out.println(dollars);
		assertEquals("de$$$ rs$$$ vo$$$ rvdsinovoidr uu$$$ cr$$$ efsddd", dollars);
	}
	@Test
	public void DollarsTest_NoWords() 
	{
		String[] beforeDoll={"deadedg","rsvsdsss0","vosjr12","rvdsinovoidr","uuuny11","crrrrsrb","efsddd"};
		String dollars = StringChanging.SymbsToDoll(beforeDoll,5);
		System.out.println(dollars);
		assertEquals("deadedg rsvsdsss0 vosjr12 rvdsinovoidr uuuny11 crrrrsrb efsddd", dollars);
	}
	@Test (expected=IllegalArgumentException.class)
	public void DollarsTest_NeededLenghtLess3() 
	{
		String[] beforeDoll={"deadedg","rsvsdsss0","vosjr","rvdsinovoidr","uuuny","crrrrsrb","efsddd"};
		StringChanging.SymbsToDoll(beforeDoll,2);
		System.out.println(beforeDoll);
	}

	@Test
	public void DollarsTest_AllWords() 
	{
		String[] beforeDoll={"deadety","rsvsdty","vosjrfy","rvds88i","uuunyii","crrrikk","efsddkk"};
		String dollars = StringChanging.SymbsToDoll(beforeDoll,7);
		System.out.println(dollars);
		assertEquals("dead$$$ rsvs$$$ vosj$$$ rvds$$$ uuun$$$ crrr$$$ efsd$$$", dollars);
	}

	//=========================================================================================================================================
	//=========================================================================================================================================
	//=========================================================================================================================================
	//=========================================================================================================================================


	@Test
	public void SpacesTestNoSpacesInString() 
	{
		String before = "edsf,evesv,sdfdgr,asefvsdv,svrdrgh,SRGsrg";
		String after = StringChanging.Spaces(before);
		String expected = "edsf, evesv, sdfdgr, asefvsdv, svrdrgh, SRGsrg";
		System.out.println(after);
		assertEquals(expected, after);
	}
	@Test
	public void SpacesTestOneSpace() 
	{
		String before = "edsf, evesv,sdfdgr,asefvsdv,svrdrgh,SRGsrg";
		String after = StringChanging.Spaces(before);
		String expected = "edsf, evesv, sdfdgr, asefvsdv, svrdrgh, SRGsrg";
		System.out.println(after);
		assertEquals(expected, after);
	}
	@Test
	public void SpacesTestTwoSpacesInTheEndAndInTheBeggining() 
	{
		String before = "edsf, evesv,sdfdgr,asefvsdv,svrdrgh, SRGsrg";
		String after = StringChanging.Spaces(before);
		String expected = "edsf, evesv, sdfdgr, asefvsdv, svrdrgh, SRGsrg";
		System.out.println(after);
		assertEquals(expected, after);
	}
	@Test
	public void SpacesTestAllSpaces() 
	{
		String before = "edsf, evesv, sdfdgr, asefvsdv, svrdrgh, SRGsrg";
		String after = StringChanging.Spaces(before);
		String expected = "edsf, evesv, sdfdgr, asefvsdv, svrdrgh, SRGsrg";
		System.out.println(after);
		assertEquals(expected, after);
	}
	@Test
	public void SpacesTestDifferentSymbsBeforeSpaces() 
	{
		String before = "edsf, evesv.sdfdgr! asefvsdv\"svrdrgh!!SRGsrg";
		String after = StringChanging.Spaces(before);
		String expected = "edsf, evesv. sdfdgr! asefvsdv\" svrdrgh!! SRGsrg";
		System.out.println(after);
		assertEquals(expected, after);
	}

	//=========================================================================================================================================
	//=========================================================================================================================================
	//=========================================================================================================================================
	//=========================================================================================================================================

	@Test
	public void UniqueSymbolsTest_AlotOfSymbs() 
	{
		String bef = "dae wdewesc ecsr rrrfvr rSFDFvbk btib btirn v121e!#R$lbt";
		String aft = StringChanging.UniqueSymbs(bef);
		assertEquals("daewscrfvSFDbktin12!#R$l", aft);
	}
	@Test
	public void UniqueSymbolsTest_AllSymbsAreSame() 
	{
		String bef = "dddddddddddddddddddddddddddddd";
		String aft = StringChanging.UniqueSymbs(bef);
		assertEquals("d", aft);
	}
	@Test
	public void UniqueSymbolsTest_NoText() 
	{
		String bef = "";
		String aft = StringChanging.UniqueSymbs(bef);
		assertEquals("", aft);
	}
	@Test (expected=IllegalArgumentException.class)
	public void UniqueSymbolsTest_Null() 
	{
		String bef = null;
		StringChanging.UniqueSymbs(bef);
	}

	

	//=========================================================================================================================================
	//=========================================================================================================================================
	//=========================================================================================================================================
	//========================================================================================================================================= 
	
	
	@Test
	public void CountOfWords_SixWords() 
	{
		String words="oubdeac srgvdtr!rvdvoij  vpsrj! voirdvd esfsevts";
		int countOfWords=StringChanging.Words(words);
		System.out.println(countOfWords);
		assertEquals(6, countOfWords);
	}
	@Test
	public void CountOfWords_SixWords_WithSpaceInTheEnd() 
	{
		String words="oubdeac srgvdtr!rvdvoij  vpsrj! voirdvd esfsevts   ";
		int countOfWords=StringChanging.Words(words);
		System.out.println(countOfWords);
		assertEquals(6, countOfWords);
	}
	@Test
	public void CountOfWords_OneLongWord() 
	{
		String words="vfdbstrfhndgyfndcyg";
		int countOfWords=StringChanging.Words(words);
		System.out.println(countOfWords);
		assertEquals(1, countOfWords);
	}
	@Test
	public void CountOfWords_NoWords() 
	{
		String words=" !@:;\"\'...,";
		int countOfWords=StringChanging.Words(words);
		System.out.println(countOfWords);
		assertEquals(0, countOfWords);
	}
	@Test
	public void CountOfWords_Nothing() 
	{
		String words="";
		int countOfWords=StringChanging.Words(words);
		System.out.println(countOfWords);
		assertEquals(0, countOfWords);
	}

	

	//=========================================================================================================================================
	//=========================================================================================================================================
	//=========================================================================================================================================
	//=========================================================================================================================================

	@Test
	public void Deleting_DeleteFromStart() 
	{
		String beforedelete = "cosnirs verpojvdr vdro vsrddd sdv;vrs";
		String afterdelete = StringChanging.Delete(beforedelete,0,5);
		System.out.println(afterdelete);
		assertEquals("rs verpojvdr vdro vsrddd sdv;vrs", afterdelete);
	}
	@Test
	public void Deleting_DeleteFromMiddle() 
	{
		String beforedelete = "cosnirs verpojvdr vdro vsrddd sdv;vrs";
		String afterdelete = StringChanging.Delete(beforedelete,10,10);
		System.out.println(afterdelete);
		assertEquals("cosnirs vero vsrddd sdv;vrs", afterdelete);
	}
	@Test
	public void Deleting_DeleteFromTheEnd() 
	{
		String beforedelete = "cosnirs verpojvdr vdro vsrddd sdv;vrs";
		String afterdelete = StringChanging.Delete(beforedelete,30,7);
		System.out.println(afterdelete);
		assertEquals("cosnirs verpojvdr vdro vsrddd ", afterdelete);
	}
	@Test (expected = IllegalArgumentException.class)
	public void Deleting_OutOfBounds() 
	{
		String beforedelete = "cosnirs verpojvdr vdro vsrddd sdv;vrs";
		StringChanging.Delete(beforedelete,35,5);
	}
	@Test
	public void Deleting_NullLenghth() 
	{
		String beforedelete = "cosnirs verpojvdr vdro vsrddd sdv;vrs";
		String afterdelete = StringChanging.Delete(beforedelete,10,0);
		System.out.println(afterdelete);
		assertEquals("cosnirs verpojvdr vdro vsrddd sdv;vrs", afterdelete);
	}

	//=========================================================================================================================================
	//=========================================================================================================================================
	//=========================================================================================================================================
	//=========================================================================================================================================
	
	
	@Test
	public void DeleteLastWord_NormalSize() 
	{
		String withlastword = "lncselonsr drgvpojd drvft trvdtvio1 svdr";
		String withoutlastword = StringChanging.DeleteLastWord(withlastword);
		System.out.println(withoutlastword);
		assertEquals("lncselonsr drgvpojd drvft trvdtvio1", withoutlastword);
	}

	@Test
	public void DeleteLastWord_NormalSize_SpacesOnBothSides() 
	{
		String withlastword = "  lncselonsr drgvpojd drvft trvdtvio1 svdr      ";
		String withoutlastword = StringChanging.DeleteLastWord(withlastword);
		System.out.println(withoutlastword);
		assertEquals("lncselonsr drgvpojd drvft trvdtvio1", withoutlastword);
	}
	@Test
	public void DeleteLastWord_OneWord() 
	{
		String withlastword = "lncselonsr";
		String withoutlastword = StringChanging.DeleteLastWord(withlastword);
		System.out.println(withoutlastword);
		assertEquals("lncselonsr", withoutlastword);
	}
	@Test
	public void DeleteLastWord_Nothing() 
	{
		String withlastword = "";
		String withoutlastword = StringChanging.DeleteLastWord(withlastword);
		System.out.println(withoutlastword);
		assertEquals("", withoutlastword);
	}
	@Test
	public void DeleteLastWord_WithSpace() 
	{
		String withlastword = "lncselonsr ";
		String withoutlastword = StringChanging.DeleteLastWord(withlastword);
		System.out.println(withoutlastword);
		assertEquals("lncselonsr", withoutlastword);
	}
	








}
