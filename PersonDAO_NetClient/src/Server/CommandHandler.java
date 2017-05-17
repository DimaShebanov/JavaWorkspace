package Server;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import DataBases.Person;

public class CommandHandler
{
	DBConnection db;
	Gson json = new Gson();
	public CommandHandler(DBConnection db)
	{
		this.db = db;
	}
	
	public String handle(String mess)
	{
		String[] arr = mess.split(">");
		String result = "ok";
		switch(arr[0])
		{
			case "create" : create(arr[1]);  break;
			case "read" : result = json.toJson(read()); break;
			case "update" : update(arr[1]); break;
			case "delete" : delete(arr[1]); break;
			default: System.out.println(arr[0]);break;
		}
		return result;
	}

	private void delete(String string)
	{
		db.connection.delete(Integer.parseInt(string));
	}

	private void update(String string)
	{
		Person p = json.fromJson(string, new TypeToken<Person>() {}.getType());
		db.connection.update(p);
	}

	private ArrayList<Person> read()
	{
		return db.connection.read();
	}

	private void create(String string)
	{
		db.connection.create(json.fromJson(string, new TypeToken<Person>() {}.getType()));
	}
	
}
