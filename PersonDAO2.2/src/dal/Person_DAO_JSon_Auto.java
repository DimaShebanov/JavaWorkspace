package dal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import blogic.Person;

public class Person_DAO_JSon_Auto implements PersonDAO
{
	Gson json = new Gson();
	File file = new File("Persons.json");





	@Override
	public void create(Person p) 
	{
		ArrayList<Person> per = read();
		if(per == null)
		{
			per = new ArrayList<Person>();
		}
		per.add(p);
		save(per);
	}


	public void save(ArrayList<Person> per) 
	{
		try 
		{
			BufferedWriter write = new BufferedWriter(new FileWriter(file));
			write.write(json.toJson(per));
			write.flush();
			write.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}


	@Override
	public ArrayList<Person> read() 
	{
		ArrayList<Person> ret = new ArrayList<Person>();

		try 
		{
			BufferedReader read = new BufferedReader(new FileReader(file));
			String src = read.readLine();
			ret = json.fromJson(src, new TypeToken<ArrayList<Person>>() {}.getType());
			read.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
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
