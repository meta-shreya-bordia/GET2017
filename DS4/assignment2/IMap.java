package assignment2;

public interface IMap<Integer, Guest> {
	public Object[] getMap();
	public boolean containsKey(int key);
	public Guest get(int key);
	public boolean isEmpty();
	public Guest put(Integer key, Guest value);
	public int size();
	public void setSize(int size);
}
