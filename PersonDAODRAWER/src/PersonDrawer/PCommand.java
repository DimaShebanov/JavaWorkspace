package PersonDrawer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import blogic.Person;

public class PCommand 
{
	
	PData data = new PData();
	PButtonPanel pbtn;
	ActionCRUDListener listen = new ActionCRUDListener();
	PPanel ppan;
	
	public void draw(Graphics2D gg)
	{
		int x = 0;
		int y = 0;
		int dyfortext = 20;
		int dxfortext = 10;
		int height = 30;
		int idwidth = 50;
		int fnamewid = 200;
		int lnamewid = 200;
		int agewid = 50;

		gg.setColor(new Color(data.color));
		gg.setStroke(new BasicStroke(data.stroke));
		
		
		gg.drawRect(x, 0, idwidth, height);
		gg.drawString("ID", 20, y + dyfortext);
		
		x += idwidth;
		
		gg.drawRect(x, 0, fnamewid, height);
		gg.drawString("First name", 120, y + dyfortext);
		
		x += fnamewid;
		
		gg.drawRect(x, 0, lnamewid, height);
		gg.drawString("Last name", 320, y + dyfortext);
		
		x += lnamewid;
		
		gg.drawRect(x, 0, agewid, height);
		gg.drawString("Age", 465, y + dyfortext);
		
		x = 0;
		
		for (Person p : data.perslist) 
		{
			y += height;
			
			gg.drawRect(x, y, idwidth, height);
			gg.drawString(p.id + "", x + dxfortext, y + dyfortext);
			
			x += idwidth;
			
			gg.drawRect(x, y, fnamewid, height);
			gg.drawString(p.fname, x + dxfortext, y + dyfortext);
			
			x += fnamewid;
			
			gg.drawRect(x, y, lnamewid, height);
			gg.drawString(p.lname, x + dxfortext, y + dyfortext);
			
			x += lnamewid;
			
			gg.drawRect(x, y, agewid, height);
			gg.drawString(p.age + "", x + dxfortext, y + dyfortext);
			
			x = 0;
		}
		
	}
	
	
	class ActionCRUDListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			int id = Integer.parseInt(pbtn.txt_id_add.getText());
			String fname = pbtn.txt_fname_add.getText();
			String lname = pbtn.txt_lname_add.getText();
			int age = Integer.parseInt(pbtn.txt_age_add.getText());
			
			ppan.repaint();
		}
		
	}
	
	
}
