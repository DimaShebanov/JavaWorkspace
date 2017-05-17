
public class usloper_5 
{

	public static void main(String[] args) 
	{
			int mark=54;
			System.out.println(mark(mark));
	}	
	
	public static char mark(int mark) 
	{
		char m=' ';
		if(mark>=101||mark<=0) throw new IllegalArgumentException();
		if(mark>=1&mark<=19)	m='F';
		else if(mark>=20&mark<=39) m='E';
		else if(mark>=40&mark<=59) m='D';
		else if(mark>=60&mark<=74) m='C';
		else if(mark>=75&mark<=89) m='B';
		else if(mark>=90&mark<=100)m='A';
		return m;
	}

}
