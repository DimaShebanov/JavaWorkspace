import javax.swing.JButton;
import javax.swing.JPanel;

public class PButtonPanel extends JPanel
{
	public PButtonPanel(PCommand cmd)
	{
		setBounds(500,0,300,600);
		setLayout(null);
		JButton btn1 = new JButton("Blue");
		btn1.setActionCommand("blue");
		btn1.setBounds(0, 0, 75, 35);
		btn1.addActionListener(cmd.aClr);
		add(btn1);
		
		JButton btn2 = new JButton("Red");
		btn2.setActionCommand("red");
		btn2.setBounds(0, 40, 75, 35);
		btn2.addActionListener(cmd.aClr);
		add(btn2);
		
		
		JButton btndef = new JButton("Default color");
		btndef.setActionCommand("default");
		btndef.setBounds(90, 40, 120, 35);
		btndef.addActionListener(cmd.aClr);
		add(btndef);
		
		
		JButton btn3 = new JButton("Yellow");
		btn3.setActionCommand("yellow");
		btn3.setBounds(0, 80, 75, 35);
		btn3.addActionListener(cmd.aClr);
		add(btn3);
		
		JButton btnstrk1 = new JButton("Thin");
		btnstrk1.setActionCommand("thin");
		btnstrk1.setBounds(0, 140, 75, 35);
		btnstrk1.addActionListener(cmd.aWdth);
		add(btnstrk1);
		
		JButton btnstrk2 = new JButton("Middle");
		btnstrk2.setActionCommand("middle");
		btnstrk2.setBounds(0, 180, 75, 35);
		btnstrk2.addActionListener(cmd.aWdth);
		add(btnstrk2);
		
		
		JButton btndefstrk = new JButton("Default stroke");
		btndefstrk.setActionCommand("default");
		btndefstrk.setBounds(90, 180, 120, 35);
		btndefstrk.addActionListener(cmd.aWdth);
		add(btndefstrk);
		
		JButton btnstrk3 = new JButton("Thick");
		btnstrk3.setActionCommand("thick");
		btnstrk3.setBounds(0, 220, 75, 35);
		btnstrk3.addActionListener(cmd.aWdth);
		add(btnstrk3);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(0, 270, 75, 35);
		btnSave.addActionListener(cmd.aSave);
		add(btnSave);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.setBounds(0, 320, 75, 35);
		btnLoad.addActionListener(cmd.aLoad);
		add(btnLoad);
	}
}
