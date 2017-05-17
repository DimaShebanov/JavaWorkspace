package blogic;

public class Person 
{
	public int id;
	public String fname;
	public String lname;
	public int age;
	
	public Person(int id, String fname, String lname, int age)
	{
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
	}

	@Override
	public String toString() 
	{
		return "Person [id=" + id + ", fname=" + fname + ", lname=" + lname + ", age=" + age + "]";
	}
	
	
	
	
	
}
