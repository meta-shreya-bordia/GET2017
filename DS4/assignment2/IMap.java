package assignment2;

public interface IMap<E extends Object, T extends Object> {
	public boolean containsKey(Object arg0);
	public boolean containsValue(Object arg0);
	public T get(E arg0);
	public boolean isEmpty();
	public T put(E key, T value);
	public T remove(Object arg0);
	public int size();
}
