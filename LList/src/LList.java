

public interface LList 
{
	public void init(int[] rr); 	
	public int[] toArray();	
	public int size();
	public void clear(); 	

	public String toString();
	public void addStart(int val);
	public void addEnd(int val); 	
	public int get(int pos);	
	public int delEnd(); 	
	public int delStart(); 	
	public int minPos();	
	public int maxPos(); 	
	public int min(); 	
	public int max(); 	
	public void set(int pos, int val); 
	public void addPos(int pos, int val); 
	public int delPos(int pos); 
	public void sort(); 
	public void Reverse(); 
	public void halfReverse();
}
