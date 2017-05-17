package Client;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CFrame extends JFrame
{
	public CFrame()
	{
		setBounds(100, 100, 500, 500);
		setLayout(null);
		DataModel dm = new DataModel();
		JTable table = new JTable(dm);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(0, 50, 400, 400);

		PButtonPanel pbtn = new PButtonPanel(dm);
		dm.pbtn = pbtn;
		add(pbtn);
		add(scroll);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
