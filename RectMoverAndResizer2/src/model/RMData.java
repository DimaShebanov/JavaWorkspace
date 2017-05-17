package model;
import java.awt.Color;

public class RMData
{
	public int stroke = 5;
	public int type = 3;
	public Color col = Color.black;
	
	
	public RMData(int stroke, int type, Color col)
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
