
import java.awt.Color;

public class RMData
{
	public int stroke = 5;
	public Plugin type = null;
	public Color col = Color.black;
	
	
	public RMData(int stroke, Plugin type, Color col)
	{
		this.stroke = stroke;
		this.type = type;
		this.col = col;
	}
	
	public RMData()
	{}
	
	public RMData dublicate()
	{
		return new RMData(stroke, type, col);
	}

	
}
