import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PCommand 
{
	PPanel pp = null;

	PData data = null;
	public PCommand()
	{
		data = new PData();
	}

	ActionColor aClr = new ActionColor();
	ActionWidth aWdth = new ActionWidth();
	ActionType aType = new ActionType();
	ActionSave aSave = new ActionSave();
	ActionLoad aLoad = new ActionLoad();
	ActionClear aClear = new ActionClear();
	ActionSaveAsListener aSaveAs = new ActionSaveAsListener();
	
	class ActionClear implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			pp.AListLines.clear();
			pp.repaint();
		}
		
	}
	
	
	
	
	class ActionColor implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			switch (e.getActionCommand())
			{
			case "red": 
				data.clr = Color.red.getRGB();
				break;
			case "blue": 
				data.clr = Color.blue.getRGB();
				break;
			case "green": 
				data.clr = Color.green.getRGB();
				break;
			case "default": 
				data.clr = Color.BLACK.getRGB();
				break;
			default:
				break;
			}
		}

	}

	class ActionWidth implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			switch (e.getActionCommand())
			{
			case "thin": 
				data.strk = 4;
				break;
			case "middle": 
				data.strk = 6;
				break;
			case "thick": 
				data.strk = 8;
				break;
			case "default": 
				data.strk = 1;
				break;
			default:
				break;
			}
		}
	}
	
	class ActionType implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			switch(e.getActionCommand())
			{
			case "line": data.type = 0; break;
			case "rect": data.type = 1; break;
			case "oval": data.type = 2; break;
			case "rrect": data.type = 3; break;
			case"fillrect": data.type = 4; break;
			case "filloval": data.type = 5; break;
			case "fillrrect": data.type = 6; break;
			default: break;
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
				FileNameExtensionFilter filterjson = new FileNameExtensionFilter("JSon", "json");
				FileNameExtensionFilter filterxml = new FileNameExtensionFilter("XML", "xml");
				FileNameExtensionFilter filteryml = new FileNameExtensionFilter("YAML", "yml");
				
				chooser.setFileFilter(filterjson);
				chooser.setFileFilter(filterxml);
				chooser.setFileFilter(filteryml);
				
				int returnVal = chooser.showSaveDialog(null);
				if(returnVal == JFileChooser.APPROVE_OPTION) 
				{					
					File file = chooser.getSelectedFile();
					String filetype = file.getPath();
					filetype = filetype.substring(filetype.indexOf("."));
					BufferedWriter write = new BufferedWriter(new FileWriter(file));
					
					if(filetype.equals(".json"))
					{
						for (Figure f : pp.AListLines)
						{
							write.write(f.toJson());
						}
					}
					else if(filetype.equals(".xml"))
					{
						for (Figure f : pp.AListLines)
						{
							write.write(f.toXML());
						}
					}
					else if(filetype.equals(".yml"))
					{
						for (Figure f : pp.AListLines)
						{
							write.write(f.toYAML());
						}
					}
					write.flush();
					write.close();
				}
			} 
			catch (IOException  e1) 
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
				FileNameExtensionFilter filterjson = new FileNameExtensionFilter("JSon", "json");
				FileNameExtensionFilter filterxml = new FileNameExtensionFilter("XML", "xml");
				FileNameExtensionFilter filteryml = new FileNameExtensionFilter("YAML", "yml");
				
				chooser.setFileFilter(filterjson);
				chooser.setFileFilter(filterxml);
				chooser.setFileFilter(filteryml);
				
				int returnVal = chooser.showOpenDialog(null);
				if(returnVal == JFileChooser.APPROVE_OPTION) 
				{					
					File file = chooser.getSelectedFile();
					String filetype = file.getPath();
					
					BufferedReader read = new BufferedReader(new FileReader(file));
					String ret = read.readLine();
					
					if(filetype.contains(".yml"))
					{
						pp.AListLines = Figure.fromYAML(ret);
						pp.repaint();
					}
					else if(filetype.contains(".xml"))
					{
						pp.AListLines = Figure.fromXML(ret);
						pp.repaint();
					}
					else if(filetype.contains(".json"))
					{
						pp.AListLines = Figure.fromJson(ret);
						pp.repaint();
					}
					read.close();
				}
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
		}
	}

	class ActionSaveAsListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getActionCommand().equals("json"))
			{
				try 
				{
					JFileChooser chooser = new JFileChooser();
					FileNameExtensionFilter filterjson = new FileNameExtensionFilter("JSon", "json");
					chooser.setFileFilter(filterjson);
					int returnVal = chooser.showSaveDialog(null);
					if(returnVal == JFileChooser.APPROVE_OPTION) 
					{
						DataOutputStream out = new DataOutputStream( new FileOutputStream(chooser.getSelectedFile()) );
						for (Figure f : pp.AListLines)
						{
							out.writeUTF(f.toJson());
						}
						out.flush();
						out.close();
					}
				} 
				catch (IOException  e1) 
				{
					e1.printStackTrace();
				}
			}
			
			else if(e.getActionCommand().equals("xml"))
			{
				try 
				{
					JFileChooser chooser = new JFileChooser();
					FileNameExtensionFilter filterXML = new FileNameExtensionFilter("XML", "xml");
					chooser.setFileFilter(filterXML);
					int returnVal = chooser.showSaveDialog(null);
					if(returnVal == JFileChooser.APPROVE_OPTION) 
					{
						DataOutputStream out = new DataOutputStream( new FileOutputStream(chooser.getSelectedFile()) );
						for (Figure f : pp.AListLines)
						{
							out.writeUTF(f.toXML());
						}
						out.flush();
						out.close();
					}
				} 
				catch (IOException  e1) 
				{
					e1.printStackTrace();
				}
			}
			
			else if(e.getActionCommand().equals("yml"))
			{
				try 
				{
					JFileChooser chooser = new JFileChooser();
					FileNameExtensionFilter filterXML = new FileNameExtensionFilter("YAML", "yml");
					chooser.setFileFilter(filterXML);
					int returnVal = chooser.showSaveDialog(null);
					if(returnVal == JFileChooser.APPROVE_OPTION) 
					{
						DataOutputStream out = new DataOutputStream( new FileOutputStream(chooser.getSelectedFile()) );
						for (Figure f : pp.AListLines)
						{
							out.writeUTF(f.toYAML());
						}
						out.flush();
						out.close();
					}
				} 
				catch (IOException  e1) 
				{
					e1.printStackTrace();
				}
			}
		}
	}


}
