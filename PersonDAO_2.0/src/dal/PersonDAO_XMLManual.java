package dal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import blogic.Person;

private class PersonDAO_XMLManual implements PersonDAO
{
	File file = new File("Person.xml");

	@Override
	public void create(Person p) 
	{
		ArrayList<Person> pp = new ArrayList<Person>();
		pp = read();

		pp.add(p);

		save(pp);
	}

	public void save(ArrayList<Person> pp) 
	{
		try 
		{
			BufferedWriter write = new BufferedWriter(new FileWriter(file));

			write.write(toXML(pp));

			write.flush();		
			write.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public String toXML(ArrayList<Person> pp) 
	{
		String ret = "<Persons>";
		
		for (Person p : pp) 
		{
			ret += "<Person>";
			ret += "<id>" + p.id + "</id>";
			ret += "<fname>" + p.fname + "</fname>";
			ret += "<lname>" + p.lname + "</lname>";
			ret += "<age>" + p.age + "</age>";
			ret += "</Person>";
		}
		
		
		ret += "</Persons>";
		return ret;
	}

	@Override
	public ArrayList<Person> read()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Person p) 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) 
	{
		// TODO Auto-generated method stub

	}

}
