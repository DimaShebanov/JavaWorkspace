import static org.junit.Assert.assertEquals;

public class LList2 implements LList
{
	public Node root = null;
	Node end = null;
	int size = 0;
	public class Node
	{
		Node next;
		Node prev;
		int val;

		public Node(int val)
		{
			this.val = val;
		}
	}

	@Override
	public void addStart(int val) 
	{
		if(root == null)
		{
			Node tmp = new Node(val);
			root = tmp;
			end = tmp;
			size++;
			return;
		}

		Node tmp = new Node(val);
		tmp.next = root;
		root.prev = tmp;
		root = tmp;
		size++;
	}

	@Override
	public void addEnd(int val) 
	{
		if(root == null)
		{
			addStart(val);
			return;
		}
		Node tmp = new Node(val);
		end.next = tmp;
		tmp.prev = end;
		end = tmp;
		size++;
	}

	@Override
	public int get(int pos) 
	{
		if(root == null || pos < 0 || pos >= size)
		{
			throw new IllegalArgumentException();
		}
		if(pos == 0)
		{
			int val = root.val;
			return val;
		}
		if(size == 1)
		{
			return root.val;
		}
		Node tmp = root;
		for(int i = 0; i < pos; i++)
		{
			tmp = tmp.next;
		}
		int res = tmp.val;
		return res;
	}

	@Override
	public int[] toArray() 
	{
		int[] arr = new int[size];
		Node tmp = root;
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = tmp.val;
			tmp = tmp.next;
		}
		return arr;
	}

	@Override
	public int delEnd() 
	{
		if(root == null)
		{
			throw new IllegalArgumentException();
		}
		if(size == 1)
		{
			int del = root.val;
			root = null;
			size--;
			return del;
		}
		int del = end.val;
		end = end.prev;
		end.next = null;
		size--;
		return del;
	}

	@Override
	public int delStart() 
	{
		if(root == null)
		{
			throw new IllegalArgumentException();
		}
		if(size == 1)
		{
			int del = root.val;
			root = null;
			size--;
			return del;
		}
		int del = root.val;
		root.next.prev = null;
		root = root.next;
		size--;
		return del;
	}

	@Override
	public void clear() 
	{
		size = 0;
		root = null;
		end = null;
	}

	@Override
	public void init(int[] rr) 
	{
		if(rr.length < 0)
		{
			throw new IllegalArgumentException();
		}
		for(int i = 0; i < rr.length; i++)
		{
			addEnd(rr[i]);
		}

	}

	@Override
	public int size() 
	{
		return size;
	}

	@Override
	public int minPos() 
	{
		if(root == null)
		{
			throw new IllegalArgumentException();
		}
		if(size == 1)
		{
			return 0;
		}
		int minPos = 0;
		for(int i = 0; i < size; i++)
		{
			if(get(i) < get(minPos))
			{
				minPos = i;
			}
		}
		return minPos;
	}

	@Override
	public int maxPos() 
	{
		if(root == null)
		{
			throw new IllegalArgumentException();
		}
		if(size == 1)
		{
			return 0;
		}
		int maxPos = 0;
		for(int i = 0; i < size; i++)
		{
			if(get(i) > get(maxPos))
			{
				maxPos = i;
			}
		}
		return maxPos;
	}

	@Override
	public int min() 
	{
		return get(minPos());
	}

	@Override
	public int max() 
	{
		return get(maxPos());
	}

	@Override
	public void set(int pos, int val) 
	{
		if(root == null || pos < 0 || pos >= size)
		{
			throw new IllegalArgumentException();
		}
		if(pos == 0)
		{
			root.val = val;
			return;
		}
		Node tmp = root;
		for(int i = 0; i < pos; i++)
		{
			tmp = tmp.next;
		}
		tmp.val = val;
	}

	@Override
	public void addPos(int pos, int val) 
	{
		if(root == null || pos < 0 || pos >= size)
		{
			throw new IllegalArgumentException();
		}
		if(pos == size - 1)
		{
			addEnd(val);
			return;
		}
		if(pos == 0)
		{
			addStart(val);
			return;
		}
		Node tmp = root;
		for(int i = 0; i < pos; i++)
		{
			tmp = tmp.next;
		}
		Node addNode = new Node(val);
		addNode.prev = tmp.prev;
		addNode.prev.next = addNode;
		addNode.next = tmp;
		tmp.prev = addNode;
		size++;

	}

	@Override
	public int delPos(int pos) 
	{
		if(pos == size - 1)
		{
			int del = delEnd();
			return del;
		}
		if(pos == 0)
		{
			int del = delStart();
			return del;
		}
		Node tmp = root;
		for(int i = 0; i < pos; i++)
		{
			tmp = tmp.next;
		}
		int del = tmp.val;
		tmp.next.prev = tmp.prev;
		tmp.prev.next = tmp.next;
		size--;
		return del;
	}

	@Override
	public String toString()
	{
		if(root == null)
		{
			return "Nothing here!";
		}
		Node tmpn = root;
		String tmp = "{";
		while (tmpn != null)
		{
			if(tmpn == end)
			{
				tmp += tmpn.val;
			}
			else
			{
				tmp += tmpn.val + ", ";
			}
			tmpn = tmpn.next;
		}
		tmp += "}";
		return tmp;
	}

	@Override
	public void sort() 
	{
		Node tmpr = null;
		int savesize = size;
		while(root != null)
		{
			int maxval = delPos(maxPos());

			Node tmp = new Node(maxval);

			tmp.next = tmpr;

			if(tmpr != null)
			{
				tmpr.prev = tmp;
			}
			tmpr = tmp;

		}
		size = savesize;
		root = tmpr;
	}


	@Override
	public void Reverse() 
	{
		if(size <= 1)
		{
			return;
		}
		Node tmpendbeg = end;
		Node tmpnexprev;
		Node tmp = root;
		for(int i = 0; i < size; i++)
		{
			tmpnexprev = tmp.prev;
			tmp.prev = tmp.next;
			tmp.next = tmpnexprev;
			tmp = tmp.prev;
		}
		end = root;
		root = tmpendbeg;
	}

	@Override
	public void halfReverse() 
	{
		if(root == null || size == 1)
		{
			return;
		}
		Node begOfBeg = root;
		Node endOfBeg = root;
		Node mid = root;
		Node begOfEnd = root;
		Node endOfEnd = end;
		int midInd = size - (size / 2);
		int d = (size % 2 == 0) ? 1 : 0;
		for(int i = 1; i < midInd - 1 + d; i++)
		{
			endOfBeg = endOfBeg.next;
		}
		
		if(size % 2 == 1)
		{
			mid = endOfBeg.next;
			endOfBeg.prev = mid;
		}
		else if(size % 2 == 0)
		{
			mid = endOfBeg;
		}
		begOfEnd = mid.next;
		mid.prev = begOfEnd;
		
		
		root = begOfEnd;
		if(mid == endOfBeg)
		{
			endOfEnd.next = begOfBeg;
			begOfBeg.prev = endOfEnd;
		}
		else if(mid != endOfBeg)
		{
			endOfEnd.next = mid;
			mid.prev = endOfEnd;
		}
		mid.next = begOfBeg;
		begOfBeg.prev = mid;
		end = endOfBeg;
		endOfBeg.next = null;
	}
}


