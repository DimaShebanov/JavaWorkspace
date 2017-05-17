public class Nineteenth_test 
{

	public static void main(String[] args) 
	{
		int[] arr=new int[10];
		int temp;
		for(int i=0;i<arr.length;i++)
		{
			for(int b=0;b<arr.length-1;b++)
			{
				if(arr[b]>arr[b+1])
				{
					temp=arr[b];
					arr[b]=arr[b+1];
					arr[b+1]=temp;
				}
			}
		}
	}

}
