import javax.swing.JOptionPane;

public class Func_2 {



	public static void main(String[] args) 
	{
		int num=Integer.parseInt(JOptionPane.showInputDialog("Input a number"));
		String numbert=number(num);
		System.out.println(numbert);

	}

	public static String number(int num)
	{
		int num_i=num;
		int num_prov=num;
		String edn="";
		String text;
		String des;
		String sot;
		if(num_prov%100>=20||num_prov%100==0)
		{
			switch(num_i%10)
			{
			case 1:	edn="����";	break;
			case 2:	edn="���";  break;
			case 3:	edn="���";	break;
			case 4:	edn="������"; break;
			case 5:	edn="����";	break;		
			case 6:	edn="�����"; break;
			case 7:	edn="����";	break;
			case 8:	edn="������"; break;
			case 9:	edn="������"; break;
			case 10: edn="������";	break;
			default: edn=" "; break;
			}
		}
		else if(num_prov%100==10)
		{
			des=elevenf(num_i);
		}

		num_i=num_i/10;
		des=desf(num_i);
		num_i=num_i/10;
		sot=sotf(num_i);
		text=sot+" "+des+" "+edn;
		return text;
	}

	public static String elevenf(int num) 
	{
		String text=" ";
		switch(num%100)
		{
		case 11: text="�����������"; break;
		case 12: text="����������";	break;
		case 13: text="����������";	break;
		case 14: text="������������"; break;
		case 15: text="����������";	break;
		case 16: text="�����������"; break;
		case 17: text="����������";	break;
		case 18: text="������������"; break;
		case 19: text="������������"; break;
		default: break;
		}
		return text;
	}

	public static String desf(int num) 
	{

		String text;
		switch(num%10)
		{
		case 1:	text="������";	break;
		case 2:	text="��������";  break;
		case 3:	text="��������";	break;
		case 4:	text="�����"; break;
		case 5:	text="��������";	break;		
		case 6:	text="���������"; break;
		case 7:	text="��������";	break;
		case 8:	text="����������"; break;
		case 9:	text="���������"; break;
		default: text=""; break;
		}
		return text;
	}

	public static String sotf(int num) 
	{
		String text;
		switch(num%10)
		{
		case 1:	text="���";	break;
		case 2:	text="������";  break;
		case 3:	text="������";	break;
		case 4:	text="���������"; break;
		case 5:	text="�������";	break;		
		case 6:	text="�������"; break;
		case 7:	text="������";	break;
		case 8:	text="��������"; break;
		case 9:	text="��������"; break;
		default: text=""; break;
		}
		return text;
	}
}
