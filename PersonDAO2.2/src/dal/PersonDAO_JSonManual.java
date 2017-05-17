package dal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
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
		Person p = new Person();
		try
		{
			Field Pid = p.getClass().getDeclaredField("id");
			Field Pfname = p.getClass().getDeclaredField("fname");
			Field Plname = p.getClass().getDeclaredField("fname");
			Field Page = p.getClass().getDeclaredField("age");
			Pid.setAccessible(true);
			Pfname.setAccessible(true);
			Plname.setAccessible(true);
			Page.setAccessible(true);
			
			
			
			for (Person per : pp) 
			{
				ret += "{";
				ret += "\"id\":" + Pid.getInt(per) + ",";
				ret += "\"fname\":\"" + Pfname.get(per) + "\",";
				ret += "\"lname\":\"" + Plname.get(per) + "\",";
				ret += "\"age\":" + Page.getInt(per);
				ret += "},";
			}
			ret = ret.substring(0, ret.length() - 1);
			ret += "]";
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		Field[] fields = p.getClass().getDeclaredFields();
		int indexOfId = 0;
		int indexOfFname = 0;
		int indexOfLname = 0;
		int indexOfAge = 0;
		for (int i = 0; i < fields.length; i++)
		{
			Field field = fields[i];
			if(field.getName().equalsIgnoreCase("id"))
			{
				indexOfId = i;
			}
			else if(field.getName().equalsIgnoreCase("fname"))
			{
				indexOfFname = i;
			}
			else if(field.getName().equalsIgnoreCase("lname"))
			{
				indexOfLname = i;
			}
			else if(field.getName().equalsIgnoreCase("age"))
			{
				indexOfAge = i;
			}
			field.setAccessible(true);

		}
		for (Person per : ret) 
		{
			try
			{
				if(fields[indexOfId].getInt(p) == fields[indexOfId].getInt(per))
				{
					fields[indexOfFname].set(per, fields[indexOfFname].get(p));
					fields[indexOfLname].set(per, fields[indexOfLname].get(p));
					fields[indexOfAge].set(per, fields[indexOfAge].getInt(p));
				}
			}
			catch (IllegalArgumentException | IllegalAccessException e)
			{
				e.printStackTrace();
			}
		}
		save(ret);
	}

	@Override
	public void delete(int id) 
	{
		ArrayList<Person> ret = new ArrayList<Person>();

		ret = read();
		Person ptodel = null;
		try
		{
			Field idField = new Person().getClass().getDeclaredField("id");
			idField.setAccessible(true);
			for (Person per : ret) 
			{
				if(idField.getInt(per) == id)
				{
					ptodel = per;
				}
			}
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e)
		{
			e.printStackTrace();
		}
		ret.remove(ptodel);
		save(ret);
	}
}
