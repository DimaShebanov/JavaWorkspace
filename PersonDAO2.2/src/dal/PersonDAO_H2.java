package dal;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.google.gson.FieldNamingStrategy;

import blogic.Person;

public class PersonDAO_H2 implements PersonDAO
{

	@Override
	public void create(Person p)
	{
		Field[] flds = p.getClass().getDeclaredFields();
		int pid = 0;
		String pfname = "";
		String plname = "";
		int page = 0;
		try
		{
			for (Field field : flds)
			{
				if(field.getName().equals("id"))
				{
					field.setAccessible(true);
					pid = field.getInt(p);
				}
				else if(field.getName().equals("fname"))
				{
					field.setAccessible(true);
					pfname = (String) field.get(p);
				}
				else if(field.getName().equals("lname"))
				{
					field.setAccessible(true);
					plname = (String) field.get(p);
				}
				else if(field.getName().equals("age"))
				{
					field.setAccessible(true);
					page = field.getInt(p);
				}
			}
		}
		catch (IllegalArgumentException | IllegalAccessException e)
		{
			e.printStackTrace();
		}

		try 
		{
			Class.forName("org.h2.Driver");
			Connection con = DriverManager.getConnection("jdbc:h2:~/test","sa","");
			Statement st = con.createStatement();
			st.executeUpdate("insert into PERSON values("+pid+",'"+pfname+"', '"+ plname+"', " + page + ")");
			con.close();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Person> read()
	{
		ArrayList<Person> pp = new ArrayList<Person>();
		try 
		{
			Class.forName("org.h2.Driver");
			Connection con = DriverManager.getConnection("jdbc:h2:~/test","sa","");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM PERSON ");
			while( rs.next() )
			{
				pp.add(new Person(rs.getInt("ID"),rs.getString("FNAME"), rs.getString("LNAME"), rs.getInt("AGE")));
			}
			con.close();

		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		return pp;
	}

	@Override
	public void update(Person p) 
	{
		try 
		{
			Class.forName("org.h2.Driver");
			Connection con = DriverManager.getConnection("jdbc:h2:~/test","sa","");
			Statement st = con.createStatement();

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
			try
			{
				flds[indexOfId].setAccessible(true);
				flds[indexOfFname].setAccessible(true);

				if(!flds[indexOfFname].get(p).equals(""))
				{
					st.executeUpdate("UPDATE PERSON SET FNAME='" + (String) flds[indexOfFname].get(p) + "' WHERE ID="+ flds[indexOfId].getInt(p));
				}

				flds[indexOfLname].setAccessible(true);

				if(!flds[indexOfLname].get(p).equals(""))
				{
					st.executeUpdate("UPDATE PERSON SET LNAME='" + (String) flds[indexOfLname].get(p) + "' WHERE ID="+ flds[indexOfId].getInt(p));
				}

				flds[indexOfAge].setAccessible(true);

				if(flds[indexOfAge].getInt(p) != 0)
				{
					st.executeUpdate("UPDATE PERSON SET AGE='" + flds[indexOfAge].getInt(p) + "' WHERE ID="+ flds[indexOfId].getInt(p));
				}
			}
			catch (IllegalArgumentException | IllegalAccessException e)
			{
				e.printStackTrace();
			}
			con.close();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) 
	{
		try 
		{
			Class.forName("org.h2.Driver");
			Connection con = DriverManager.getConnection("jdbc:h2:~/test","sa","");
			Statement st = con.createStatement();
			st.executeUpdate("DELETE FROM PERSON WHERE ID="+id+";");
			con.close();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}


}
