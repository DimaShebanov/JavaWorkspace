package Functions;

import java.util.Arrays;

public class FunctionsTextToNum 
{

	public static void main(String[] args)
	{
		String text="���������� ���";
		int num=TextToNum(text);
		System.out.println(num);
	}
	
	public static int TextToNum(String text) 
	{
		String strNum="";
		String strtemp="";
		String[] t_num=text.split(" ");
		String[] hundreds={"","���","������","������","���������","������","��������","������","��������","��������"};
		String[] desyatki={"","������","��������","��������","�����","���������","����������","��������","����������","���������"};
		String[] dodwadcati={"","����������","����������","����������","������������","����������","�����������","����������","������������","������������"};
		String[] edinici={"","����","���","���","������","����","�����","����","������","������"};
		for(int i=0;i<t_num.length;i++)
		{
			for(int j=0;j<hundreds.length;j++)
			{
				if(t_num[i].equalsIgnoreCase(hundreds[j])==true)
				{
					strNum+=j;
					break;
				}
				else if(t_num[i].equalsIgnoreCase(dodwadcati[j])==true)
				{
					strNum+="1"+j;
					break;
				}
				else if(t_num[i].equalsIgnoreCase(desyatki[j])==true)
				{
					strNum+=j;
					break;
				}
				else if(t_num[i].equalsIgnoreCase(edinici[j])==true)
				{
					if(strNum.length()==1){strNum+="0";}
					strNum+=j;
					break;
				}
			}
		}
		if(t_num.length==strNum.length())
		{
			strNum+="0";
		}
		int num=Integer.parseInt(strNum);
		System.out.println(t_num.length);
		return num;
	}
	

}
