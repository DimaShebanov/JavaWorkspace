package dal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import blogic.Person;

public class PersonDAO_XMLManual implements PersonDAO
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
		ArrayList<Person> ret = new ArrayList<Person>();

		try 
		{
			BufferedReader read = new BufferedReader(new FileReader(file));
			String src = read.readLine();

			ret = fromXML(src);

			read.close();

		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return ret;
	}

	public ArrayList<Person> fromXML(String src) 
	{
		int id 		 = 0;
		String fname = "";
		String lname = "";
		int age 	 = 0;
		boolean fullclass = false;
		ArrayList<Person> ret = new ArrayList<Person>();

		String[] srcarr = src.split("(<|>|Persons)+");
		for (int i = 0; i < srcarr.length; i++) 
		{
			if(srcarr[i].contains("/"))
				continue;

			switch (srcarr[i]) 
			{
				case "id": id = Integer.parseInt(srcarr[i + 1]); 					 break;
				case "fname": fname = srcarr[i + 1];				 				 break;
				case "lname": lname = srcarr[i + 1];								 break;
				case "age": age = Integer.parseInt(srcarr[i + 1]); fullclass = true; break;
				default:															 break;
			}

			if(fullclass)
			{
				ret.add(new Person(id, fname, lname, age));
				fullclass = false;
			}
		}
		return ret;
	}

	@Override
	public void update(Person p) 
	{
		ArrayList<Person> ret = new ArrayList<Person>();

		ret = read();

		for (Person per : ret) 
		{
			if(p.id == per.id)
			{
				per.fname = p.fname;
				per.lname = p.lname;
				per.age = p.age;
			}
		}
		save(ret);
		
	}

	@Override
	public void delete(int id) 
	{
		ArrayList<Person> ret = new ArrayList<Person>();

		ret = read();

		for (Person per : ret) 
		{
			if(id == per.id)
			{
				ret.remove(per);
				break;
			}
		}
		save(ret);
	}

}
