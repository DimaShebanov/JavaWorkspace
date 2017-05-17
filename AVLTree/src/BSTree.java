

public class BSTree implements Tree
{
	Node root = null;

	class Node
	{
		int val;
		Node left;
		Node right;

		public Node(int val)
		{
			this.val = val;
		}
	}

	public void add(int val)
	{
		if(root == null)
		{
			root = new Node(val);
			return;
		}
		addNode(root, val);
	}

	private void addNode(Node p, int val)
	{
		if(val < p.val)
		{
			if(p.left == null)
			{
				p.left = new Node(val);
			}
			else
			{
				addNode(p.left, val);
			}
		}
		else
		{
			if(p.right == null)
			{
				p.right = new Node(val);
			}
			else
			{
				addNode(p.right, val);
			}
		}	
	}

	public void clear()
	{
		root = null;
	}

	public void init(int[] rr) 
	{
		if(rr == null || rr.length <= 0)
		{
			return;
		}
		clear();
		for(int i = 0; i < rr.length; i++)
		{
			add(rr[i]);
		}

	}

	@Override
	public String toString()
	{
		if(root == null)
		{
			return "Nothing here!";
		}
		String str = "{" + toStr(this.root);

		str = str.substring(0, str.length() - 2);
		str += "}";
		return str;
	}

	private String toStr(Node p)
	{
		String str = "";
		if(p.left != null)
		{
			str += toStr(p.left);
		}
		str += p.val + ", ";
		if(p.right != null)
		{
			str += toStr(p.right);
		}
		return str;
	}

	@Override
	public int size() 
	{
		return getSize(root);
	}

	private int getSize(Node p) 
	{
		if(p == null)
		{
			return 0;
		}

		int size = 1;
		size +=	getSize(p.left);
		size += getSize(p.right);
		return size;
	}

	@Override
	public int nodes() 
	{	
		return getNodes(root);
	}

	private int getNodes(Node p) 
	{
		if(p == null || p.left == null && p.right == null)
		{
			return 0;
		}

		int nodes = 1;
		nodes += getNodes(p.left);
		nodes += getNodes(p.right);
		return nodes;
	}

	@Override
	public int leaves() 
	{
		return getLeaves(root);
	}

	private int getLeaves(Node p) 
	{
		if(p == null)
		{
			return 0;
		}
		int leaves = 0;
		if(p.left != null || p.right != null)
		{
			leaves = 0;
		}
		else
		{
			leaves = 1;
		}
		leaves += getLeaves(p.left);
		leaves += getLeaves(p.right);
		return leaves;
	}

	@Override
	public int height() 
	{
		int[] heightmax = {0};
		getHeight(root, 0, heightmax);
		return heightmax[0];
	}

	private int getHeight(Node p, int height, int[] heightmax) 
	{
		if(p == null)
		{
			return --height;
		}
		height++;
		getHeight(p.left, height, heightmax);
		if(p.left == null && p.right == null && height > heightmax[0])
		{
			heightmax[0] = height;
			height = 0;
		}
		getHeight(p.right, height, heightmax);

		return --height;
	}

	@Override
	public int width() 
	{
		int[] index = new int[height()];
		getWidth(root, index, 0);
		int maxWidth = 0;
		for (int i : index) 
		{
			if(maxWidth < i)
			{
				maxWidth = i;
			}
		}
		return maxWidth;
	}

	private void getWidth(Node p, int[] index, int level) 
	{
		if(p == null)
		{
			return;
		}
		index[level++]++;
		getWidth(p.left, index, level);
		getWidth(p.right, index, level);
	}

	@Override
	public void del(int val) 
	{
		if(root == null)
		{
			throw new IllegalArgumentException();
		}
		delVal(root, root ,val);


	}

	private void delVal(Node parent, Node p, int val) 
	{
		if(val < p.val)
		{
			delVal(p, p.left, val);
		}
		if(val > p.val)
		{
			delVal(p, p.right, val);
		}
		if(p.val == val)
		{
			if(p.right == null && p.left == null)
			{
				if(parent.left == p)
				{
					parent.left = null;
				}
				if(parent.right == p)
				{
					parent.right = null;
				}
			}
			else if(p.right == null)
			{
				if(p == root)
				{
					root = p.left;
				}
				if(parent.left == p)
				{
					parent.left = p.left;
				}
				if(parent.right == null)
				{
					parent.right = p.left;
				}
			}
			else if(p.left == null)
			{
				if(p == root)
				{
					root = p.right;
				}
				if(parent.left == p)
				{
					parent.left = p.left;
				}
				if(parent.right == p)
				{
					parent.right = p.left;
				}
			}
			if(p.right != null && p.left != null)
			{
				if(p.left.right == null)
				{
					if(p == root)
					{
						p.left.right = root.right;
						root = p.left;
					}
					if(parent.left == p)
					{
						parent.left = p.left;
						parent.left.right = p.right;
					}
					if(parent.right == p)
					{
						parent.right = p.left;
						parent.right.right = p.right;
					}
				}
				else
				{
					Node rec = findRec(p.left);
					if(p == root)
					{
						rec.left = root.left;
						rec.right = root.right;
						root = rec;
					}
					if(parent.left == p)
					{
						parent.left = rec;
						rec.left = p.left;
						rec.right = p.right;
					}
					if(parent.right == p)
					{
						parent.right = rec;
						rec.left = p.left;
						rec.right = p.right;
					}
				}
			}
		}

	}

	private Node findRec(Node p) 
	{
		if(p.right == null)
		{
			return p;
		}
		Node ret = null;
		if(p.right.right == null)
		{
			if(p.right.left != null)
			{
				ret = p.right;
				p.right = p.right.left;
			}
			else
			{
				ret = p.right;
				p.right = null;
			}
		}
		else
		{
			ret = findRec(p.right);
		}
		return ret;
	}

	@Override
	public int[] toArray() 
	{
		int[] arr = new int[size()];
		int[] counter = {0};
		getArr(root, counter, arr);
		return arr;
	}

	private void getArr(Node p, int[] counter, int[] arr) 
	{
		if(p == null)
		{
			return;
		}

		getArr(p.left, counter, arr);
		arr[counter[0]] = p.val;
		counter[0]++;
		getArr(p.right, counter, arr);
	}

	@Override
	public void reverse() 
	{
		// TODO Auto-generated method stub

	}


}
