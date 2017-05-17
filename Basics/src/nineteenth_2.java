import java.util.Arrays;

public class nineteenth_2 {

	public static void main(String[] args) {
		int[] arr=new int[8];
		int min,mini=0,temp;
		for(int i=0;i<arr.length;i++)
		{
			min=arr[i];
			for (int j=i;j<arr.length;j++)
			{
				if(arr[j]<min)
				{
					min=arr[j];
					mini=j;
				}
				else
					continue;
			}
			if(mini!=i&&arr[i]!=min)
			{
			temp=arr[i];
			arr[i]=arr[mini];
			arr[mini]=temp;
			System.out.println((i+1)+"я итерация: "+Arrays.toString(arr));
			}
			else
			{
				continue;
			}
		}
		
	}

}
