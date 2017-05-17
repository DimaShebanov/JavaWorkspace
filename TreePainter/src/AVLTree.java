

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
		addAVLNode(root, val);	
	}

	private int addAVLNode(AVLNode p, int val)
	{
		if(p.val < val)
		{
			if(p.right == null)
			{
				p.right = new AVLNode(val);
			}
			else
			{
				p.bfactor += addAVLNode(p.left, val);
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
				p.bfactor -= addAVLNode(p.right, val);
			}
		}
		System.out.println(p.bfactor);
		return 1;
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
		tree.add(4);
		tree.add(3);
		tree.add(8);
		tree.add(9);
		
		System.out.println("sd");
	}
}
