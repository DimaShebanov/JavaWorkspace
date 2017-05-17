package Functions;

public class NumToText 
{

	public static void main(String[] args) 
	{
		int num=105;
		String numT=NumToText(num);
		System.out.println(numT);
	}

	public static String NumToText(int num) 
	{
		if(num<=0||num>=1000){throw new IllegalArgumentException();}
		String result="";
		String[] hundreds={"","���","������","������","���������","������","��������","������","��������","��������"};
		String[] desyatki={"","������","��������","��������","�����","���������","����������","��������","����������","���������"};
		String[] dodwadcati={"","����������","����������","����������","������������","����������","�����������","����������","������������","������������"};
		String[] edinici={"","����","���","���","������","����","�����","����","������","������"};
		int numtemp=num/10;
		if(num>99)
		{
			result=hundreds[num/100];
			result+=" ";
		}
		if(num%100>=11&&num%100<=19)
		{
			result+=dodwadcati[num%10];
		}
		else
		{
			if(numtemp%10!=0)
			{
				result+=desyatki[numtemp%10];
				if(numtemp%10!=1)
				{
					result+=" ";
				}
			}
			result+=edinici[num%10];
		}
		return result;
	}

}
