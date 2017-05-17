import java.sql.SQLException;
import java.util.ArrayList;

public interface PersonDAO 
{
	void create(Person p) throws ClassNotFoundException, SQLException;
	ArrayList<Person> read() throws ClassNotFoundException, SQLException;
	void update(Person p) throws ClassNotFoundException, SQLException;
	void delete(int id) throws ClassNotFoundException, SQLException;
}
