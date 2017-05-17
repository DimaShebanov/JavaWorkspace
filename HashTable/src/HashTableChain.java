
public class HashTableChain
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
			arr[index].next = p;
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
		else if(arr[index].next != null)
		{
			p = arr[index].next;
			while(p.next != null)
			{
				if(p.hashCode() == neededHash)
				{
					break;
				}
				else
				{
					p = p.next;
				}
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
		}
		else if(arr[index].next != null)
		{
			p = arr[index].next;
			while(p.next != null)
			{
				if(p.hashCode() == neededHash)
				{
					delete(arr[index], p);
					break;
				}
				else
				{
					p = p.next;
				}
			}
		}
		return p;
	}


	private void delete(Person p, Person ptodel)
	{
		Person tmp = p;
		while(tmp.next != ptodel)
		{
			tmp = tmp.next;
		}
		tmp.next = ptodel.next;
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
				if (person.next != null)
				{
					Person tmp = person.next;
					while (tmp != null)
					{
						tmparr[i] = tmp;
						i++;
						
					}
				}
				tmparr[i] = person;
				i++;
			}
		}


		return tmparr;
	}

	public static void main(String[] args)
	{
		HashTableChain tbl = new HashTableChain();
		new Person(1, "wdw", "wda", 23);
//		Person[] init = {new Person(1, "ww", "2wea", 23),
//				new Person(2, "2wa", "wdada", 233),
//				new Person(3, "dwww", "wdas", 22)
//				};
//		tbl.init(init);
		Person[] res = tbl.toArray();
		for (Person person : res)
		{
			System.out.println(person);
		}
	}
}
