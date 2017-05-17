package logic.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.yaml.snakeyaml.Yaml;

import model.MFigure;
import net.sourceforge.yamlbeans.YamlException;
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
			write.write(figs);
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
		// TODO Auto-generated method stub
		return null;
	}

}
