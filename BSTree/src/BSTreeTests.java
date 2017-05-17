import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(value = Parameterized.class)
public class BSTreeTests
{
	Tree obj = null;

	public BSTreeTests(Tree ini) 
	{
		obj = ini;
	}

	@Parameters
	public static Collection <Object[]> data() 
	{
		Object[][] data = new Object[][] { {new BSTree()} /*, {new LList2()} , {new RoundList()}*/};
		return Arrays.asList(data);
	}


	@Before
	public void setUp()
	{
		obj.clear();
	}


	//ADD========================================================
	
	@Test
	public void add_one()
	{
		int[] arr = {123,2,3,4,56,7,8,43,11,321};
		obj.init(arr);
		obj.add(9);
		int[] exp = {2,3,4,7,8,9,11,43,56,123,321};
		assertArrayEquals(exp, obj.toArray());
	}
	@Test
	public void add_2()
	{
		int[] arr = {123,2,3,4,56,7,8,43,11,321};
		obj.init(arr);
		obj.add(9);
		obj.add(7785);
		int[] exp = {2,3,4,7,8,9,11,43,56,123,321,7785};
		assertArrayEquals(exp, obj.toArray());
	}
	@Test
	public void add_many()
	{
		int[] arr = {123,2,3,4,56,7,8,43,11,321};
		obj.init(arr);
		obj.add(9);
		obj.add(112);
		obj.add(32);
		obj.add(548);
		obj.add(1);
		obj.add(0);
		int[] exp = {0,1,2,3,4,7,8,9,11,32,43,56,112,123,321,548};
		assertArrayEquals(exp, obj.toArray());
	}
	
	//INIT==================================================
	
	@Test 
	public void init_0()
	{
		int[] arr = {};
		obj.init(arr);
		int[] exp = {};
		assertArrayEquals(exp, obj.toArray());
	}
	
	@Test 
	public void init_null()
	{
		int[] arr = null;
		obj.init(arr);
		int[] exp = {};
		assertArrayEquals(exp, obj.toArray());
	}
	
	@Test
	public void init_1()
	{
		int[] arr = {123};
		obj.init(arr);
		
		int[] exp = {123};
		assertArrayEquals(exp, obj.toArray());
	}
	
	@Test
	public void init_2()
	{
		int[] arr = {123,2};
		obj.init(arr);
		
		int[] exp = {2,123};
		assertArrayEquals(exp, obj.toArray());
	}
	
	@Test
	public void init_3()
	{
		int[] arr = {3,4,56};
		obj.init(arr);
		
		int[] exp = {3,4,56};
		assertArrayEquals(exp, obj.toArray());
	}
	
	@Test
	public void init_many()
	{
		int[] arr = {123,2,3,4,56,7,8,43,11,321};
		obj.init(arr);
		
		int[] exp = {2,3,4,7,8,11,43,56,123,321};
		assertArrayEquals(exp, obj.toArray());
	}
	
	//CLEAR============================================
	
	@Test
	public void clear_null()
	{
		obj.clear();
		
		int[] exp = {};
		assertArrayEquals(exp, obj.toArray());
	}
	
	@Test
	public void clear_afterIni()
	{
		int[] arr = {123,2,3,4,56,7,8,43,11,321};
		obj.init(arr);
		obj.clear();
		int[] exp = {};
		assertArrayEquals(exp, obj.toArray());
	}
	
	@Test
	public void clear_afterADD()
	{
		int[] arr = {123,2,3,4,56,7,8,43,11,321};
		obj.init(arr);
		obj.add(10);
		obj.clear();
		int[] exp = {};
		assertArrayEquals(exp, obj.toArray());
	}
	
	@Test
	public void clear_afterClear()
	{
		int[] arr = {123,2,3,4,56,7,8,43,11,321};
		obj.init(arr);
		obj.clear();
		obj.clear();
		int[] exp = {};
		assertArrayEquals(exp, obj.toArray());
	}
	
	//TOARRAY=======================================================

	@Test
	public void ToArray_1()
	{
		int[] arr = {2};
		obj.init(arr);
		int[] exp = {2};
		assertArrayEquals(exp, obj.toArray());
	}
	

	@Test
	public void ToArray_2()
	{
		int[] arr = {123,321};
		obj.init(arr);

		int[] exp = {123,321};
		assertArrayEquals(exp, obj.toArray());
	}
	

	@Test
	public void ToArray_3()
	{
		int[] arr = {123,2,321};
		obj.init(arr);

		int[] exp = {2,123,321};
		assertArrayEquals(exp, obj.toArray());
	}
	

	@Test
	public void ToArray_0()
	{
		int[] arr = {};
		obj.init(arr);
		int[] exp = {};
		assertArrayEquals(exp, obj.toArray());
	}
	

	@Test
	public void ToArray_many()
	{
		int[] arr = {123,2,3,4,56,7,8,43,11,321};
		obj.init(arr);
		int[] exp = {2,3,4,7,8,11,43,56,123,321};
		assertArrayEquals(exp, obj.toArray());
	}
	
	

}
