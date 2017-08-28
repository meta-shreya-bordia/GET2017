package assignment1;

public interface IList<E extends Object>{
	public final int DEFAULT_SIZE = 10;
	
	public boolean add(E element);
	public void add(int index, E element);
	
	public E get(int index);
	public int indexOf(E element);
	
	public E remove(int index);
	public boolean remove(E element);
	public void clear();
	
	public void reverse();
	public <E extends Comparable<E>> void sort();
	
	public int size();
}
