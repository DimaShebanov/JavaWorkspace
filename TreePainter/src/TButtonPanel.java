import java.awt.Button;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class TButtonPanel extends JPanel
{
	TCommand tc = null;
	Button btnDraw = null;
	
	JTextField txtvaladd = null;
	Button btnadd = null;
	
	JTextField txtvaldel = null;
	Button btndel = null;
	
	
	public TButtonPanel(TCommand tc)
	{
		setBounds(0, 0, 700, 30);
		setLayout(null);
		
		this.tc = tc;
		
		btnDraw = new Button("Draw Tree");
		btnDraw.setActionCommand("drawtree");
		btnDraw.setBounds(0, 0, 100, 30);
		btnDraw.addActionListener(tc.btnDrawList);
		add(btnDraw);
		
		txtvaladd = new JTextField();
		txtvaladd.setBounds(110, 0, 100, 30);
		add(txtvaladd);
		
		btnadd = new Button("Add value");
		btnadd.setActionCommand("addval");
		btnadd.setBounds(220, 0, 100, 30);
		btnadd.addActionListener(tc.btnAddList);
		add(btnadd);
		
		
		txtvaldel = new JTextField();
		txtvaldel.setBounds(330, 0, 100, 30);
		add(txtvaldel);
		
		btndel = new Button("Delete value");
		btndel.setBounds(440, 0, 100, 30);
		btndel.setActionCommand("delval");
		btndel.addActionListener(tc.btnDelList);
		add(btndel);
		
		setVisible(true);
		
	}


}
