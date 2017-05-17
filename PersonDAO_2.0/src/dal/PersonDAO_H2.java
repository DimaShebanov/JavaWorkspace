package dal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import blogic.Person;

public class PersonDAO_H2 implements PersonDAO
{

	@Override
	public void create(Person p)
	{
		try 
		{
			Class.forName("org.h2.Driver");
			Connection con = DriverManager.getConnection("jdbc:h2:~/test","sa","");
			Statement st = con.createStatement();
			st.executeUpdate("insert into PERSON values("+p.id+",'"+p.fname+"', '"+ p.lname+"', " + p.age + ")");
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
			
			if(!p.fname.isEmpty())
			{
				st.executeUpdate("UPDATE PERSON SET FNAME='" + p.fname + "' WHERE ID="+ p.id);
			}
			
			if(!p.fname.isEmpty())
			{
				st.executeUpdate("UPDATE PERSON SET LNAME='" + p.lname + "' WHERE ID="+ p.id);
			}
			
			if(p.age > 0)
			{
				st.executeUpdate("UPDATE PERSON SET AGE="+ p.age +" WHERE ID="+ p.id);
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
