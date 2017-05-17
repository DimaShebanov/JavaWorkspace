import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Figure 
{
	int x0     = 0;
	int y0     = 0;
	int width  = 0;
	int height = 0;
	int type   = 0;
	int stroke = 0;
	int color  = Color.black.getRGB();

	public Figure(int x0, int y0, int width, int height, PData data) 
	{
		this.x0     = x0;
		this.y0     = y0;
		this.width  = width;
		this.height = height;
		this.type   = data.type;
		this.stroke = data.strk;
		this.color  = data.clr;
	}

	public Figure(int x0, int y0, int width, int height, int type, int stroke, int color) 
	{
		this.x0     = x0;
		this.y0     = y0;
		this.width  = width;
		this.height = height;
		this.type   = type;
		this.stroke = stroke;
		this.color  = color;
	}

	public void paint(Graphics2D gg)
	{
		gg.setColor(new Color(color));
		gg.setStroke(new BasicStroke(stroke));
		switch (type)
		{
			case 0: gg.drawLine(x0, y0, x0 + width, y0 + height);     break;
			case 1:	gg.drawRect(x0, y0, width, height); 			  break;
			case 2: gg.drawOval(x0, y0, width, height); 			  break;
			case 3: gg.drawRoundRect(x0, y0, width, height, 50, 50);  break;
			case 4: gg.fillRect(x0, y0, width, height); 			  break;
			case 5: gg.fillOval(x0, y0, width, height); 			  break;
			case 6: gg.fillRoundRect(x0, y0, width, height, 50, 50);  break;
			default: break;
		}
	}


	public String toJson()
	{
		String ret = ""; 
		ret += "{\"x0\":" + x0;
		ret += ",\"y0\":" + y0;
		ret += ",\"width\":" + width;
		ret += ",\"height\":" + height;
		ret += ",\"type\":" + type;
		ret += ",\"stroke\":" + stroke;
		ret += ",\"color\":" + color + "}";
		return ret;
	}

	public static ArrayList<Figure> fromJson(String src) 
	{
		ArrayList<Figure> ret = new ArrayList<Figure>();

		if(src.isEmpty())
		{
			return ret;
		}

		int x0     = 0;
		int y0     = 0;
		int width  = 0;
		int height = 0;
		int type   = 0;
		int stroke = 0;
		int color  = 0;
		boolean fullclass = false;



		StringTokenizer token = new StringTokenizer(src, "{}:\",");
		while(token.hasMoreTokens())
		{
			String name = token.nextToken();
			String val = token.nextToken();
			switch (name) 
			{
				case "x0":     x0 = Integer.parseInt(val);      				 break;
				case "y0":     y0 = Integer.parseInt(val);      				 break;
				case "width":  width = Integer.parseInt(val);   				 break;
				case "height": height = Integer.parseInt(val);   				 break;
				case "type":   type = Integer.parseInt(val);            	     break;
				case "stroke": stroke = Integer.parseInt(val);   				 break;
				case "color":  color = Integer.parseInt(val); fullclass = true;  break;
				default: 														 break;
			}
			if(fullclass)
			{
				ret.add(new Figure(x0, y0, width, height, type, stroke, color));
				fullclass = false;
			}
		}
		return ret;
	}

	public String toXML() 
	{
		String ret = "<Figure>";
		ret += "\t<x0>" + x0 + "</x0>";
		ret += "\t<y0>" + y0 + "</y0>";
		ret += "\t<width>" + width + "</width>";
		ret += "\t<height>" + height + "</height>";
		ret += "\t<type>" + type + "</type>";
		ret += "\t<stroke>" + stroke + "</stroke>";
		ret += "\t<color>" + color + "</color>";
		ret += "</Figure>";

		return ret;
	}

	public static ArrayList<Figure> fromXML(String src) 
	{
		ArrayList<Figure> ret = new ArrayList<Figure>();

		if(src.isEmpty())
		{
			return ret;
		}

		int x0     = 0;
		int y0     = 0;
		int width  = 0;
		int height = 0;
		int type   = 0;
		int stroke = 0;
		int color  = 0;
		boolean fullclass = false;


		String[] arr = src.split("(<|>|\\s)+");
		for (int i = 0; i < arr.length; i++)
		{
			String name = arr[i];
			if(name.contains("/") || name.equals("Figure"))
			{
				continue;
			}
			switch (name) 
			{
				case "x0":     x0 = Integer.parseInt(arr[i + 1]);						  break;
				case "y0":     y0 = Integer.parseInt(arr[i + 1]);	 					  break;
				case "width":  width = Integer.parseInt(arr[i + 1]);	 			  	  break;
				case "height": height = Integer.parseInt(arr[i + 1]); 					  break;
				case "type":   type = Integer.parseInt(arr[i + 1]);  					  break;
				case "stroke": stroke = Integer.parseInt(arr[i + 1]);                     break;
				case "color":  color = Integer.parseInt(arr[i + 1]); fullclass = true;    break;
				default:																  break;
			}
			if(fullclass)
			{
				ret.add(new Figure(x0, y0, width, height, type, stroke, color));
				fullclass = false;
			}
		}
		return ret;
	}



	public String toYAML() 
	{
		String ret = "Figure:";

		ret += "\tx0 : " + x0;
		ret += "\ty0 : " + y0;
		ret += "\twidth : " + width;
		ret += "\theight : " + height;
		ret += "\ttype : " + type;
		ret += "\tstroke : " + stroke;
		ret += "\tcolor : " + color + "\t";

		return ret;
	}

	public static ArrayList<Figure> fromYAML(String src) 
	{
		ArrayList<Figure> retur = new ArrayList<Figure>();

		if(src.isEmpty())
		{
			return retur;
		}

		int x0     = 0;
		int y0     = 0;
		int width  = 0;
		int height = 0;
		int type   = 0;
		int stroke = 0;
		int color  = 0;
		int counter = 0;
		boolean fullclass = false;

		src = src.trim();
		String[] res = src.split("(:|\\s)+");
		for (int i = 0; i < res.length; i++) 
		{
			String name = res[i];
			if(name.endsWith("Figure"))
			{
				continue;
			}
			switch (name) 
			{
				case "x0":     x0 = Integer.parseInt(res[i + 1]);       				  break;
				case "y0":     y0 = Integer.parseInt(res[i + 1]);       				  break;
				case "width":  width = Integer.parseInt(res[i + 1]);    				  break;
				case "height": height = Integer.parseInt(res[i + 1]);  					  break;
				case "type":   type = Integer.parseInt(res[i + 1]);     				  break;
				case "stroke": stroke = Integer.parseInt(res[i + 1]);   				  break;
				case "color":  color = Integer.parseInt(res[i + 1]); fullclass = true;    break;
				default:  																  break;
			}
			if(fullclass)
			{
				retur.add(new Figure(x0, y0, width, height, type, stroke, color));
				fullclass = false;
			}
		}
		return retur;
	}	
}
