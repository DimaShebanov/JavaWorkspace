package GUI;

import dal.PersonDAO_Mock;
import dal.PersonDAO_XMLManual;

public class PMain 
{

	public static void main(String[] args) 
	{				
		System.out.println("dada");
		PersonDAO_Mock mock = new PersonDAO_Mock();
		PersonDAO_XMLManual xml = new PersonDAO_XMLManual();
		xml.save(mock.pp);
		//				new PFrame();
	}	
}
