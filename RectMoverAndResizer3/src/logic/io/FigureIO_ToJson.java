package logic.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

import model.MFigure;

public class FigureIO_ToJson implements FigureIO
{
	File file = null;
	
	public FigureIO_ToJson(File file)
	{
		this.file = file;
	}
	
	public String toJson(ArrayList<MFigure> figs)
	{
		String str = "{\"Figures\" : [";
		for (MFigure figure : figs)
		{
			str += " {";
			str += "\"x\" : " + figure.x + ", ";
			str += "\"y\" : " + figure.y + ", ";
			str += "\"width\" : " + figure.width + ", ";
			str += "\"height\" : " + figure.height + ", ";
			str += "\"stroke\" : " + figure.stroke + ", ";
			str += "\"type\" : " + figure.type + ", ";
			str += "\"color\" : " + figure.color;
			str += "},";
		}

		str = str.substring(0, str.length() - 1);
		str += "] }";
		return str;

	}
	
	
	public ArrayList<MFigure> fromJson(String src)
	{
		ArrayList<MFigure> figs = new ArrayList<>();
		boolean fullMFig = false;
		
		int x = 0;
		int y = 0;
		int width = 0;
		int height = 0;
		int type = 0;
		int stroke = 0;
		int color = 0;;
		
		MFigure mfig = null;		
		String[] strs = src.split("\\W+");
		
		for (int i = 0; i < strs.length ; i++)
		{
			
			switch (strs[i])
			{
				case "x": x = Integer.parseInt(strs[i + 1]); 									break;
				case "y": y = Integer.parseInt(strs[i + 1]); 									break;
				case "width": width = Integer.parseInt(strs[i + 1]); 							break;
				case "height": height = Integer.parseInt(strs[i + 1]); 							break;
				case "type": type = Integer.parseInt(strs[i + 1]); 								break;
				case "stroke": stroke = Integer.parseInt(strs[i + 1]); 							break;
				case "color": color = -Integer.parseInt(strs[i + 1]); fullMFig = true; 			break;
				default:																		break;
			}	
			
			if(fullMFig)
			{
				mfig = new MFigure();
				mfig.x = x;
				mfig.y = y;
				mfig.width = width;
				mfig.height = height;
				mfig.type = type;
				mfig.stroke = stroke;
				mfig.color = color;
				figs.add(mfig);
				fullMFig = false;
			}
		}
		
		
		return figs;
	}


	@Override
	public void save(ArrayList<MFigure> pp)
	{
		try
		{
			FileUtils.writeStringToFile(file, toJson(pp), "UTF-8");
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}


	@Override
	public ArrayList<MFigure> load()
	{
		String str = "";
		ArrayList<MFigure> figs = null;
		try
		{
			str = FileUtils.readFileToString(file, "UTF-8");
			figs = fromJson(str);
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return figs;
	}

}
