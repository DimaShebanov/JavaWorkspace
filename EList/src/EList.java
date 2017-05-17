
public interface EList 
{
	public void addStart(int val);
	public void addEnd(int val);
	public int[] toArray();
	public int delEnd() ;
	public int delStart();
	public void clear();
	public void init(int[] rr);
	public int size();
	public String toString();
	public int get(int pos) ;
	public int minPos();
	public int maxPos();
	public int min() ;
	public int max() ;
	public void set(int newelem,int pos) ;
	public void addPos(int elem,int pos);
	public int delPos(int pos) ;
	public void sort() ;
	public void Reverse() ;
	public void halfReverse();
}
