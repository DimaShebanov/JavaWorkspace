import java.util.ArrayList;

public interface DataBase
{
	public ArrayList<User> read();
	public void create(User user);
	public void update(User upduser);
	public void delete(String logintoDel);

}
