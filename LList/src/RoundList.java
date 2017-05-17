
public class RoundList implements LList
{
	Node root = null;
	int size = 0;

	class Node
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
	public void init(int[] rr) 
	{
		if( rr == null || rr.length == 0)
		{
			return;
		}
		for(int i = rr.length - 1; i >= 0; i--)
		{
			addStart(rr[i]);
		}

	}

	@Override
	public int[] toArray() 
	{
		int[] rr = new int[size];
		Node tmp = root;
		for(int i = 0; i < size; i++)
		{
			rr[i] = tmp.val;
			tmp = tmp.next;
		}
		return rr;
	}

	@Override
	public int size() 
	{
		return size;
	}

	@Override
	public void clear() 
	{
		root = null;
		size = 0;
	}

	@Override
	public void addStart(int val) 
	{
		if(root == null)
		{
			root = new Node(val);
			root.next = root;
			root.prev = root;
			size = 1;
			return;
		}

		Node tmp = new Node(val);
		tmp.next = root;
		tmp.prev = root.prev;
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
		Node end = root.prev;
		Node tmp = new Node(val);
		tmp.prev = end;
		tmp.next = root;
		root.prev = tmp;
		end.next = tmp;
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
			return root.val;
		}
		if(pos == size - 1)
		{
			return root.prev.val;
		}
		Node tmp = root;
		for(int i = 0; i < pos; i++)
		{
			tmp = tmp.next;
		}
		return tmp.val;
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
			size = 0;
			return del;
		}

		Node end = root.prev;
		Node beforeEnd = end.prev;
		int del = end.val;
		beforeEnd.next = root;
		root.prev = beforeEnd;
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
			size = 0;
			return del;
		}
		int del = root.val;
		Node afterStart = root.next;
		Node end = root.prev;
		afterStart.prev = root.prev;
		root = afterStart;
		end.next = root;
		size--;
		return del;
	}

	public Node getNode(int pos) 
	{




		return null;
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
		int min = get(minPos);
		Node tmp = root;
		for(int i = 0; i < size; i++)
		{
			if(tmp.val < min)
			{
				minPos = i;
				min = tmp.val;
			}
			tmp = tmp.next;
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
		int max = get(maxPos);
		Node tmp = root;
		for(int i = 0; i < size; i++)
		{
			if(tmp.val > max)
			{
				maxPos = i;
				max = tmp.val;
			}
			tmp = tmp.next;
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
		if(size == 0 || pos >= size || pos < 0)
		{
			throw new IllegalArgumentException();
		}
		if(pos == 0)
		{
			root.val = val;
			return;
		}
		if(pos == size - 1)
		{
			root.prev.val = val;
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

		for(int i = 0; i < pos - 1; i++)
		{
			tmp = tmp.next;
		}

		Node tmpn = new Node(val);
		tmpn.next = tmp.next;
		tmp.next = tmpn;
		tmpn.prev = tmp;
		tmpn.next.prev = tmpn;
		size++;
	}

	@Override
	public String toString()
	{
		if(root == null)
		{
			return "Nothing here!";
		}
		String str = "{";
		Node tmp = root;
		for(int i = 0; i < size; i++)
		{
			if(i == size - 1)
			{
				str += tmp.val;
			}
			else
			{
				str += tmp.val + ", ";
			}
			tmp = tmp.next;
		}
		str += "}";
		return str;
	}


	@Override
	public int delPos(int pos) 
	{
		if(root == null || pos < 0 || pos >= size)
		{
			throw new IllegalArgumentException();
		}
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
		
		tmp.prev.next = tmp.next;
		tmp.next.prev = tmp.prev;		
		size--;
		return del;
	}

	@Override
	public void sort() 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void Reverse() 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void halfReverse() 
	{
		// TODO Auto-generated method stub

	}







}
