import java.awt.Color;
import java.awt.Graphics2D;

public class TPainter extends AVLTree
{
	public void draw(TPanel tp, int width)
	{
		Graphics2D gg = (Graphics2D) tp.bi.getGraphics();
		gg.fillRect(0, 0, 680, 600);
		drawTree(root, gg, 0, width, 1, 30);
		gg.setColor(Color.BLACK);
		gg.drawString("Width = " + width(), 0, 10);
		gg.drawString("Height = " + height(), 0, 25);
	}

	private void drawTree(AVLNode p, Graphics2D gg, int left, int right, int level, int dy) 
	{
		if(p == null)
		{
			return;
		}
		
		int mid = right - (right - left)/2;
		int ycoord = dy * level;
		
		if(p.left != null)
		{
			int nextmid = mid - (mid - left)/2;
			int nextycoord = dy * (level + 1);
			gg.setColor(Color.BLACK);
			gg.drawLine(mid, ycoord, nextmid, nextycoord);
		}
		if(p.right != null)
		{
			int nextmid = right - (right - mid)/2;
			int nextycoord = dy * (level + 1);
			gg.setColor(Color.BLACK);
			gg.drawLine(mid, ycoord, nextmid, nextycoord);
		}
		
		gg.setColor(Color.black);
		gg.fillOval(mid - 22, ycoord - 20, 30, 30);
		gg.setColor(Color.white);
		gg.drawString(p.val + "", mid - 18, ycoord);
		
		drawTree(p.left, gg, left, mid, level + 1, dy);
		drawTree(p.right, gg, mid, right, level + 1, dy);
		
	}
	
	
	
}
