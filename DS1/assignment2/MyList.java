package assignment2;

public interface MyList<E extends Object>{
	
	public boolean add(E element);
	public void add(int index, E element);
	
	public E get(int index);
	public int indexOf(E element);
	
	public E remove(int index);
	public boolean remove(E element);
	public void clear();
	
	public void reverse();
	public void sort();
}
