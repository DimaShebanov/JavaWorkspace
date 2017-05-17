package PersonDrawer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PButtonPanel extends JPanel
{
	JLabel lbl_id_add;
	JTextField txt_id_add;

	JLabel lbl_fname_add;
	JTextField txt_fname_add;

	JLabel lbl_lname_add;
	JTextField txt_lname_add;

	JLabel lbl_age_add;
	JTextField txt_age_add;
	JButton btn_add_person;
	JButton btn_update_person;
	JButton btn_delete_person;
	JButton btn_read_person;



	public PButtonPanel(PCommand cmd) 
	{
		setBounds(0, 0, 700, 40);
		setLayout(null);


		lbl_id_add = new JLabel("ID:");
		lbl_id_add.setBounds(10, 0, 30, 20);

		txt_id_add = new JTextField();
		txt_id_add.setBounds(25, 0, 50, 20);

		lbl_fname_add = new JLabel("First name:");
		lbl_fname_add.setBounds(80, 0, 70, 20);

		txt_fname_add = new JTextField();
		txt_fname_add.setBounds(145, 0, 80, 20);

		lbl_lname_add = new JLabel("Last name:");
		lbl_lname_add.setBounds(230, 0, 70, 20);

		txt_lname_add = new JTextField();
		txt_lname_add.setBounds(295, 0, 80, 20);

		lbl_age_add = new JLabel("Age:");
		lbl_age_add.setBounds(380, 0, 30, 20);

		txt_age_add = new JTextField();
		txt_age_add.setBounds(407, 0, 50, 20);

		btn_add_person = new JButton("Create");
		btn_add_person.setBounds(0, 20, 80, 20);

		btn_update_person = new JButton("Update");
		btn_update_person.setBounds(80, 20, 80, 20);
		
		btn_delete_person = new JButton("Delete");
		btn_delete_person.setBounds(160, 20, 80, 20);
		
		btn_read_person = new JButton("Read");
		btn_read_person.setBounds(240, 20, 80, 20);


		add(lbl_id_add);
		add(txt_id_add);
		add(lbl_fname_add);
		add(txt_fname_add);
		add(lbl_lname_add);
		add(txt_lname_add);
		add(lbl_age_add);
		add(txt_age_add);
		add(btn_add_person);
		add(btn_read_person);
		add(btn_delete_person);
		add(btn_update_person);
		

	}
}


