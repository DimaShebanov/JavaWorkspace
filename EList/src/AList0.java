import java.util.Iterator;

import org.testng.reporters.jq.Main;

class AList0 implements EList,Iterable<Integer>
{
	private int[] arr = new int[0];

	public void clear()
	{
		arr = new int[0];
	}

	public void init(int[] rr)
	{
		if(rr == null || rr.length == 0)
		{
			clear();
		}
		if(rr.length != 0 || rr != null)
		{
			arr = new int[rr.length];
			for (int i = 0; i < rr.length; i++) 
			{
				arr[i]=rr[i];
			}
		}
	}

	public int size()
	{
		return arr.length;
	}

	public int[] toArray() 
	{
		int[] temp = new int[arr.length];
		for (int i = 0; i < arr.length; i++) 
		{
			temp[i]=arr[i];
		}
		return temp;
	}

	public String toString()
	{
		if(arr.length<1)
		{
			return "Nothing here!";
		}
		String tmp="{";
		for (int i = 0; i < arr.length; i++) 
		{
			if(i==arr.length-1)
			{
				tmp+=arr[i];
			}
			else
			{
				tmp=tmp+arr[i]+", ";	
			}
		}
		tmp+="}";
		return tmp;
	}

	public void addStart(int add) 
	{
		int[] tmp=new int[arr.length+1];
		tmp[0]=add;
		for (int i = 1; i < tmp.length; i++) 
		{
			tmp[i]=arr[i-1];
		}
		arr=tmp;
	}

	public void addEnd(int add) 
	{
		int[] tmp=new int[arr.length+1];

		for (int i = 0; i < arr.length; i++) 
		{
			tmp[i]=arr[i];
		}
		tmp[tmp.length-1]=add;
		arr=tmp;
	}

	public int delStart()
	{
		if(arr.length==0)
		{
			throw new IllegalArgumentException();
		}
		if(arr.length==1)
		{
			int del=arr[0];
			arr = new int[0];
			return del;
		}
		int[] tmp = new int[arr.length-1];
		int del=arr[0];
		for (int i = 0; i < tmp.length; i++) 
		{
			tmp[i]=arr[i+1];
		}
		arr=tmp;
		return del;
	}

	public int delEnd()
	{
		if(arr.length==0)
		{
			throw new IllegalArgumentException();
		}
		if(arr.length==1)
		{
			int del=arr[0];
			arr = new int[0];
			return del;
		}
		int[] tmp = new int[arr.length-1];

		for (int i = 0; i < tmp.length; i++) 
		{
			tmp[i]=arr[i];
		}
		int del=arr[arr.length-1];
		arr=tmp;
		return del;
	}

	public int get(int pos) 
	{
		if(pos>=arr.length||pos<0)
		{
			throw new IllegalArgumentException();
		}
		int res=arr[pos];
		return res;
	}

	public int minPos() 
	{
		if(arr.length==0)
		{
			throw new IllegalArgumentException();
		}
		if(arr.length==1)
		{
			return 0;
		}
		int minPos=0;
		for (int i = 0; i < arr.length; i++) 
		{
			if(arr[i]<arr[minPos])
			{
				minPos=i;
			}
		}
		return minPos;
	}

	public int min() 
	{
		if(arr.length==0)
		{
			throw new IllegalArgumentException();
		}
		if(arr.length==1)
		{
			return arr[0];
		}
		int min=arr[minPos()];
		return min;
	}

	public int maxPos() 
	{
		if(arr.length==0)
		{
			throw new IllegalArgumentException();
		}
		if(arr.length==1)
		{
			return 0;
		}
		int maxPos=0;
		for (int i = 0; i < arr.length; i++) 
		{
			if(arr[i]>arr[maxPos])
			{
				maxPos=i;
			}
		}
		return maxPos;
	}

	public int max() 
	{
		if(arr.length==0)
		{
			throw new IllegalArgumentException();
		}
		if(arr.length==1)
		{
			return arr[0];
		}
		int max=arr[maxPos()];
		return max;
	}

	public void set(int newelem,int pos) 
	{
		if(pos>=arr.length||pos>0&&arr.length==0||pos<0)
		{
			throw new IllegalArgumentException();
		}
		arr[pos]=newelem;
	}

	public void addPos(int elem,int pos)
	{	
		if(pos < 0 || pos > arr.length)
		{
			throw new IllegalArgumentException();
		}
		if(pos == arr.length - 1)
		{
			addEnd(elem);
			return;
		}
		if(pos == 0)
		{
			addStart(elem);
			return;
		}
		int[] temp = new int[arr.length+1];
		int index=pos;
		for (int i = 0; i < temp.length; i++)
		{
			if(i < index)
			{
				temp[i]=arr[i];
			}
			else if(i==index)
			{
				temp[i]=elem;
			}
			else if(i > index)
			{
				temp[i]=arr[i-1];
			}
		}
		arr=temp;
	}

	public int delPos(int pos) 
	{
		if(pos == -1 || pos > arr.length)
		{
			throw new IllegalArgumentException();
		}
		if(arr.length == 1)
		{
			int del = arr[0];
			arr = new int[0];
			return del;
		}
		if(pos == arr.length)
		{
			int del = delEnd();
			return del;
		}
		if(pos == 0)
		{
			int del = delStart();
			return del;
		}
		int index = pos;
		int del = arr[index];
		int[] temp = new int[arr.length-1];
		for (int i = 0; i < temp.length; i++) 
		{
			if (i<index) 
			{
				temp[i] = arr[i];
			}
			else if(i >= index)
			{
				temp[i] = arr[i+1];
			}
		}
		arr = temp;
		return del;
	}

	public void sort() 
	{
		if (arr == null || arr.length == 0)
		{
			return;
		}
		if(arr.length == 1)
		{
			return;
		}
		int temp = 0;
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = 0; j < arr.length-1; j++)
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
		if(arr == null || arr.length == 0 || arr.length == 1)
		{
			return;
		}
		int[] temp = new int[arr.length];
		for (int i = 0; i < temp.length; i++) 
		{
			temp[i] = arr[arr.length - i-1];
		}
		arr = temp;
	}

	public void halfReverse() 
	{
		if(arr == null || arr.length ==0 || arr.length == 1)
		{
			return;
		}
		int temp = 0;
		int middle = arr.length-(arr.length / 2);
		for (int i = 0; i < arr.length/2; i++) 
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
				if(curpos != arr.length)
				{
					has = true;
				}
				return has;
			}

			@Override
			public Integer next()
			{
				return arr[curpos++];
			}
		};
	}
}
