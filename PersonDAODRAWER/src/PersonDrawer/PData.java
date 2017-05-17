package PersonDrawer;

import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;

import blogic.Person;
import dal.PersonDAO;

public class PData 
{
	int color = Color.black.getRGB();
	int stroke = 1;
	ArrayList<Person> perslist;
	PersonDAO person;
	public PData()
	{
		perslist = new ArrayList<Person>();
//		person = new PersonDAO_H2();
//		try 
//		{
//			perslist = person.read();
//		} 
//		catch (ClassNotFoundException | SQLException e) 
//		{
//			e.printStackTrace();
//		}
		
		perslist.add(new Person(1, "Vasya", "Basia", 22));
		perslist.add(new Person(2, "Masya", "Tasia", 82));
		perslist.add(new Person(3, "Qasya", "Zasia", 28));
		perslist.add(new Person(4, "Aasya", "Bada", 27));
		perslist.add(new Person(5, "Sasya", "Bdada", 38));
		perslist.add(new Person(6, "Dasya", "Bhttre", 52));
		perslist.add(new Person(7, "Qeasya", "Baooi", 72));
		perslist.add(new Person(8, "Wasya", "Baiva", 26));
		perslist.add(new Person(9, "Vazya", "Bapo", 38));
		perslist.add(new Person(10, "Vazaaa", "Boopo", 2));
	}
}
