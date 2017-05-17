package dal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import blogic.Person;

public class Person_DAO_JSon_Auto implements PersonDAO
{
	Gson json = new Gson();
	File file = new File("PersonManual.json");





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
