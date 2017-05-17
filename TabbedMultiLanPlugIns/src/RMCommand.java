
import java.awt.Color;
import java.awt.Component;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class RMCommand
{
	public ActionTypeLst typelst;
	public ActionColorLst collst;
	public ActionWidthLst widthlst;
	public RMPanel rmp = null;
	public RMButtonPanel rmbt = null;
	ActionDelplugLst delCurPlugLst;
	public RMCommand(RMPanel rmp)
	{
		typelst = new ActionTypeLst();
		this.rmp = rmp;
		collst = new ActionColorLst();
		delCurPlugLst = new ActionDelplugLst();
		widthlst = new ActionWidthLst();
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

			try
			{
				if(e.getActionCommand() == "line")
				{
					rmp.data.type = null;
				}
				else if(fig == null)
				{
					rmp.data.type = (Plugin) Class.forName(e.getActionCommand()).newInstance();

				}

			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1)
			{
				e1.printStackTrace();
			}

		}
	}
	
	class ActionDelplugLst implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			for (Component co : rmbt.getComponents())
			{
				JButton jbtn = (JButton) co;
				if(jbtn.getActionCommand().equals("PluginOval"))
				{
					rmbt.remove(jbtn);
					rmbt.repaint();
				}
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
}

