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
			case 1:	edn="один";	break;
			case 2:	edn="два";  break;
			case 3:	edn="три";	break;
			case 4:	edn="четыре"; break;
			case 5:	edn="п€ть";	break;		
			case 6:	edn="шесть"; break;
			case 7:	edn="семь";	break;
			case 8:	edn="восемь"; break;
			case 9:	edn="дев€ть"; break;
			case 10: edn="дес€ть";	break;
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
		case 11: text="одиннадцать"; break;
		case 12: text="двенадцать";	break;
		case 13: text="тринадцать";	break;
		case 14: text="четырнадцать"; break;
		case 15: text="п€тнадцать";	break;
		case 16: text="шестнадцать"; break;
		case 17: text="семнадцать";	break;
		case 18: text="восемнадцать"; break;
		case 19: text="дев€тнадцать"; break;
		default: break;
		}
		return text;
	}

	public static String desf(int num) 
	{

		String text;
		switch(num%10)
		{
		case 1:	text="дес€ть";	break;
		case 2:	text="двадцать";  break;
		case 3:	text="тридцать";	break;
		case 4:	text="сорок"; break;
		case 5:	text="п€тдес€т";	break;		
		case 6:	text="шестдес€т"; break;
		case 7:	text="семдес€т";	break;
		case 8:	text="восемдес€т"; break;
		case 9:	text="дев€носто"; break;
		default: text=""; break;
		}
		return text;
	}

	public static String sotf(int num) 
	{
		String text;
		switch(num%10)
		{
		case 1:	text="сто";	break;
		case 2:	text="двести";  break;
		case 3:	text="триста";	break;
		case 4:	text="четыреста"; break;
		case 5:	text="п€тьсот";	break;		
		case 6:	text="шестсот"; break;
		case 7:	text="семсот";	break;
		case 8:	text="восемсот"; break;
		case 9:	text="дев€тсот"; break;
		default: text=""; break;
		}
		return text;
	}
}
