
public class LList1 implements LList
{
	private Node root = null;
	private Node end = root;
	private int size = 0;
	
	private class Node
	{
		int val;
		Node next;
		
		private Node(int val) 
		{
			this.val = val;
		}

		private Node() 
		{}
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
		}
		else if(root != null)
		{
			Node tmp = new Node(val);
			tmp.next = root;
			root = tmp;
			size++;
		}
	}

	@Override
	public void addEnd(int val) 
	{
		if(root == null)
		{
			addStart(val);
			return;
		}
		else if(root != null)
		{
			Node tmp = new Node(val);
			end.next = tmp;
			end = tmp;
			size++;
		}
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
		int val = tmp.val;
		return val;
	}

	@Override
	public int[] toArray() 
	{
		int[] tmp = new int[size];
		for(int i = 0; i < size; i++)
		{
			tmp[i] = get(i);
		}
		return tmp;
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
		if(size == 2)
		{
			int del = root.next.val;
			root.next = null;
			size--;
			return del;
		}
		Node tmp = getNode(size - 2);
		int del = tmp.next.val;
		tmp.next = null;
		end = tmp;
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
		Node tmp = root;
		tmp = tmp.next;
		root = tmp;
		size--;
		return del;
	}

	@Override
	public void clear() 
	{
		root = null;
		size = 0;
	}

	@Override
	public void init(int[] rr) 
	{
		clear();
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

	public Node getNode(int pos) 
	{
		if(root == null || pos < 0)
		{
			throw new IllegalArgumentException();
		}
		if(pos == 0)
		{
			return root;
		}
		Node tmp = root;
		for(int i = 1; i <= pos; i++)
		{
			tmp = tmp.next;
		}
		return tmp;
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
		Node tmp = getNode(pos);
		tmp.val = val;
	}

	@Override
	public void addPos(int pos, int val) 
	{
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
		if(pos >= size || pos < 0)
		{
			throw new IllegalArgumentException();
		}
		Node tmpbeforepos = getNode(pos - 1);
		Node tmpPos = getNode(pos);
		Node add = new Node(val);
		tmpbeforepos.next = add;
		add.next = tmpPos;
		size++;
	}			

	@Override
	public int delPos(int pos) 
	{
		if(pos == size)
		{
			int del = delEnd();
			return del;
		}
		if(pos == 0)
		{
			int del = delStart();
			return del;
		}
		Node tmpbeforepos = getNode(pos - 1);
		Node tmppos = getNode(pos);
		int del = tmppos.val;
		tmpbeforepos.next = tmppos.next;
		tmppos = null;
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

		String tmp = "{";
		for(int i = 0; i < size; i++)
		{
			if(i == size - 1)
			{
				tmp += get(i);
			}
			else
			{
				tmp += get(i) + ", ";
			}
		}
		tmp += "}";
		return tmp;
	}

	@Override
	public void sort() 
	{
		for(int i = 0; i < size; i++)
		{
			Node tmp = root;
			while (tmp.next != null)
			{
				if(tmp.val > tmp.next.val)
				{
					int tmpval = tmp.val;
					tmp.val = tmp.next.val;
					tmp.next.val = tmpval;
				}
				tmp = tmp.next;
			}
		}
	}

	@Override
	public void Reverse() 
	{
		if(root == null || size == 1)
		{
			return;
		}

		Node tmproot = null;

		while(root != null)	
		{
			Node tmp = root;
			root = root.next;
			tmp.next = tmproot;
			tmproot = tmp;
		}
		root = tmproot;
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
		Node endOfEnd = root;
		int midInd = size - (size / 2);
		int d = (size % 2 == 0) ? 1 : 0;
		for(int i = 1; i < midInd - 1 + d; i++)
		{
			endOfBeg = endOfBeg.next;
		}
		
		if(size % 2 == 1)
		{
			mid = endOfBeg.next;
		}
		else if(size % 2 == 0)
		{
			mid = endOfBeg;
		}
		begOfEnd = mid.next;
		
		while (endOfEnd.next != null)
		{
			endOfEnd = endOfEnd.next;
		}
		
		root = begOfEnd;
		if(mid == endOfBeg)
		{
			endOfEnd.next = begOfBeg;
		}
		else if(mid != endOfBeg)
		{
			endOfEnd.next = mid;
		}
		mid.next = begOfBeg;
		endOfBeg = null;
	}
}



