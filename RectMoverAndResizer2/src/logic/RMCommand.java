package logic;
import java.awt.Color;
import java.awt.Component;
import java.awt.KeyboardFocusManager;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.google.gson.Gson;

import frame.Figure;
import frame.RMPanel;
import logic.io.FigureFact;
import logic.io.FigureIO_ToJson;

public class RMCommand
{
	RMPanel rmp = null;
	public ActionTypeLst typelst;
	public ActionColorLst collst;
	public ActionWidthLst widthlst;
	public Saver saverlst;
	public Loader loaderlst;
	public String str;
	FigureIO_ToJson json;
	public ActionColorChooser aclrChooser;
	public SlideChangeListener sldchangelst;


	public RMCommand(RMPanel rmp)
	{
		this.rmp = rmp;
		loaderlst = new Loader();
		typelst = new ActionTypeLst();
		saverlst = new Saver();
		collst = new ActionColorLst();
		widthlst = new ActionWidthLst();
		aclrChooser = new ActionColorChooser();
		sldchangelst = new SlideChangeListener();
	}

	class ActionTypeLst implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			Figure fig = null;

			Component comp = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();

			if(comp.getClass() == Figure.class)
			{
				fig = (Figure) comp;
			}


			if(fig == null)
			{
				rmp.data.type = Integer.parseInt(e.getActionCommand());
			}
			if(fig != null)
			{
				fig.data.type = Integer.parseInt(e.getActionCommand());
				fig.repaint();
			}
		}

	}

	class ActionColorLst implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			Figure fig = null;
			Component comp = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();

			if(comp.getClass() == Figure.class)
			{
				fig = (Figure) comp;
			}


			if(fig == null)
			{

				switch (e.getActionCommand())
				{
					case "yellow": 	rmp.data.col = Color.yellow; 	break;
					case "green": 	rmp.data.col = Color.green;	 	break;						 
					case "red": 	rmp.data.col = Color.red;		break;						 
					case "blue": 	rmp.data.col = Color.blue;		break;
					default:										break;
				}
			}
			if(fig != null)
			{
				switch (e.getActionCommand())
				{
					case "yellow": 	fig.data.col = Color.yellow; 	break;
					case "green": 	fig.data.col = Color.green;	 	break;						 
					case "red": 	fig.data.col = Color.red;		break;						 
					case "blue": 	fig.data.col = Color.blue;		break;
					default:										break;
				}

				fig.repaint();
			}
		}
	}

	class ActionWidthLst implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			Figure fig = null;

			Component comp = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();

			if(comp.getClass() == Figure.class)
			{
				fig = (Figure) comp;
			}


			if(fig == null)
			{
				rmp.data.stroke = Integer.parseInt(e.getActionCommand());
			}
			if(fig != null)
			{
				fig.data.stroke = Integer.parseInt(e.getActionCommand());
				fig.repaint();
			}
		}

	}

	class Saver implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filterjson = new FileNameExtensionFilter("JSsassson files (your saved pics)", "json");
			FileNameExtensionFilter filteryaml = new FileNameExtensionFilter("JSsassson files (your saved pics)", "yaml");
			FileNameExtensionFilter filterxml = new FileNameExtensionFilter("XML files (your saved pics)", "xml");
			
			chooser.addChoosableFileFilter(filterjson);
			chooser.addChoosableFileFilter(filteryaml);
			chooser.addChoosableFileFilter(filterxml);
			
			
			
			int returnVal = chooser.showSaveDialog((Component) e.getSource());
			if(returnVal == JFileChooser.APPROVE_OPTION) 
			{
				FigureFact.getI(chooser.getSelectedFile()).save(rmp.getMemento());;
			}
		}
	}



	class Loader implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filterjson = new FileNameExtensionFilter("JSon files (your saved pics)", "json");
			FileNameExtensionFilter filteryaml = new FileNameExtensionFilter("Yaml files (your saved pics)", "yaml");
			FileNameExtensionFilter filterxml = new FileNameExtensionFilter("XML files (your saved pics)", "xml");
			
			chooser.setFileFilter(filterjson);
			chooser.setFileFilter(filteryaml);
			chooser.setFileFilter(filterxml);
			
			int returnVal = chooser.showOpenDialog((Component) e.getSource());
			if(returnVal == JFileChooser.APPROVE_OPTION) 
			{
				rmp.setMemento(FigureFact.getI(chooser.getSelectedFile()).load());
			}
		}

	}


	class ActionColorChooser implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			Figure fig = null;

			if(KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner().getClass() == Figure.class)
			{
				fig = (Figure) KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
			}

			Color clr = JColorChooser.showDialog(rmp, "Choose your color", Color.BLACK);
			if(clr != null)
			{
				if(fig == null)
				{
					//					curCol.setBackground(clr);
					rmp.data.col = clr;
				}
				if(fig != null)
				{
					fig.data.col = clr;
				}
			}

			fig.repaint();
		}
	}

	class SlideChangeListener implements ChangeListener
	{
		@Override
		public void stateChanged(ChangeEvent e)
		{
			Figure fig = null;

			if(KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner().getClass() == Figure.class)
			{
				fig = (Figure) KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
			}

			JSlider slide = (JSlider) e.getSource();

			if(fig == null)
			{

				rmp.data.stroke = slide.getValue();
			}
			if(fig != null)
			{
				fig.data.stroke = slide.getValue();
				fig.repaint();
			}
		}
	}
}

