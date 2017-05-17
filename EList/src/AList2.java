import java.util.Iterator;

public class AList2 implements EList,Iterable<Integer>
{
	int[] arr = new int[30];
	int start = arr.length - (arr.length / 2);
	int end = arr.length - (arr.length / 2);
	
	@Override
	public String toString()
	{
		if(end - start < 1)
		{
			return "Nothing here!";
		}
		String tmp = "{";
		int length = size();
		for (int i = 0; i < length; i++) 
		{
			if(i == length - 1)
			{
				tmp += arr[start + i];
			}
			else
			{
				tmp = tmp + arr[start + i]+", ";	
			}
		}
		tmp+="}";
		return tmp;		
	}
	
	@Override
	public void addStart(int val) 
	{
		if(start == 0)
		{
			resize();
		}
		start--;
		arr[start] = val;
	}
	
	@Override
	public void addEnd(int val) 
	{
		if(end + 1 >= arr.length)
		{
			resize();
		}
		arr[end] = val;
		end++;
	}
			
	public void resize()
	{
		int[] tmp = arr;
		arr = new int[arr.length * 3];
		start = arr.length - arr.length / 2;
		for(int i = 0; i < tmp.length; i++)
		{
			arr[start + i] = tmp[i];
		}
		
	}

	@Override
	public int[] toArray() 
	{
		int[] temp = new int[size()];
		for(int i = 0; i < temp.length; i++)
		{
			temp[i] = arr[start + i];
		}
		return temp;
	}
	
	@Override
	public int delEnd() 
	{
		if(size() < 1)
		{
			throw new IllegalArgumentException();
		}
		int temp = arr[end - 1];
		end--;
		return temp;
	}
	
	@Override
	public int delStart() 
	{
		if(size() < 1)
		{
			throw new IllegalArgumentException();
		}
		int temp = arr[start];
		start++;
		return temp;
	}
	
	@Override
	public void clear() 
	{
		start = arr.length - (arr.length / 2);
		end = start;
	}
	
	@Override
	public void init(int[] rr) 
	{
		if(rr == null)
		{
			throw new IllegalArgumentException();
		}
		
		if(rr.length > arr.length)
		{
			resize();
		}
		
		start = start - rr.length / 2;
		
		for(int i = 0; i < rr.length; i++)
		{
			arr[start + i] = rr[i];
		}
		
		end = start + rr.length;
	}
	
	@Override
	public int size() 
	{
		int temp = end - start;
		return temp;
	}
	
	@Override
	public int get(int pos) 
	{
		if(pos >= size() || pos < 0)
		{
			throw new IllegalArgumentException();
		}
		int temp = arr[start + pos];
		return temp;
	}
	
	@Override
	public int minPos() 
	{
		if(size() < 1 )
		{
			throw new IllegalArgumentException();
		}
		int minPos = 0;
		int len = size();
		for (int i = 0; i < len; i++) 
		{
			if (arr[start + i] < arr[start + minPos]) 
			{
				minPos = i;
			}
		}
		return minPos;
	}
	
	@Override
	public int maxPos() 
	{
		if(size() < 1 )
		{
			throw new IllegalArgumentException();
		}
		int maxPos = 0;
		int len = size();
		for (int i = 0; i < len; i++) 
		{
			if (arr[start + i] > arr[start + maxPos]) 
			{
				maxPos = i;
			}
		}
		return maxPos;
	}
	
	@Override
	public int min() 
	{
		int min = arr[start + minPos()];
		return min;
	}
	
	@Override
	public int max() 
	{
		int max = arr[start + maxPos()];
		return max;
	}
	
	@Override
	public void set(int newelem, int pos) 
	{
		if(pos < 0 || pos >= size())
		{
			throw new IllegalArgumentException();
		}
		arr[start + pos] = newelem;
	}
	
	@Override
	public void addPos(int elem, int pos) 
	{
		if(pos < 0 || pos > size())
		{
			throw new IllegalArgumentException();
		}
		if(start + pos == end - 1)
		{
			addEnd(elem);
			return;
		}
		if(pos == 0)
		{
			addStart(elem);
			return;
		}
		if(size() > arr.length)
		{
			resize();
		}
		for (int i = end; i > start + pos; i--)
		{
			arr[i] = arr[i - 1];
		}
		arr[start + pos] = elem;
		end++;
	}
	
	@Override
	public int delPos(int pos) 
	{
		if(pos < 0 || pos > size())
		{
			throw new IllegalArgumentException();
		}
		if(start + pos == end - 1)
		{
			int del = delEnd();
			return del;
		}
		if(pos == 0)
		{
			int del = delStart();
			return del;
		}
		int del = arr[start + pos];
		for (int i = start + pos; i < end; i++)
		{
			arr[i] = arr[i + 1];
		}
		end--;
		return del;
	}
	
	@Override
	public void sort() 
	{
		if (arr == null || size() <= 1)
		{
			return;
		}
		int temp = 0;
		for(int i = start; i < end; i++)
		{
			for(int j = start; j < end-1; j++)
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
	
	@Override
	public void Reverse() 
	{
		if(arr == null || size() <= 1)
		{
			return;
		}
		int[] temp = new int[size()];
		for (int i = 0; i < temp.length; i++) 
		{
			temp[i] = arr[end - i - 1];
		}
		
		for(int i = 0; i < temp.length; i++)
		{
			arr[start + i] = temp[i];
		}
	}
	
	@Override
	public void halfReverse() 
	{
		if(arr == null || size() <= 1)
		{
			return;
		}
		int temp = 0;
		int size = size();
		int middle = size - (size / 2);
		for (int i = 0; i < size / 2; i++) 
		{
			temp = arr[start + i];
			arr[start + i] = arr[middle + start + i];
			arr[middle + start + i] = temp;
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
				if(curpos + start != end)
				{
					has = true;
				}
				return has;
			}

			@Override
			public Integer next()
			{
				return arr[start + curpos++];
			}
		};
	}
}
