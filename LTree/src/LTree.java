
public class LTree implements Tree
{
	Link root = new Link();
		
	
	@Override
	public void add(int val)
	{
		addNode(val, root);
	}

	private void addNode(int val, Link p)
	{
		if(p.node == null)
		{
			p.node = new Node(val);
			p.node.link = p;
			return;
		}
		if(val < p.node.val)
		{
			addNode(val, p.node.left);
		}
		else
		{
			addNode(val, p.node.right);
		}
	}


	@Override
	public void clear()
	{
		root.node = null;
	}

	@Override
	public void init(int[] rr)
	{
		for (int i : rr)
		{
			add(i);
		}
	}

	@Override
	public void print()
	{
		
	}

	@Override
	public int size()
	{
		return 0;
	}

	@Override
	public int nodes()
	{
		return 0;
	}

	@Override
	public int leaves()
	{
		return 0;
	}

	@Override
	public int height()
	{
		return 0;
	}

	@Override
	public int width()
	{
		return 0;
	}

	@Override
	public void del(int val)
	{
		
	}

	@Override
	public int[] toArray()
	{
		return null;
	}

	@Override
	public void reverse()
	{
		
	}
	
	
	@Override
	public String toString()
	{
		if(root == null)
		{
			return "Empty!";
		}
		String ret = "LTree {";
		
		ret += toLine(root);
		ret = ret.substring(0, ret.length() - 1);
		return ret + "}";
	}
	
	private String toLine(Link p)
	{
		String str = "";
		if(p.node == null)
		{
			return str;
		}

		str += toLine(p.node.left);
		str += p.node.val + ",";
		str += toLine(p.node.right);

		return str;
	}

	class Link
	{
		Node node = null;
	}
	
	class Node
	{
		Link left = null;
		Link right = null;
		Link link = null;
		int val = 0;
		
		public Node(int val)
		{
			this.val = val;
			left = new Link();
			right = new Link();
		}
	}
}
