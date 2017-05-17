
public class StringChanging 
{

	public static void main(String[] args) 
	{
		int theshortest=TheShortestWord("djiwaj dwad,w wfrvtbvyf,tbtgadsrgf,  sfgbdfh, drybdfyh");
		System.out.println(theshortest);

		String[] beforeDoll={"deadedg","rsvsdsss0","vosjr","rvdsinovoidr","uuuny","crrrrsrb","efsddd"};
		String dollars = SymbsToDoll(beforeDoll,5);
		System.out.println(dollars);

		String before = "edsf,evesv,sdfdgr,asefvsdv,svrdrgh,!SRGsrg";
		String after = Spaces(before);
		System.out.println(after);

		String bef = "dae wdewesc ecsr rrrfvr rSFDFvbk btib btirn v121e!#R$lbt";
		String aft = UniqueSymbs(bef);
		System.out.println(aft);

		String words = "          yhfh";
		int countOfWords = Words(words);
		System.out.println(countOfWords);

		String beforedelete = "cosnirs verpojvdr vdro vsrddd sdv;vrs";
		String afterdelete = Delete(beforedelete,2,7);
		System.out.println(afterdelete);


		String befreverse="qwertyuiopasdfghjklzxcvbnm1234567890";
		String aftreverse=Reverse(befreverse);
		System.out.println(befreverse);
		System.out.println(aftreverse);



		String withlastword = "lncselonsr drgvpojd drvft trvdtvio1 svdr";
		String withoutlastword = DeleteLastWord(withlastword);
		System.out.println(withoutlastword);
	}






	public static int TheShortestWord(String text) 
	{
		int lenght=3546;
		int counter=0;
		int textLenght=text.length();
		char space=' ';
		char comma=',';
		char dot='.';
		char vosklznak='!';
		char question='?';
		char at='@';
		char twodot=':';
		char commadot=';';
		char kavichka='\'';
		char kavichki='\"';
		for (int i=0;i<textLenght;i++)
		{
			char temp=text.charAt(i);
			if(temp==space||temp==comma||temp==dot||temp==vosklznak||temp==question||temp==at||temp==twodot||temp==commadot||temp==kavichka||temp==kavichki)
			{
				if(counter>0&&counter<=lenght)
				{
					lenght=counter;
					counter=0;
				}
			}
			else
			{
				counter++;
			}
		}

		return lenght;
	}

	public static String SymbsToDoll(String[] arr,int neededLenght) 
	{

		String ret="";
		int beforeleng=arr.length;
		if(neededLenght<3){throw new IllegalArgumentException();}
		for(int i=0;i<beforeleng;i++)
		{
			int wordlen=arr[i].length();
			if(wordlen==neededLenght)
			{
				arr[i]=arr[i].substring(0,wordlen-3)+"$$$";
			}
			if(i<1)
			{
				ret+=arr[i];
			}
			else
			{
				ret+=" "+arr[i];
			}
		}

		return ret;
	}

	public static String Spaces(String source) 
	{
		char comma=',';
		char dot='.';
		char vosklznak='!';
		char question='?';
		char at='@';
		char twodot=':';
		char commadot=';';
		char kavichka='\'';
		char kavichki='\"';
		String before=source;
		int beflen=before.length();
		for (int i=0;i<beflen;i++)
		{
			char temp=before.charAt(i);
			if(temp==comma||temp==dot||temp==vosklznak||temp==question||temp==at||temp==twodot||temp==commadot||temp==kavichka||temp==kavichki)
			{
				if(before.charAt(i+1)!=comma&&before.charAt(i+1)!=dot&&before.charAt(i+1)!=vosklznak&&before.charAt(i+1)!=question
						&&before.charAt(i+1)!=at&&before.charAt(i+1)!=twodot&&before.charAt(i+1)!=commadot&&before.charAt(i+1)!=kavichki)
				{
					if(before.charAt(i-1)!=' '&&before.charAt(i+1)!=' ')
					{
						before=before.substring(0, i+1)+" "+before.substring(i+1,before.length());
					}
				}
				else continue;
			}
		}





		return before;
	}

	public static String UniqueSymbs(String before) 
	{
		if(before==null)
		{
			throw new IllegalArgumentException();
		}
		if(before.equals(""))
		{
			return before;
		}
		String tempstr = before;
		char[] chars = tempstr.toCharArray();

		for(int i = 0;i < chars.length;i++)
		{
			for(int j = i+1;j < chars.length;j++)
			{
				if(chars[j] == chars[i])
				{
					chars[j] = ' ';
				}
			}
		}
		String res="";
		for(int i = 0;i < chars.length;i++)
		{
			if(chars[i]==' ')
			{
				continue;
			}
			res+=chars[i];
		}
		return res;
	}

	public static int Words (String text) 
	{
		if(text.length()<1)
		{
			return 0;
		}
		char space=' ';
		char comma=',';
		char dot='.';
		char vosklznak='!';
		char question='?';
		char at='@';
		char twodot=':';
		char commadot=';';
		char kavichka='\'';
		char kavichki='\"';
		int textlen=text.length();
		int counter=0;
		for(int i=1;i<textlen;i++)
		{
			char temp=text.charAt(i);
			if(temp==space||temp==comma||temp==dot||temp==vosklznak||temp==question||temp==at||temp==twodot||temp==commadot||temp==kavichka||temp==kavichki)
			{
				if(i==textlen-1)
				{
					if(text.charAt(i-1)!=space&&text.charAt(i-1)!=comma&&text.charAt(i-1)!=dot&&text.charAt(i-1)!=vosklznak&&text.charAt(i-1)!=question&&text.charAt(i-1)!=at
							&&text.charAt(i-1)!=twodot&&text.charAt(i-1)!=commadot&&text.charAt(i-1)!=kavichka&&text.charAt(i-1)!=kavichki)
					{
						counter++;
					}
					break;
				}
				if(text.charAt(i-1)!=space&&text.charAt(i-1)!=comma&&text.charAt(i-1)!=dot&&text.charAt(i-1)!=vosklznak&&text.charAt(i-1)!=question&&text.charAt(i-1)!=at
						&&text.charAt(i-1)!=twodot&&text.charAt(i-1)!=commadot&&text.charAt(i-1)!=kavichka&&text.charAt(i-1)!=kavichki)
				{
					counter++;
				}
			}
		}
		int Plusone=0;
		for(int i=1;i<textlen;i++)
		{
			char temp=text.charAt(i);
			if(temp!=space&&temp!=comma&&temp!=dot&&temp!=vosklznak&&temp!=question&&temp!=at&&temp!=twodot&&temp!=commadot&&temp!=kavichka&&temp!=kavichki)
			{
				Plusone=1;
			}
			else
			{
				Plusone=0;
			}
		}
		counter+=Plusone;
		return counter;

	}

	public static String Delete(String src,int pos, int length) 
	{
		if(pos+length>src.length())
		{
			throw new IllegalArgumentException();
		}
		String afterdel=src.substring(0, pos)+src.substring(pos+length, src.length());
		return afterdel;
	}

	public static String Reverse(String src) 
	{
		String res="";
		if(src.length()<2)
		{
			return src;
		}
		int srclen=src.length();
		for(int i=0;i<srclen;i++)
		{
			res+=src.charAt(srclen-i-1);
		}



		return res;
	}

	public static String DeleteLastWord(String src) 
	{
		src=src.trim();
		if(src.length()<0)
		{
			return src;
		}
		if(!src.contains(" "))
		{
			return src;
		}
		String res="";
		int pos=src.lastIndexOf(' ');
		res=src.substring(0, pos);
		return res;
	}



}





