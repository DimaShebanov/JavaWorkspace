import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonDAO_H2 implements PersonDAO
{

	@Override
	public void create(Person p) throws ClassNotFoundException, SQLException 
	{
		Class.forName("org.h2.Driver");
		Connection con = DriverManager.getConnection("jdbc:h2:~/test","sa","");
		Statement st = con.createStatement();
		st.executeUpdate("insert into PERSON values("+p.id+",'"+p.fname+"', '"+ p.lname+"', " + p.age + ")");
	}

	@Override
	public ArrayList<Person> read() throws ClassNotFoundException, SQLException 
	{
		Class.forName("org.h2.Driver");
		Connection con = DriverManager.getConnection("jdbc:h2:~/test","sa","");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM PERSON ");
		ArrayList<Person> pp = new ArrayList<Person>();
		while( rs.next() )
		{
			pp.add(new Person(rs.getInt("ID"),rs.getString("FNAME"), rs.getString("LNAME"), rs.getInt("AGE")));
		}
		con.close();
		return pp;
	}

	@Override
	public void update(Person p) throws ClassNotFoundException, SQLException 
	{
		Class.forName("org.h2.Driver");
		Connection con = DriverManager.getConnection("jdbc:h2:~/test","sa","");
		Statement st = con.createStatement();
		st.executeUpdate("UPDATE PERSON SET FNAME='" + p.fname + "' WHERE ID="+ p.id);
		st.executeUpdate("UPDATE PERSON SET LNAME='" + p.lname + "' WHERE ID="+ p.id);
		st.executeUpdate("UPDATE PERSON SET AGE="+ p.age +" WHERE ID="+ p.id);
	}

	@Override
	public void delete(int id) throws SQLException, ClassNotFoundException 
	{
		Class.forName("org.h2.Driver");
		Connection con = DriverManager.getConnection("jdbc:h2:~/test","sa","");
		Statement st = con.createStatement();
		st.executeUpdate("DELETE FROM PERSON WHERE ID="+id+";");
	}


}
