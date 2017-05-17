package logic.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.yaml.snakeyaml.Yaml;

import com.google.gson.reflect.TypeToken;

import model.MFigure;
import net.sourceforge.yamlbeans.YamlException;
import net.sourceforge.yamlbeans.YamlReader;
import net.sourceforge.yamlbeans.YamlWriter;

public class FigureIO_YamlAuto implements FigureIO
{
	File file;

	public FigureIO_YamlAuto(File file)
	{
		this.file = file;
	}

	@Override
	public void save(ArrayList<MFigure> figs)
	{
		try
		{
			YamlWriter write = new YamlWriter(new FileWriter(file));
			write.getConfig().setClassTag("Figure", MFigure.class);
			
			for (MFigure mfig : figs)
			{
				write.write(mfig);
			}
			write.close();
			
		} 
		catch (IOException | YamlException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<MFigure> load()
	{
		ArrayList<MFigure> figs = new ArrayList<>();
		MFigure fig = null;

		try
		{
			YamlReader read = new YamlReader(new FileReader(file));
			read.getConfig().setClassTag("Figure", MFigure.class);

			while(true)
			{
				fig = (MFigure) read.read();
				if(fig == null)
				{
					break;
				}
				figs.add(fig);
			}
		} 
		catch (FileNotFoundException | YamlException e)
		{
			e.printStackTrace();
		}
		
		return figs;
	}

}
