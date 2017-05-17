package tests;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.plaf.basic.BasicLabelUI;

public class SPanel extends JPanel
{
	SPanel panel;
	ArrayList<BaloonPan> baloons = new ArrayList<BaloonPan>();
	int width;
	int height;
	
	public SPanel(int width, int height)
	{
		setBounds(0, 0, width, height);
		this.width = width;
		this.height = height;
		panel = this;

	
	}


	

}
