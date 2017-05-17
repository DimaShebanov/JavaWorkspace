import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PCommand 
{
	PData data = null;

	PPanel pp = null;

	public PCommand()
	{
		data = new PData();
	}

	ActionColor aClr = new ActionColor();
	ActionWidth aWdth = new ActionWidth();
	ActionSave aSave = new ActionSave();
	ActionLoad aLoad = new ActionLoad();

	class ActionColor implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			String temp = e.getActionCommand();
			switch(temp)
			{
			case "blue": data.clr = Color.blue; break;
			case "red": data.clr = Color.red; break;
			case "yellow": data.clr = Color.yellow; break;
			default: data.clr = Color.black; break;
			}
		}
	}

	class ActionWidth implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			String temp = e.getActionCommand();
			switch(temp)
			{
			case "thin": data.strk = new BasicStroke(2); break;
			case "middle": data.strk = new BasicStroke(4); break;
			case "thick": data.strk =  new BasicStroke(6); break;
			default: data.strk =  new BasicStroke(1); break;
			}
		}
	}

	class ActionSave implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			try 
			{
				JFileChooser chooser = new JFileChooser();
				
				FileNameExtensionFilter filterjpg = new FileNameExtensionFilter("JPG Images", "jpg");
				FileNameExtensionFilter filtergif = new FileNameExtensionFilter("GIF Images", "gif");
				FileNameExtensionFilter filtertiff = new FileNameExtensionFilter("TIFF Images", "tiff");
				FileNameExtensionFilter filterpng = new FileNameExtensionFilter("PNG Images", "png");
				FileNameExtensionFilter filterbmp = new FileNameExtensionFilter("BMP Images", "BMP");
				
				chooser.setFileFilter(filterjpg);
				chooser.setFileFilter(filtergif);
				chooser.setFileFilter(filtertiff);
				chooser.setFileFilter(filterpng);
				chooser.setFileFilter(filterbmp);
				
				int returnVal = chooser.showSaveDialog(null);
				if(returnVal == JFileChooser.APPROVE_OPTION) 
				{
					ImageIO.write(pp.bi, "jpg", chooser.getSelectedFile() );
				}
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
		}
	}
	
	class ActionLoad implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			try 
			{
				JFileChooser chooser = new JFileChooser();
				
				FileNameExtensionFilter filterjpg = new FileNameExtensionFilter("JPG Images", "jpg");
				FileNameExtensionFilter filtergif = new FileNameExtensionFilter("GIF Images", "gif");
				FileNameExtensionFilter filtertiff = new FileNameExtensionFilter("TIFF Images", "tiff");
				FileNameExtensionFilter filterpng = new FileNameExtensionFilter("PNG Images", "png");
				FileNameExtensionFilter filterbmp = new FileNameExtensionFilter("BMP Images", "BMP");
				
				chooser.setFileFilter(filterjpg);
				chooser.setFileFilter(filtergif);
				chooser.setFileFilter(filtertiff);
				chooser.setFileFilter(filterpng);
				chooser.setFileFilter(filterbmp);
				int returnVal = chooser.showOpenDialog(null);
				if(returnVal == JFileChooser.APPROVE_OPTION) 
				{
					pp.bi = ImageIO.read( chooser.getSelectedFile() );
					pp.repaint();
				}
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
		}
	}
}
