
import java.sql.SQLException;
import java.util.ArrayList;

public class PMain 
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		PersonDAO pd = new PersonDAO_H2();
		ArrayList<Person> pp = pd.read();
		System.out.println("Beginning");
		for (Person p : pp) 
		{
			System.out.println(p);
		}
		System.out.println();
		
		
		
		System.out.println("Adding the new Person");
		Person nps = new Person(100, "Zina", "Lopukh", 33);
		pd.create(nps);
		pp = pd.read();
		
		for (Person p : pp) 
		{
			System.out.println(p);
		}
		System.out.println();
		
		
		
		System.out.println("Changing the existing person");
		Person pn = new Person(1, "Kizya", "Zuzya", 22);
		pd.update(pn);
		
		pp = pd.read();
		for (Person p : pp) 
		{
			System.out.println(p);
		}
		System.out.println();
		
		
		
		
		System.out.println("Deleting the person with id 5");
		pd.delete(5);
		
		pp = pd.read();
		for (Person p : pp) 
		{
			System.out.println(p);
		}
		System.out.println();
		
		
		
		
		System.out.println("Deleting the person that we added");
		pd.delete(nps.id);
		
		pp = pd.read();
		for (Person p : pp) 
		{
			System.out.println(p);
		}
		System.out.println();
		
		
		
		
		System.out.println("Adding a person that we deleted");
		pd.create(new Person(5, "Zuzya", "Moskin", 33));
		
		pp = pd.read();
		for (Person p : pp) 
		{
			System.out.println(p);
		}
		System.out.println();
		
		
		
		System.out.println("Changing back the person that we changed");
		pd.update(new Person(1, "Kolya", "Kipling", 43));
		
		pp = pd.read();
		for (Person p : pp) 
		{
			System.out.println(p);
		}
		System.out.println();
	}

}
