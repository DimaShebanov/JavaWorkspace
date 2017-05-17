package dal;

import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import blogic.Person;

public class Person_DAOMySQL implements PersonDAO
{
	private final String url = "jdbc:mysql://localhost:3306/test";
	private final String username = "root";
	private final String password = "root";
	
	
	
	public Person_DAOMySQL()
	{
		
	}

	Connection con;
	Statement st;
	@Override
	public void create(Person p)
	{
		
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
