import static org.junit.Assert.*;

import org.junit.Test;

public class AList1_Resize
{

	@Test
	public void Resize_10()
	{
		AList1 obj = new AList1();
		int[] init = {1,2,3,4,5,3,4,5,3,4};
		obj.init(init);
		obj.resize();
		assertEquals(20, obj.arr.length);
	}

}
