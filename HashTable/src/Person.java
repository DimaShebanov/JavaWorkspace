

public class Person 
{
	public int id;
	public String fname;
	public String lname;
	public int age;
	Person next = null;

	public Person(int id, String fname, String lname, int age)
	{
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
	}
	
	public Person()
	{}
	
	@Override
	public String toString() 
	{
		return "Person [id=" + id + ", fname=" + fname + ", lname=" + lname + ", age=" + age + "]";
	}
	
	
	
	
	
}
