package Server;

import DataBases.PersonDAO;
import DataBases.PersonDAO_Mock;

public class DBConnection
{
	PersonDAO connection;
	public DBConnection()
	{
		connection = new PersonDAO_Mock();
	}
}
