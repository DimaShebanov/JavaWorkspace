import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class EListTestNG 
{
	@DataProvider
	public static Object[] data() 
	{
      Object[][] data = new Object[][] { {new AList0()} , {new AList1()} , {new AList2() }};
      return data;
    }
	
	@Test (dataProvider = "data")
	public void testInit_zerolen(EList obj) 
	{
		int[] rr = new int[0];
		obj.init(rr);
		assertEquals(0, obj.size());
	}
	
	@Test (dataProvider = "data")
	public void testInit_len1(EList obj) 
	{
		
		int[] rr = {1};
		obj.init(rr);
		assertEquals(1, obj.size());
	}
	
	@Test (dataProvider = "data")
	public void testInit_len2(EList obj) 
	{
		
		int[] rr = {1,2};
		obj.init(rr);
		assertEquals(2, obj.size());
	}
	
	@Test (dataProvider = "data")
	public void testInit_len3(EList obj) 
	{
		
		int[] rr = {1,2,4};
		obj.init(rr);
		assertEquals(3, obj.size());
	}
	
	@Test (dataProvider = "data")
	public void testInit_many(EList obj) 
	{
		
		int[] rr = {1,2,4,2,3,4,5,6};
		obj.init(rr);
		assertEquals(8, obj.size());
	}
	
	//============================================================================================
	@Test (dataProvider = "data")
	public void testClear_zerolen(EList obj) 
	{
		
		obj.clear();
		assertEquals(0, obj.size());
	}
	
	@Test (dataProvider = "data")
	public void testClear_len1(EList obj) 
	{
		
		int[] rr = {2};
		obj.init(rr);
		obj.clear();
		assertEquals(0, obj.size());
	}
	
	@Test (dataProvider = "data")
	public void testClear_len2(EList obj) 
	{
		
		int[] rr = {2,2};
		obj.init(rr);
		obj.clear();
		assertEquals(0, obj.size());
	}
	
	@Test (dataProvider = "data")
	public void testClear_many(EList obj) 
	{
		
		int[] rr = {2,2,3,4,5,75,63,1};
		obj.init(rr);
		obj.clear();
		assertEquals(0, obj.size());
	}


	
	//============================================================================================

	@Test (dataProvider = "data")
	public void testSize_zero(EList obj) 
	{
		
		int[] rr = new int[0];
		obj.init(rr);
		int size = obj.size();
		assertEquals(0, size);
	}
	
	@Test (dataProvider = "data")
	public void testSize_1(EList obj)
	{
		
		int[] rr = {128};
		obj.init(rr);
		int size = obj.size();
		assertEquals(1, size);
	}
	
	@Test (dataProvider = "data")
	public void testSize_2(EList obj)
	{
		
		int[] rr = new int[2];
		obj.init(rr);
		int size = obj.size();
		assertEquals(2, size);
	}
	
	@Test (dataProvider = "data")
	public void testSize_3(EList obj)
	{
		
		int[] rr = new int[3];
		obj.init(rr);
		int size = obj.size();
		assertEquals(3, size);
	}
	
	@Test (dataProvider = "data")
	public void testSize_many(EList obj)
	{
		
		int[] rr = new int[10];
		obj.init(rr);
		int size = obj.size();
		assertEquals(10, size);
	}
	
	
	
	
	//============================================================================================

	@Test (dataProvider = "data")
	public void testToArray_zero(EList obj)
	{
		
		int[] rr = {};
		obj.init(rr);
		int[] res = {};
		assertArrayEquals(res, obj.toArray());
	}
	
	@Test (dataProvider = "data")
	public void testToArray_1(EList obj)
	{
		
		int[] rr = {5};
		obj.init(rr);
		int[] res = {5};
		assertArrayEquals(res, obj.toArray());
	}
	
	@Test (dataProvider = "data")
	public void testToArray_2(EList obj)
	{
		
		int[] rr = {1,3};
		obj.init(rr);
		int[] res = {1,3};
		assertArrayEquals(res, obj.toArray());
	}
	
	@Test (dataProvider = "data")
	public void testToArray_3(EList obj)
	{
		
		int[] rr = {1,2,5};
		obj.init(rr);
		int[] res = {1,2,5};
		assertArrayEquals(res, obj.toArray());
	}
	
	@Test (dataProvider = "data")
	public void testToArray_many(EList obj)
	{
		
		int[] rr = {1,322,56,3425,65,566};
		obj.init(rr);
		int[] res = {1,322,56,3425,65,566};
		assertArrayEquals(res, obj.toArray());
	}
	
	
	//============================================================================================

	@Test (dataProvider = "data")
	public void testToString_many(EList obj)
	{
		
		int[] rr = {1,2,3,4,5,4,56};
		obj.init(rr);
		String res = "{1, 2, 3, 4, 5, 4, 56}";
		assertEquals(res, obj.toString());
	}
	
	@Test (dataProvider = "data")
	public void testToString_zero(EList obj)
	{
		
		int[] rr = {};
		obj.init(rr);
		String res = "Nothing here!";
		assertEquals(res, obj.toString());
	}
	
	@Test (dataProvider = "data")
	public void testToString_1(EList obj)
	{
		
		int[] rr = {56};
		obj.init(rr);
		String res = "{56}";
		assertEquals(res, obj.toString());
	}
	
	@Test (dataProvider = "data")
	public void testToString_2(EList obj)
	{
		
		int[] rr = {1,356};
		obj.init(rr);
		String res = "{1, 356}";
		assertEquals(res, obj.toString());
	}
	
	@Test (dataProvider = "data")
	public void testToString_3(EList obj)
	{
		
		int[] rr = {1,322,56};
		obj.init(rr);
		String res = "{1, 322, 56}";
		assertEquals(res, obj.toString());
	}
	
	
	//============================================================================================

	@Test (dataProvider = "data")
	public void testAddStart_to3(EList obj)
	{
		
		int[] rr = {1,322,56};
		obj.init(rr);
		obj.addStart(34);
		int[] res = {34,1,322,56};
		assertArrayEquals(res, obj.toArray());
	}
	

	@Test (dataProvider = "data")
	public void testAddStart_to2(EList obj)
	{
		
		int[] rr = {1,322};
		obj.init(rr);
		obj.addStart(34);
		int[] res = {34,1,322};
		assertArrayEquals(res, obj.toArray());
	}
	

	@Test (dataProvider = "data")
	public void testAddStart_to1(EList obj)
	{
		
		int[] rr = {1};
		obj.init(rr);
		obj.addStart(34);
		int[] res = {34,1};
		assertArrayEquals(res, obj.toArray());
	}
	

	@Test (dataProvider = "data")
	public void testAddStart_to0(EList obj)
	{
		
		int[] rr = {};
		obj.init(rr);
		obj.addStart(587);
		int[] res = {587};
		assertArrayEquals(res, obj.toArray());
	}
	

	@Test (dataProvider = "data")
	public void testAddStart_toMany(EList obj)
	{
		
		int[] rr = {1,322,56,3425,65,566};
		obj.init(rr);
		int[] res = {34,1,322,56,3425,65,566};
		obj.addStart(34);
		assertArrayEquals(res, obj.toArray());
	}
	
	
	//============================================================================================

	@Test (dataProvider = "data")
	public void testAddEnd_tomany(EList obj)
	{
		
		int[] rr = {1,322,56,3425,65,566};
		obj.init(rr);
		int[] res = {1,322,56,3425,65,566,34};
		obj.addEnd(34);
		assertArrayEquals(res, obj.toArray());
	}
	
	@Test (dataProvider = "data")
	public void testAddEnd_to0(EList obj)
	{
		
		int[] rr = {};
		obj.init(rr);
		int[] res = {3487};
		obj.addEnd(3487);
		assertArrayEquals(res, obj.toArray());
	}
	
	@Test (dataProvider = "data")
	public void testAddEnd_to1(EList obj)
	{
		
		int[] rr = {1};
		obj.init(rr);
		int[] res = {1,345};
		obj.addEnd(345);
		assertArrayEquals(res, obj.toArray());
	}
	
	@Test (dataProvider = "data")
	public void testAddEnd_to2(EList obj)
	{
		
		int[] rr = {1,322};
		obj.init(rr);
		int[] res = {1,322,34};
		obj.addEnd(34);
		assertArrayEquals(res, obj.toArray());
	}
	
	@Test (dataProvider = "data")
	public void testAddEnd_to3(EList obj)
	{
		
		int[] rr = {1,322,56};
		obj.init(rr);
		int[] res = {1,322,56,34};
		obj.addEnd(34);
		assertArrayEquals(res, obj.toArray());
	}
	
	
	//============================================================================================

	@Test (dataProvider = "data", expectedExceptions = IllegalArgumentException.class)
	public void testDelStart_from0(EList obj)
	{
		
		int[] rr = {};
		obj.init(rr);
		obj.delStart();
	}
	
	@Test (dataProvider = "data")
	public void testDelStart_from1(EList obj)
	{
		
		int[] rr = {1};
		obj.init(rr);
		int[] res = {};
		int del=obj.delStart();
		assertEquals(1, del);
		assertArrayEquals(res, obj.toArray());
	}
	
	@Test (dataProvider = "data")
	public void testDelStart_from2(EList obj)
	{
		
		int[] rr = {1223,322};
		obj.init(rr);
		int[] res = {322};
		int del=obj.delStart();
		assertEquals(1223, del);
		assertArrayEquals(res, obj.toArray());
	}
	
	@Test (dataProvider = "data")
	public void testDelStart_from3(EList obj)
	{
		
		int[] rr = {112,322,56};
		obj.init(rr);
		int[] res = {322,56};
		int del=obj.delStart();
		assertEquals(112, del);
		assertArrayEquals(res, obj.toArray());
	}
	
	@Test (dataProvider = "data")
	public void testDelStart_fromMany(EList obj)
	{
		
		int[] rr = {12,322,56,324,66,44};
		obj.init(rr);
		int[] res = {322,56,324,66,44};
		int del=obj.delStart();
		assertEquals(12, del);
		assertArrayEquals(res, obj.toArray());
	}
	
	
	//============================================================================================

	@Test (dataProvider = "data")
	public void testDelEnd_from1(EList obj)
	{
		
		int[] rr = {1};
		obj.init(rr);
		int[] res = {};
		int del = obj.delEnd();
		assertEquals( 1,del);
		assertArrayEquals(res, obj.toArray());		
	}
	
	@Test (dataProvider = "data", expectedExceptions = IllegalArgumentException.class)
	public void testDelEnd_from0(EList obj)
	{
		
		int[] rr = {};
		obj.init(rr);
		obj.delEnd();
	}
	
	@Test (dataProvider = "data")
	public void testDelEnd_from2(EList obj)
	{
		
		int[] rr = {1,56};
		obj.init(rr);
		int[] res = {1};
		int del = obj.delEnd();
		assertEquals(56,del);
		assertArrayEquals(res, obj.toArray());		
	}
	
	@Test (dataProvider = "data")
	public void testDelEnd_from3(EList obj)
	{
		
		int[] rr = {1,322,56};
		obj.init(rr);
		int[] res = {1,322};
		int del = obj.delEnd();
		assertEquals( 56,del);
		assertArrayEquals(res, obj.toArray());		
	}
	
	@Test (dataProvider = "data")
	public void testDelEnd_fromMany(EList obj)
	{
		
		int[] rr = {1,322,56,1234,55,786,43};
		obj.init(rr);
		int[] res = {1,322,56,1234,55,786};
		int del = obj.delEnd();
		assertEquals(43,del);
		assertArrayEquals(res, obj.toArray());		
	}
	
	
	//============================================================================================

	@Test (dataProvider = "data")
	public void testGet_start(EList obj)
	{
		
		int[] rr = {112,322,56,1234,55,786,43};
		obj.init(rr);
		int get = obj.get(0);
		assertEquals(112,get);
	}
	
	@Test (dataProvider = "data")
	public void testGet_end(EList obj)
	{
		
		int[] rr = {1,322,56,1234,55,786,43};
		obj.init(rr);
		int get = obj.get(6);
		assertEquals(43,get);
	}
	
	@Test (dataProvider = "data")
	public void testGet_middle(EList obj)
	{
		
		int[] rr = {1,322,56,1234,55,786,43};
		obj.init(rr);
		int get = obj.get(3);
		assertEquals(1234,get);
	}
	
	@Test (dataProvider = "data", expectedExceptions = IllegalArgumentException.class)
	public void testGet_moreThanLeng(EList obj)
	{
		
		int[] rr = {1,322,56,1234,55,786,43};
		obj.init(rr);
		obj.get(7);

	}
	
	@Test (dataProvider = "data")
	public void testGet_zero(EList obj)
	{
		
		int[] rr = {1,322,56,1234,55,786,43};
		obj.init(rr);
		int res = obj.get(0);
		assertEquals(1, res);
	}
	
	@Test (dataProvider = "data", expectedExceptions = IllegalArgumentException.class)
	public void testGet_LessThanleng(EList obj)
	{
		
		int[] rr = {1,322,56,1234,55,786,43};
		obj.init(rr);
		obj.get(-1);
	}
	
	@Test (dataProvider = "data")
	public void testGet_from1(EList obj)
	{
		
		int[] rr = {1324};
		obj.init(rr);
		int get = obj.get(0);
		assertEquals(1324,get);
	}
	
	@Test (dataProvider = "data", expectedExceptions = IllegalArgumentException.class)
	public void testGet_from0(EList obj)
	{
		
		int[] rr = {};
		obj.init(rr);
		obj.get(0);
	}
	
	@Test (dataProvider = "data")
	public void testGet_from2(EList obj)
	{
		
		int[] rr = {1324,213};
		obj.init(rr);
		int get = obj.get(1);
		assertEquals(213,get);
	}
	
	
	//============================================================================================

	@Test (dataProvider = "data")
	public void testMinPos_many(EList obj)
	{
		
		int[] rr = {1324,213,432,1,2};
		obj.init(rr);
		int minPos = obj.minPos();
		assertEquals(3,minPos);
	}
	
	@Test (dataProvider = "data", expectedExceptions = IllegalArgumentException.class)
	public void testMinPos_0(EList obj)
	{
		
		int[] rr = {};
		obj.init(rr);
		obj.minPos();

	}
	
	@Test (dataProvider = "data")
	public void testMinPos_1(EList obj)
	{
		
		int[] rr = {2};
		obj.init(rr);
		int minPos = obj.minPos();
		assertEquals(0,minPos);
	}
	
	@Test (dataProvider = "data")
	public void testMinPos_2(EList obj)
	{
		
		int[] rr = {1,2};
		obj.init(rr);
		int minPos = obj.minPos();
		assertEquals(0,minPos);
	}
	
	@Test (dataProvider = "data")
	public void testMinPos_3(EList obj)
	{
		
		int[] rr = {23,53,4};
		obj.init(rr);
		int minPos = obj.minPos();
		assertEquals(2,minPos);
	}
	
	@Test (dataProvider = "data")
	public void testMinPos_many_fewMins(EList obj)
	{
		
		int[] rr = {1,2,23,2,4,1,23,1};
		obj.init(rr);
		int minPos = obj.minPos();
		assertEquals(0,minPos);
	}
	
	@Test (dataProvider = "data")
	public void testMinPos_allthesame(EList obj)
	{
		
		int[] rr = {12,12,12,12,12,12,12,12};
		obj.init(rr);
		int minPos = obj.minPos();
		assertEquals(0,minPos);
	}
	
	
	//============================================================================================

	@Test (dataProvider = "data")
	public void testMin_allthesame(EList obj)
	{
		
		int[] rr = {12,12,12,12,12,12,12,12};
		obj.init(rr);
		int min = obj.min();
		assertEquals(12,min);
	}
	
	@Test (dataProvider = "data", expectedExceptions = IllegalArgumentException.class)
	public void testMin_0(EList obj)
	{
		
		int[] rr = {};
		obj.init(rr);
		obj.min();
	}
	
	@Test (dataProvider = "data")
	public void testMin_1(EList obj)
	{
		
		int[] rr = {12};
		obj.init(rr);
		int min = obj.min();
		assertEquals(12,min);
	}
	
	@Test (dataProvider = "data")
	public void testMin_2(EList obj)
	{
		
		int[] rr = {112,312};
		obj.init(rr);
		int min = obj.min();
		assertEquals(112,min);
	}
	
	@Test (dataProvider = "data")
	public void testMin_3(EList obj)
	{
		
		int[] rr = {12,43,5};
		obj.init(rr);
		int min = obj.min();
		assertEquals(5 , min);
	}
	
	@Test (dataProvider = "data")
	public void testMin_many(EList obj)
	{
		
		int[] rr = {6,616,816,9816,84,126,13,0,841,};
		obj.init(rr);
		int min = obj.min();
		assertEquals(0,min);
	}
	
	
	//============================================================================================

	@Test (dataProvider = "data")
	public void testMaxPos_1(EList obj)
	{
		
		int[] rr = {12};
		obj.init(rr);
		int maxPos = obj.maxPos();
		assertEquals(0,maxPos);
	}
	
	@Test (dataProvider = "data")
	public void testMaxPos_2(EList obj)
	{
		
		int[] rr = {12,1};
		obj.init(rr);
		int maxPos = obj.maxPos();
		assertEquals(0,maxPos);
	}
	
	@Test (dataProvider = "data")
	public void testMaxPos_3(EList obj)
	{
		
		int[] rr = {2,1,12};
		obj.init(rr);
		int maxPos = obj.maxPos();
		assertEquals(2, maxPos);
	}
	
	@Test (dataProvider = "data")
	public void testMaxPos_many(EList obj)
	{
		
		int[] rr = {12,1981,981,8,4,9,2};
		obj.init(rr);
		int maxPos = obj.maxPos();
		assertEquals(1, maxPos);
	}
	
	@Test (dataProvider = "data", expectedExceptions = IllegalArgumentException.class)
	public void testMaxPos_zero(EList obj) 
	{
		
		int[] rr = {};
		obj.init(rr);
		obj.maxPos();
	
	}
	
	@Test (dataProvider = "data")
	public void testMaxPos_manyAllTheSame(EList obj) 
	{
		
		int[] rr = {22,22,22,22,22,22,22,22,22};
		obj.init(rr);
		int maxPos = obj.maxPos();
		assertEquals(0, maxPos);
	}
	
	
	//============================================================================================

	@Test (dataProvider = "data")
	public void testMax_manyAllTheSame(EList obj) 
	{
		
		int[] rr = {22,22,22,22,22,22,22,22,22};
		obj.init(rr);
		int max = obj.max();
		assertEquals(22, max);
	}
	
	@Test (dataProvider = "data", expectedExceptions = IllegalArgumentException.class)
	public void testMax_0(EList obj) 
	{
		
		int[] rr = {};
		obj.init(rr);
		obj.max();

	}
	
	@Test (dataProvider = "data")
	public void testMax_1(EList obj) 
	{
		
		int[] rr = {22};
		obj.init(rr);
		int max = obj.max();
		assertEquals(22, max);
	}
	
	@Test (dataProvider = "data")
	public void testMax_2(EList obj) 
	{
		
		int[] rr = {22,855};
		obj.init(rr);
		int max = obj.max();
		assertEquals(855, max);
	}
	
	@Test (dataProvider = "data")
	public void testMax_3(EList obj) 
	{
		
		int[] rr = {22,17,178};
		obj.init(rr);
		int max = obj.max();
		assertEquals(178, max);
	}
	
	@Test (dataProvider = "data")
	public void testMax_many(EList obj) 
	{
		
		int[] rr = {22,325,658,86,4568,3,32};
		obj.init(rr);
		int max = obj.max();
		assertEquals(4568, max);
	}
	
	
	//============================================================================================

	@Test (dataProvider = "data")
	public void testSet_mid(EList obj) 
	{
		
		int[] rr = {22,325,658,86,4568,3,32};
		obj.init(rr);
		obj.set(33, 3);
		int[] exp={22,325,658,33,4568,3,32};
		assertArrayEquals(exp, obj.toArray());
	}
	
	@Test (dataProvider = "data")
	public void testSet_beginning(EList obj) 
	{
		
		int[] rr = {22,325,658,86,4568,3,32};
		obj.init(rr);
		obj.set(33, 0);
		int[] exp={33,325,658,86,4568,3,32};
		assertArrayEquals(exp, obj.toArray());
	}
	
	@Test (dataProvider = "data")
	public void testSet_end(EList obj) 
	{
		
		int[] rr = {22,325,658,86,4568,3,32};
		obj.init(rr);
		obj.set(33, 6);
		int[] exp={22,325,658,86,4568,3,33};
		assertArrayEquals(exp, obj.toArray());
	}
	
	@Test (dataProvider = "data", expectedExceptions = IllegalArgumentException.class)
	public void testSet_moreThan(EList obj) 
	{
		
		int[] rr = {22,325,658,86,4568,3,32};
		obj.init(rr);
		obj.set(33, 22);
	}
	
	@Test (dataProvider = "data", expectedExceptions = IllegalArgumentException.class)
	public void testSet_lessThan(EList obj) 
	{
		
		int[] rr = {22,325,658,86,4568,3,32};
		obj.init(rr);
		obj.set(33, -2);
	}
	
	@Test (dataProvider = "data", expectedExceptions = IllegalArgumentException.class)
	public void testSet_whenleng0(EList obj) 
	{
		
		int[] rr = {};
		obj.init(rr);
		obj.set(33, 0);
	}
	
	@Test (dataProvider = "data") 
	public void testSet_whenLeng1(EList obj) 
	{
		
		int[] rr = {22};
		obj.init(rr);
		obj.set(33, 0);
		int[] exp={33};
		assertArrayEquals(exp, obj.toArray());
	}
	//============================================================================================

	@Test (dataProvider = "data")
	public void testAddPos_1(EList obj) 
	{
		
		int[] rr = {22};
		obj.init(rr);
		obj.addPos(123, 1);
		int[] exp={22,123};
		assertArrayEquals(exp, obj.toArray());
	}
	
	@Test (dataProvider = "data")
	public void testAddPos_2(EList obj) 
	{
		
		int[] rr = {22,2};
		obj.init(rr);
		obj.addPos(123, 1);
		int[] exp={22,2,123};
		assertArrayEquals(exp, obj.toArray());
	}
	
	@Test (dataProvider = "data")
	public void testAddPos_3(EList obj) 
	{
		
		int[] rr = {22,2,4};
		obj.init(rr);
		obj.addPos(123, 2);
		int[] exp={22,2,4,123};
		assertArrayEquals(exp, obj.toArray());
	}
	
	@Test (dataProvider = "data")
	public void testAddPos_many(EList obj) 
	{
		
		int[] rr = {22,2,4,41,124,534,6};
		obj.init(rr);
		obj.addPos(123, 5);
		int[] exp={22,2,4,41,124,123,534,6};
		assertArrayEquals(exp, obj.toArray());
	}
	
	@Test (dataProvider = "data")
	public void testAddPos_manyInEnd(EList obj) 
	{
		
		int[] rr = {22,2,4,41,124,534,6};
		obj.init(rr);
		obj.addPos(123, 6);
		int[] exp={22,2,4,41,124,534,6,123};
		assertArrayEquals(exp, obj.toArray());
	}
	
	@Test (dataProvider = "data")
	public void testAddPos_manyInBeg(EList obj) 
	{
		
		int[] rr = {22,2,4,41,124,534,6};
		obj.init(rr);
		obj.addPos(123, 0);
		int[] exp={123,22,2,4,41,124,534,6};
		assertArrayEquals(exp, obj.toArray());
	}
	
	@Test (dataProvider = "data", expectedExceptions = IllegalArgumentException.class)
	public void testAddPos_moreThanleng(EList obj) 
	{
		
		int[] rr = {22,2,4,41,124,534,6};
		obj.init(rr);
		obj.addPos(123, 512);
		int[] exp={123,22,2,4,41,124,534,6};
		assertArrayEquals(exp, obj.toArray());
	}
	
	@Test (dataProvider = "data", expectedExceptions = IllegalArgumentException.class)
	public void testAddPos_lessthanLeng(EList obj) 
	{
		
		int[] rr = {22,2,4,41,124,534,6};
		obj.init(rr);
		obj.addPos(123, -558);
	}
	
	
	//============================================================================================

	@Test (dataProvider = "data", expectedExceptions = IllegalArgumentException.class)
	public void testDelPos_from0(EList obj) 
	{
		
		int[] rr = {};
		obj.init(rr);
		obj.delPos(0);
	}
	
	@Test (dataProvider = "data")
	public void testDelPos_from1(EList obj) 
	{
		
		int[] rr = {22};
		obj.init(rr);
		int del = obj.delPos(0);
		int[] exp = {};
		assertEquals(22, del);
		assertArrayEquals(exp, obj.toArray());
	}
	
	@Test (dataProvider = "data")
	public void testDelPos_from2(EList obj) 
	{
		
		int[] rr = {22,46};
		obj.init(rr);
		int del = obj.delPos(1);
		int[] exp = {22};
		assertEquals(46, del);
		assertArrayEquals(exp, obj.toArray());
	}
	
	@Test (dataProvider = "data")
	public void testDelPos_manymiddle(EList obj) 
	{
		
		int[] rr = {22,2,4,41,124,534,6};
		obj.init(rr);
		int del = obj.delPos(4);
		int[] exp = {22,2,4,41,534,6};
		assertEquals(124, del);
		assertArrayEquals(exp, obj.toArray());
	}
	
	@Test (dataProvider = "data")
	public void testDelPos_beg(EList obj) 
	{
		
		int[] rr = {22,2,4,41,124,534,6};
		obj.init(rr);
		int del = obj.delPos(0);
		int[] exp = {2,4,41,124,534,6};
		assertEquals(22, del);
		assertArrayEquals(exp, obj.toArray());
	}
	
	@Test (dataProvider = "data")
	public void testDelPos_end(EList obj) 
	{
		
		int[] rr = {22,2,4,41,124,534,6};
		obj.init(rr);
		int del = obj.delPos(6);
		int[] exp = {22,2,4,41,124,534};
		assertEquals(6, del);
		assertArrayEquals(exp, obj.toArray());
	}
	
	@Test (dataProvider = "data")
	public void testDelPos_onebeforeend(EList obj) 
	{
		
		int[] rr = {22,2,4,41,124,534,6};
		obj.init(rr);
		int del = obj.delPos(5);
		int[] exp = {22,2,4,41,124,6};
		assertEquals(534, del);
		assertArrayEquals(exp, obj.toArray());
	}
	
	@Test (dataProvider = "data")
	public void testDelPos_oneafterbeg(EList obj) 
	{
		
		int[] rr = {22,2,4,41,124,534,6};
		obj.init(rr);
		int del = obj.delPos(1);
		int[] exp = {22,4,41,124,534,6};
		assertEquals(2, del);
		assertArrayEquals(exp, obj.toArray());
	}
	
	//============================================================================================

	@Test (dataProvider = "data")
	public void testSort_0(EList obj) 
	{
		
		int[] rr = {};
		obj.init(rr);
		obj.sort();
		int[] exp = {};
		assertArrayEquals(exp, obj.toArray());
	}
	
	@Test (dataProvider = "data")
	public void testSort_1(EList obj) 
	{
		
		int[] rr = {22};
		obj.init(rr);
		obj.sort();
		int[] exp = {22};
		assertArrayEquals(exp, obj.toArray());
	}
	
	@Test (dataProvider = "data")
	public void testSort_2(EList obj) 
	{
		
		int[] rr = {22,2};
		obj.init(rr);
		obj.sort();
		int[] exp = {2,22};
		assertArrayEquals(exp, obj.toArray());
	}
	
	@Test (dataProvider = "data")
	public void testSort_manyOdd(EList obj) 
	{
		
		int[] rr = {22,2,4,41,124,534,6};
		obj.init(rr);
		obj.sort();
		int[] exp = {2,4,6,22,41,124,534};
		assertArrayEquals(exp, obj.toArray());
	}
	
	@Test (dataProvider = "data")
	public void testSort_even(EList obj) 
	{
		
		int[] rr = {22,2,4,41,124,534};
		obj.init(rr);
		obj.sort();
		int[] exp = {2,4,22,41,124,534};
		assertArrayEquals(exp, obj.toArray());
	}
	
	
	
	//============================================================================================

	@Test (dataProvider = "data")
	public void testReverse_0(EList obj) 
	{
		
		int[] rr = {};
		obj.init(rr);
		obj.Reverse();
		int[] exp = {};
		assertArrayEquals(exp, obj.toArray());
	}
	
	@Test (dataProvider = "data")
	public void testReverse_1(EList obj) 
	{
		
		int[] rr = {22};
		obj.init(rr);
		obj.Reverse();
		int[] exp = {22};
		assertArrayEquals(exp, obj.toArray());
	}
	
	@Test (dataProvider = "data")
	public void testReverse_2(EList obj) 
	{
		
		int[] rr = {22,2};
		obj.init(rr);
		obj.Reverse();
		int[] exp = {2,22};
		assertArrayEquals(exp, obj.toArray());
	}
	
	@Test (dataProvider = "data")
	public void testReverse_manyOdd(EList obj) 
	{
		
		int[] rr = {22,2,4,41,124,534,32};
		obj.init(rr);
		obj.Reverse();
		int[] exp = {32,534,124,41,4,2,22};
		assertArrayEquals(exp, obj.toArray());
	}
	
	@Test (dataProvider = "data")
	public void testReverse_manyEven(EList obj) 
	{
		
		int[] rr = {22,2,4,41,124,534};
		obj.init(rr);
		obj.Reverse();
		int[] exp = {534,124,41,4,2,22};
		assertArrayEquals(exp, obj.toArray());
	}
	
	//============================================================================================


	@Test (dataProvider = "data")
	public void testHalfReverse_0(EList obj)
	{
		
		int[] rr = {};
		obj.init(rr);
		obj.halfReverse();
		int[] exp = {};
		assertArrayEquals(exp, obj.toArray());
	}
	
	@Test (dataProvider = "data")
	public void testHalfReverse_1(EList obj)
	{
		
		int[] rr = {22};
		obj.init(rr);
		obj.halfReverse();
		int[] exp = {22};
		assertArrayEquals(exp, obj.toArray());
	}
	
	@Test (dataProvider = "data")
	public void testHalfReverse_2(EList obj)
	{
		
		int[] rr = {22,2};
		obj.init(rr);
		obj.halfReverse();
		int[] exp = {2,22};
		assertArrayEquals(exp, obj.toArray());
	}
	
	@Test (dataProvider = "data")
	public void testHalfReverse_manyOdd(EList obj)
	{
		
		int[] rr = {22,2,4,33,41,124,534};
		obj.init(rr);
		obj.halfReverse();
		int[] exp = {41,124,534,33,22,2,4};
		assertArrayEquals(exp, obj.toArray());
	}
	
	@Test (dataProvider = "data")
	public void testHalfReverse_manyeven(EList obj)
	{
		
		int[] rr = {22,2,4,41,124,534};
		obj.init(rr);
		obj.halfReverse();
		int[] exp = {41,124,534,22,2,4};
		assertArrayEquals(exp, obj.toArray());
	}	
}

