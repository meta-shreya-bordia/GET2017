package assignment4;

public interface IList<E extends Object> {
	public void add(int index, E element);
	
	public boolean remove(int index);
	public boolean remove(E element);
	
	public E get(int index);
	
	public void reverse();
	public void sort();
}
