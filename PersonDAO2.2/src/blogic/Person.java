package blogic;

public class Person 
{
	private int id;
	private String fname;
	private String lname;
	private int age;

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
