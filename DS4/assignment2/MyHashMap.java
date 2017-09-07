package assignment2;

public class MyHashMap<Integer, Guest> implements IMap<Integer, Guest>{
	private Object[] mapping;
	private int SIZE = 16;
	
	public MyHashMap(){
		this.SIZE = 16;
	}
	
	/**
	 * set HashMap size as number of rooms in the guest house
	 **/
	public void setSize(int size){
		this.SIZE = size;
		mapping = new Object[SIZE];
	}

	@Override
	public Object[] getMap(){
		return this.mapping;
	}
	
	@Override
	public boolean containsKey(int key) {
		if( mapping[key] != null ){
			return true;
		}
		return false;
	}

	@Override
	public Guest get(int key) {
		return (Guest)this.mapping[key];
	}

	@Override
	public boolean isEmpty() {
		return ( size() ==0 );
	}
	
	@Override
	public Guest put(Integer key, Guest value) {
		mapping[(int)key] = value;
		return value;
	}

	@Override
	public int size() {
		return this.SIZE;
	}
}
