import static org.junit.Assert.*;

import org.junit.Test;

public class AList2_Resize
{

	@Test
	public void resize_many()
	{
		AList2 obj = new AList2();
		int[] init = {1,2,3,4,5,6,7,8,9,1,2,3,4,6,7};
		obj.init(init);
		obj.resize();
		assertEquals(90, obj.arr.length);
	}

}
