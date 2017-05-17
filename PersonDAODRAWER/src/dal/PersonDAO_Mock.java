package dal;
import java.util.ArrayList;

import blogic.Person;

public class PersonDAO_Mock implements PersonDAO
{
	ArrayList<Person> pp = new ArrayList<Person>();
	
	public PersonDAO_Mock()
	{
		pp.add( new Person(1, "Kolya", "Balkin", 62));
		pp.add( new Person(2, "Volya", "Valkin", 52));
		pp.add( new Person(3, "Qolya", "Galkin", 32));
		pp.add( new Person(4, "Zolya", "Zalkin", 12));
		pp.add( new Person(5, "Olya", "Pulkin", 23));
		pp.add( new Person(6, "Molya", "Bulkin", 2));
		pp.add( new Person(7, "Tolya", "Salkin", 21));
	}

	@Override
	public void create(Person p) 
	{
		pp.add(p);
	}

	@Override
	public ArrayList<Person> read() 
	{
		return pp;
	}

	@Override
	public void update(Person p) 
	{
		
		for (Person pi : pp) 
		{
			if(pi.id == p.id)
			{
				pi.fname = p.fname;
				pi.lname = p.lname;
				pi.age = p.age;
			}
		}
	}

	@Override
	public void delete(int id) 
	{
		for (Person p : pp) 
		{
			if(p.id == id)
			{
				pp.remove(p);
				break;
			}
		}
	}
	
	
}
