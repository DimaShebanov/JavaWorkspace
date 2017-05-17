import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Figure extends JPanel implements FocusListener
{
	int x;
	int y;
	int width;
	int height;
	int color;
	int stroke;
	ArrayList<Mark> marks = new ArrayList<>();

	private boolean isMarked;

	public Figure(int x, int y, int width, int height, int color, int stroke)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.stroke = stroke;


	}



	public void draw(Graphics2D gg)
	{

		gg.setColor(new Color(color));
		gg.setStroke(new BasicStroke(stroke));
		gg.fillRect(x, y, width, height);

		if(isMarked == true)
		{
			gg.setColor(Color.YELLOW);

			for (Mark mark : marks)
			{
				mark.put(gg);
			}

		}
	}



	public void putMarks()
	{
		isMarked = true;
		if(marks.isEmpty())
		{
			int size = (width + height) / 20;

			marks.add(new Mark(x, y, size));

			marks.add(new Mark(x + width / 2 - size / 2, y, size));

			marks.add(new Mark(x, y + height / 2 - size, size));

			marks.add(new Mark(x, y + height - size, size));

			marks.add(new Mark(x + width - size, y + height / 2 - size, size));

			marks.add(new Mark(x + width - size, y + height - size, size));

			marks.add(new Mark(x + width / 2 - size / 2, y + height - size , size));

			marks.add(new Mark(x + width - size , y , size));
		}
	}


	public void removeMarks()
	{
		isMarked = false;
		marks.clear();
	}

	class Mark
	{
		int x = 0;
		int y = 0;
		int size = 0;

		public Mark(int x, int y, int size)
		{
			this.x = x;
			this.y = y;
			this.size = size;
		}

		public void put(Graphics2D gg)
		{
			gg.fillRect(x, y, size, size);
		}
	}
	
	
	public void wider(int newx)
	{
		width = newx - x;
		setBounds(x, y, width, height);
	}
	
	
	public void longer(int newy)
	{
		height = newy - y;
		setBounds(x, y, width, height);

	}
	
	public void shorter(int newy)
	{
		height -= newy - y;
		y = newy;
		setBounds(x, y, width, height);

	}
	
	public void narrow(int newx)
	{
		width -= newx - x;
		x = newx;
		setBounds(x, y, width, height);

	}



	@Override
	public void focusGained(FocusEvent e)
	{
		putMarks();
	}



	@Override
	public void focusLost(FocusEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
}
