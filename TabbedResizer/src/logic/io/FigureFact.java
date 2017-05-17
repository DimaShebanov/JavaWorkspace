package logic.io;

import java.io.File;

public class FigureFact
{
	public static FigureIO getI(File file)
	{
		FigureIO ret = null;
		String type = file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf(".") + 1);
		
		switch(type)
		{
//			case "json": ret = new FigureIO_ToJson(file); 		break;
			case "json": ret = new FigureIO_JsonAuto(file); 	break;
			case "yml": ret = new FigureIO_YamlAuto(file); 		break;
			case "xml": ret = new FigureIO_XMLAuto(file); 		break;
			
			default: 											break;
		}
		
		
		return ret;
	}

}
