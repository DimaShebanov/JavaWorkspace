package model;

public class MFigure
{
	public int x = 0;
	public int y = 0;
	public int width = 0;
	public int height = 0;
	public int type = 0;
	public int stroke = 0;
	public int color = 0;
	public int number;



	public boolean equal(MFigure fig)
	{
		boolean ret = false;

		if(		this.x == fig.x &&
				this.y == fig.y &&
				this.width == fig.width &&
				this.height == fig.height &&
				this.type == fig.type &&
				this.stroke == fig.stroke &&
				this.color == fig.color &&
				this.number == fig.number)
		{
			ret = true;
		}

		return ret;
	}
}