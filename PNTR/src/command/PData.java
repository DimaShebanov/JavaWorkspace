package command;

import java.awt.Color;

import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import view.FPanelDraw;

public class PData 
{
	Color color = Color.black;
	int width =3;
	JOptionPane optionPane=null;
	JSlider slider =null;

	FPanelDraw fPanelDraw = null;
	public PData(FPanelDraw fPanelDraw ) 
	{
		this.fPanelDraw=fPanelDraw;
		optionPane = new JOptionPane();
		slider = getSlider(optionPane);
	}
	public void SetType(int type)
	{
		System.out.println("SetType is work   " + type);
		if(fPanelDraw.moveSq!=null&&(type>0&&type<5))
		{
			fPanelDraw.moveSq.data.type = type;
			fPanelDraw.repaint();
		}
	}
	public void SetColor()
	{
		color = JColorChooser.showDialog(null, "ColorChooser", Color.black);
		if(fPanelDraw.moveSq!=null)
		{
			fPanelDraw.moveSq.data.color = color;
			fPanelDraw.repaint();
		}
		System.out.println("SetColor is work");
	}
	public void SetWidth()
	{
		optionPane.setMessage(new Object[] { "Select a value: ", slider });
		optionPane.setMessageType(JOptionPane.QUESTION_MESSAGE);
		optionPane.setOptionType(JOptionPane.OK_CANCEL_OPTION);
		JDialog dialog = optionPane.createDialog(null, "My Slider");
		dialog.setVisible(true);
		System.out.println("Input: " + optionPane.getInputValue());
		if(fPanelDraw.moveSq!=null)
		{
			fPanelDraw.moveSq.data.stroke =(int)optionPane.getInputValue();
			fPanelDraw.repaint();
		}
	}
	static JSlider getSlider(final JOptionPane optionPane) {
		JSlider slider = new JSlider();
		slider.setMajorTickSpacing(10);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		ChangeListener changeListener = new ChangeListener() {
			public void stateChanged(ChangeEvent changeEvent) {
				JSlider theSlider = (JSlider) changeEvent.getSource();
				if (!theSlider.getValueIsAdjusting()) {
					optionPane.setInputValue(new Integer(theSlider.getValue()));
				}
			}
		};
		slider.addChangeListener(changeListener);
		return slider;
	}
}
