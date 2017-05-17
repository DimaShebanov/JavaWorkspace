package dal;
import java.lang.reflect.Field;
import java.util.ArrayList;

import blogic.Person;

public class PersonDAO_Mock implements PersonDAO
{
	public ArrayList<Person> pp = new ArrayList<Person>();

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
		Field[] flds = p.getClass().getDeclaredFields();
		int indexOfId = 0;
		int indexOfFname = 0;
		int indexOfLname = 0;
		int indexOfAge = 0;

		for (int i = 0; i < flds.length; i++)
		{
			if(flds[i].getName().equals("id"))
			{
				indexOfId = i;
			}
			else if(flds[i].getName().equals("fname"))
			{
				indexOfFname = i;
			}
			else if(flds[i].getName().equals("lname"))
			{
				indexOfLname = i;
			}
			else if(flds[i].getName().equals("age"))
			{
				indexOfAge = i;
			}
		}
		for (Person pi : pp) 
		{
			try
			{
				flds[indexOfId].setAccessible(true);

				if(flds[indexOfId].getInt(pi) == flds[indexOfId].getInt(p))
				{
					flds[indexOfFname].setAccessible(true);

					if(!flds[indexOfFname].get(p).equals(""))
					{
						flds[indexOfFname].set(pi , flds[indexOfFname].get(p));
					}

					flds[indexOfLname].setAccessible(true);
					if(!flds[indexOfLname].get(p).equals(""))
					{
						flds[indexOfLname].set(pi , flds[indexOfLname].get(p));
					}
					flds[indexOfAge].setAccessible(true);
					if(flds[indexOfAge].getInt(p) != 0)
					{
						flds[indexOfAge].set(pi , flds[indexOfAge].getInt(p));
					}

				}
			}
			catch (IllegalArgumentException | IllegalAccessException e)
			{
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(int id) 
	{
		Person pi = new Person();
		Field[] flds = pi.getClass().getDeclaredFields();
		int indexOfId = 0;

		for (int i = 0; i < flds.length; i++)
		{
			if(flds[i].getName().equals("id"))
			{
				indexOfId = i;
			}
		}
		for (Person p : pp) 
		{
			try
			{
				flds[indexOfId].setAccessible(true);
				if(id == flds[indexOfId].getInt(p))
				{
					pp.remove(p);
					break;
				}
			}
			catch (IllegalArgumentException | IllegalAccessException e)
			{
				e.printStackTrace();
			}
		}
	}


}
