import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;

public class MyButton extends JButton
{
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D gbtn = (Graphics2D) g;
		gbtn.setColor(Color.black);
		gbtn.drawRect(50, 10, 15, 15);
	}
}
