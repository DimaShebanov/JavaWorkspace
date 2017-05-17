package logic.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.MFigure;

public class FigureIO_JsonAuto implements FigureIO
{
	File file;
	public FigureIO_JsonAuto(File file)
	{
		this.file = file;
	}
	@Override
	public void save(ArrayList<MFigure> figs)
	{
		Gson json = new Gson();
		
		try
		{
			FileUtils.write(file, json.toJson(figs), "UTF-8");
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	@Override
	public ArrayList<MFigure> load()
	{
		Gson json = new Gson();
		ArrayList<MFigure> ret = new ArrayList<>();
		
		try
		{
			String str = FileUtils.readFileToString(file, "UTF-8");
			json.fromJson(str, new TypeToken<ArrayList<MFigure>>(){}.getType());
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return null;
	}
	
}
