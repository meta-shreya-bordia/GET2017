package assignment1;

public interface IList<E extends Object> {
	public void add(int index, E element);	
	public Node remove(int index);
	public E get(int index);
}
