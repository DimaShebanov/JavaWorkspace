package dal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import blogic.Person;

public class PersonDAO_JSonManual implements PersonDAO
{
	File file = new File("PersonManual.json");

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

			write.write(tojson(pp));

			write.flush();		
			write.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public String tojson(ArrayList<Person> pp) 
	{
		String ret = "[";

		for (Person p : pp) 
		{
			ret += "{";
			ret += "\"id\":" + p.id + ",";
			ret += "\"fname\":\"" + p.fname + "\",";
			ret += "\"lname\":\"" + p.lname + "\",";
			ret += "\"age\":" + p.age;
			ret += "},";
		}
		ret = ret.substring(0, ret.length() - 1);
		ret += "]";
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
			ret = fromjson(src);
			read.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return ret;
	}

	public ArrayList<Person> fromjson(String src) 
	{
		int id 		 = 0;
		String fname = "";
		String lname = "";
		int age 	 = 0;
		boolean fullclass = false;
		ArrayList<Person> ret = new ArrayList<Person>();

		String[] srcarr = src.split("\\W+");
		

		for (int i = 0; i < srcarr.length; i++) 
		{
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
