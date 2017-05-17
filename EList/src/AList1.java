import java.util.Iterator;

public class AList1 implements EList, Iterable<Integer>
{
	int[] arr = new int [10];
	int length = 0;


	public void addStart(int val)
	{
		if(length + 1 >= arr.length)
		{
			resize();
		}
		for(int i = length; i > 0; i--)
		{
			arr[i] = arr[i-1];
		}
		arr[0] = val;
		length++;
	}

	public void resize()
	{
		int[] tmp = arr;
		arr = new int[length * 2];
		for (int i = 0; i < tmp.length; i++)
		{
			arr[i] = tmp[i];
		}
	}

	public void addEnd(int val)
	{
		if(length + 1 >= arr.length)
		{
			resize();
		}
		arr[length++] = val;
	}

	public int[] toArray() 
	{
		int[] tmp = new int[length];
		for(int i = 0; i < length; i++)
		{
			tmp[i] = arr[i];
		}
		return tmp;
	}

	public int delEnd() 
	{
		if(length < 1)
		{
			throw new IllegalArgumentException();
		}
		if(length == 1)
		{
			length = 0;
			return arr[0];
		}
		int tmp = arr[length-1];
		arr[length-1] = 0;
		length--;
		return tmp;
	}

	public int delStart()
	{
		if(length == 0)
		{
			throw new IllegalArgumentException();
		}
		int tmp = arr[0];
		for (int i = 0; i < length; i++) 
		{
			arr[i] = arr[i + 1];
		}
		length--;
		return tmp;
	}

	public void clear()
	{
		length = 0;
	}

	public void init(int[] rr)
	{
		if(rr.length > arr.length)
		{
			arr = new int[rr.length];
		}
		clear();
		if(rr == null || rr.length == 0)
		{
			length = 0;
			return;
		}

		length = rr.length;
		for (int i = 0; i < length; i++) 
		{
			arr[i] = rr[i];
		}
	}

	public int size()
	{
		return length;
	}

	public String toString()
	{
		if(length < 1)
		{
			return "Nothing here!";
		}
		String tmp = "{";
		for (int i = 0; i < length; i++) 
		{
			if(i == length - 1)
			{
				tmp += arr[i];
			}
			else
			{
				tmp = tmp + arr[i]+", ";	
			}
		}
		tmp+="}";
		return tmp;
	}

	public int get(int pos) 
	{
		if(pos >= length || pos<0)
		{
			throw new IllegalArgumentException();
		}
		int res = arr[pos];
		return res;
	}

	public int minPos()
	{
		if(length == 0)
		{
			throw new IllegalArgumentException();
		}
		if(length == 1)
		{
			return 0;
		}
		int minPos = 0;
		for (int i = 1; i < length; i++) 
		{
			if(arr[i] < arr[minPos])
			{
				minPos = i;
			}
		}
		return minPos;
	}

	public int maxPos() 
	{
		if(length == 0)
		{
			throw new IllegalArgumentException();
		}
		if(length == 1)
		{
			return 0;
		}
		int maxPos = 0;
		for (int i = 1; i < length; i++) 
		{
			if(arr[i] > arr[maxPos])
			{
				maxPos = i;
			}
		}
		return maxPos;
	}

	public int min() 
	{
		if(length == 0)
		{
			throw new IllegalArgumentException();
		}
		if(length == 1)
		{
			return arr[0];
		}
		int min = arr[minPos()];
		return min;
	}

	public int max() 
	{
		if(length == 0)
		{
			throw new IllegalArgumentException();
		}
		if(length == 1)
		{
			return arr[0];
		}
		int max = arr[maxPos()];
		return max;
	}

	public void set(int newelem,int pos) 
	{
		if(pos >= length || pos > 0 && length == 0 || pos < 0)
		{
			throw new IllegalArgumentException();
		}
		arr[pos] = newelem;
	}

	public void addPos(int elem,int pos)
	{	
		if(pos < 0 || pos > length)
		{
			throw new IllegalArgumentException();
		}
		if(pos == length - 1)
		{
			addEnd(elem);
			return;
		}
		if(pos == 0)
		{
			addStart(elem);
			return;
		}
		if(length + 1 >= arr.length)
		{
			resize();
		}
		for (int i = length; i > pos; i--)
		{
			arr[i] = arr[i - 1];
		}
		arr[pos] = elem;
		length++;
	}

	public int delPos(int pos) 
	{
		if(pos < 0 || pos > length)
		{
			throw new IllegalArgumentException();
		}
		if(length == 1)
		{
			int del = arr[0];
			length = 0;
			return del;
		}
		if(pos == length - 1)
		{
			int del = delEnd();
			return del;
		}
		if(pos == 0)
		{
			int del = delStart();
			return del;
		}
		int del = arr[pos];

		for (int i = pos + 1; i < length; i++)
		{
			arr[i - 1] = arr[i];
		}
		length--;
		return del;
	}

	public void sort() 
	{
		if (arr == null || length == 0)
		{
			return;
		}
		if(length == 1)
		{
			return;
		}
		int temp = 0;
		for(int i = 0; i < length; i++)
		{
			for(int j = 0; j < length-1; j++)
			{
				if(arr[j] > arr[j+1])
				{
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}

	public void Reverse() 
	{
		if(arr == null || length == 0 || length == 1)
		{
			return;
		}
		int[] temp = new int[length];
		for (int i = 0; i < temp.length; i++) 
		{
			temp[i] = arr[length - i-1];
		}
		
		for(int i = 0; i < length; i++)
		{
			arr[i] = temp[i];
		}
	}
	
	public void halfReverse() 
	{
		if(arr == null || length ==0 || length == 1)
		{
			return;
		}
		int temp = 0;
		int middle = length-(length / 2);
		for (int i = 0; i < length/2; i++) 
		{
			temp = arr[i];
			arr[i] = arr[middle+i];
			arr[middle+i] = temp;
		}
	}

	@Override
	public Iterator<Integer> iterator()
	{
		return new Iterator<Integer>()
		{
			int curpos = 0;
			@Override
			public boolean hasNext()
			{
				boolean has = false;
				if(curpos != length)
				{
					has = true;
				}
				return has;
			}

			@Override
			public Integer next()
			{
				return arr[curpos ++];
			}
			
			
		};
	}
	
	
	
	
	
	
}
