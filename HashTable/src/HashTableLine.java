
public class HashTableLine
{
	Person[] arr = new Person[97];
	int size = 0;

	public void put(Person p)
	{
		int hash = p.hashCode();
		int index = hash % arr.length;
		if(arr[index] == null)
		{
			arr[index] = p;
		}
		else if(arr[index] != null)
		{
			while(arr[index] != null)
			{
				index++;
			}
			arr[index] = p;
		}
		size++;
	}

	public void init(Person[] pp)
	{
		clear();

		for (Person person : pp)
		{
			put(person);
		}
	}

	public Person get(int neededHash)
	{
		Person p = null;
		int index = neededHash % arr.length;
		if(arr[index].hashCode() == neededHash)
		{
			p = arr[index];
		}
		else
		{
			while(index < arr.length)
			{
				if(arr[index].hashCode() == neededHash)
				{
					p = arr[index];
					break;
				}
				index++;
			}
		}
		return p;
	}

	public Person del(int neededHash)
	{
		Person p = null;
		int index = neededHash % arr.length;
		if(arr[index].hashCode() == neededHash)
		{
			p = arr[index];
			arr[index] = null;
			size--;
		}
		else
		{
			while(index < arr.length)
			{
				if(arr[index].hashCode() == neededHash)
				{
					p = arr[index];
					arr[index] = null;
					size--;
					break;
				}
				index++;
			}
		}
		return p;
	}


	public void clear()
	{
		arr = new Person[97];
		size = 0;
	}

	public int size()
	{
		return size;
	}


	public Person[] toArray()
	{
		Person[] tmparr = new Person[size];
		int i = 0;
		for (Person person : arr)
		{
			if(person != null)
			{
				tmparr[i] = person;
				i++;
			}
		}


		return tmparr;
	}

	public static void main(String[] args)
	{
		Person p = new Person(1, "hadd", "wdww", 23);
		int ha = p.hashCode();
		Person pa = new Person();
		int haa = pa.hashCode();
		HashTableLine tbl = new HashTableLine();
		tbl.put(p);
		Person ppar = tbl.get(ha);

		Person[] init = {
				new Person(1, "ww", "2wea", 23),
				new Person(2, "2wa", "wdada", 233),
				new Person(3, "dwww", "wdas", 22)
				};
		tbl.init(init);
		Person[] res = tbl.toArray();
		for (Person person : res)
		{
			System.out.println(person);
		}




	}

}
