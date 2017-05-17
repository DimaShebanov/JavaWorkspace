import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PButtonPanel extends JPanel
{
	JButton btnColorChoose;


	public PButtonPanel(PCommand cmd)
	{
		setBounds(500,0,300,600);
		setLayout(null);
		JButton btnBlue = new JButton("Blue");
		btnBlue.setActionCommand("blue");
		btnBlue.setBounds(0, 0, 75, 35);
		btnBlue.addActionListener(cmd.aClr);
		add(btnBlue);

		JButton btnRed = new JButton("Red");
		btnRed.setActionCommand("red");
		btnRed.setBounds(0, 40, 75, 35);
		btnRed.addActionListener(cmd.aClr);
		add(btnRed);


		JButton btnDefaultColor = new JButton("Default color");
		btnDefaultColor.setActionCommand("default");
		btnDefaultColor.setBounds(90, 40, 120, 35);
		btnDefaultColor.addActionListener(cmd.aClr);
		add(btnDefaultColor);


		JButton btnGreen = new JButton("Green");
		btnGreen.setActionCommand("green");
		btnGreen.setBounds(0, 80, 75, 35);
		btnGreen.addActionListener(cmd.aClr);
		add(btnGreen);

		JButton btnThinStroke = new JButton("Thin");
		btnThinStroke.setActionCommand("thin");
		btnThinStroke.setBounds(0, 140, 75, 35);
		btnThinStroke.addActionListener(cmd.aWdth);
		add(btnThinStroke);

		JButton btnMidStroke = new JButton("Middle");
		btnMidStroke.setActionCommand("middle");
		btnMidStroke.setBounds(0, 180, 75, 35);
		btnMidStroke.addActionListener(cmd.aWdth);
		add(btnMidStroke);

		
		JButton btnDefaultStroke = new JButton("Default stroke");
		btnDefaultStroke.setActionCommand("default");
		btnDefaultStroke.setBounds(90, 180, 120, 35);
		btnDefaultStroke.addActionListener(cmd.aWdth);
		add(btnDefaultStroke);

		JButton btnThickStroke = new JButton("Thick");
		btnThickStroke.setActionCommand("thick");
		btnThickStroke.setBounds(0, 220, 75, 35);
		btnThickStroke.addActionListener(cmd.aWdth);
		add(btnThickStroke);

		JButton btnSave = new JButton("Save");
		btnSave.setBounds(160, 270, 75, 35);
		btnSave.addActionListener(cmd.aSave);
		add(btnSave);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.setBounds(160, 320, 75, 35);
		btnLoad.addActionListener(cmd.aLoad);
		add(btnLoad);

		btnColorChoose = new JButton("Choose color");
		btnColorChoose.setBounds(90, 80, 120, 35);
		add(btnColorChoose);
		btnColorChoose.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				int tmp = cmd.data.clr;
				Color ntmp = JColorChooser.showDialog(((Component)e.getSource()).getParent(), "ggg", Color.BLACK);

				if(ntmp == null)
				{
					cmd.data.clr = tmp;
					return;
				}
				cmd.data.clr = ntmp.getRGB();
			}
		});





		JLabel lblStrokeChooser = new JLabel("Or choose your own stroke");
		lblStrokeChooser.setBounds(0, 260, 200, 20);
		add(lblStrokeChooser);

		JTextField txtStrokeChooser = new JTextField();
		txtStrokeChooser.setBounds(0, 280, 90, 20);
		add(txtStrokeChooser);

		JButton strokechooser = new JButton("Choose stroke");
		strokechooser.setBounds(0, 300, 120, 35);
		add(strokechooser);
		strokechooser.addActionListener(new ActionListener() 
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{

				if(txtStrokeChooser.getText().isEmpty())
				{
					return;
				}
				cmd.data.strk = Integer.parseInt(txtStrokeChooser.getText());
				txtStrokeChooser.setText("");
			}
		});

		PMenuType menutype = new PMenuType(cmd);
		add(menutype);

		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(160, 370, 75, 35);
		btnClear.setActionCommand("Clear");
		btnClear.addActionListener(cmd.aClear);
		add(btnClear);
		
		

	}
}
