package logic.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import model.MFigure;

public class FigureIO_XMLAuto implements FigureIO
{
	public File file;

	public FigureIO_XMLAuto(File file)
	{
		this.file = file;
	}

	@Override
	public void save(ArrayList<MFigure> figs)
	{
		XStream xml = new XStream(new DomDriver());
		xml.alias("Figure", MFigure.class);
		try
		{
			FileUtils.writeStringToFile(file, xml.toXML(figs), "UTF-8");
			
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<MFigure> load()
	{
		ArrayList<MFigure> ret = null;
		XStream xml = new XStream(new DomDriver());
		xml.alias("Figure", MFigure.class);
		
		String str;
		try
		{
			str = FileUtils.readFileToString(file, "UTF-8");
			ret = (ArrayList<MFigure>) xml.fromXML(str);

		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return ret;
	}

}
