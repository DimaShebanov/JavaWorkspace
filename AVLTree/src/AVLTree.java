

public class AVLTree extends BSTree
{
	AVLNode root = null;

	@Override
	public void add(int val)
	{
		if(root == null)
		{
			root = new AVLNode(val);
			return;
		}
		addAVLNode(root, val, root);	
	}

	private int addAVLNode(AVLNode p, int val, AVLNode parent)
	{
		if(p.val < val)
		{
			if(p.left == null)
			{
				p.left = new AVLNode(val);
			}
			else
			{
				p.bfactor += addAVLNode(p.left, val, p);
			}
		}
		else
		{
			if(p.right == null)
			{
				p.right = new AVLNode(val);
			}
			else
			{
				p.bfactor -= addAVLNode(p.right, val, p);
			}
		}
		if(p.bfactor > 1)
		{
			rotateLeft(p, parent);
		}
		return 1;
	}

	private void rotateLeft(AVLNode p, AVLNode parent)
	{
		if(parent != p)
		{
			AVLNode newHead = p.right;

			if(p == parent.left)
			{
				parent.left = newHead;
			}
			if(p == parent.right)
			{
				parent.right = newHead;
			}

			AVLNode tmp = newHead.left;
			newHead.left = tmp;
			p.right = tmp;
		}
		if(parent == root)
		{
			AVLNode newHead = p.right;

			root =  newHead;	
			AVLNode tmp = newHead.left;
			newHead.left = tmp;
			p.right = tmp;
		}
	}

	@Override
	public void del(int val)
	{

	}

	@Override
	public void init(int[] rr)
	{

	}

	class AVLNode extends BSTree.Node
	{
		int bfactor = 0;
		AVLNode left = null;
		AVLNode right = null;

		public AVLNode(int val)
		{
			super(val);
		}

	}

	public static void main(String[] args)
	{
		AVLTree tree = new AVLTree();
		tree.add(7);
		tree.add(10);
		tree.add(6);
		tree.add(5);
		tree.add(4);

		System.out.println("sd");
	}
}
