import java.util.ArrayList;

public class Users_Mock implements DataBase
{
	ArrayList<User> users = new ArrayList<>();

	public ArrayList<User> read()
	{
		ArrayList<User> tmp = new ArrayList<>();
		for (User user : users)
		{
			tmp.add(user);
		}
		return tmp;
	}

	public void create(User user)
	{
		if(user != null)
		{
			users.add(user);
		}
	}

	public void update(User upduser)
	{
		if(upduser != null)
		{
			for (User user : users)
			{
				if(!upduser.login.equals("") && !upduser.login.equals(user.login))
				{
					user.login = upduser.login;
				}
				if(!upduser.password.equals("") && !upduser.password.equals(user.password))
				{
					user.password = upduser.password;
				}
				break;
			}
		}
	}


	public void delete(String logintoDel)
	{
		for (User user : users)
		{
			if(user.login.equals(logintoDel))
			{
				users.remove(user);
				break;
			}
		}
	}


}
