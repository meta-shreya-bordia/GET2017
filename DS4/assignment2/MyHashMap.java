package assignment2;

public class MyHashMap<E extends Object, T extends Object> implements IMap<E, T>{
	private Object[] mapping;
	private int SIZE = 16;
	
	public MyHashMap(){
		this.SIZE = 16;
	}
	
	public MyHashMap(int numberOfRooms){
		this.SIZE = numberOfRooms;
	}

	/**
	 * The java HashMap implementation takes default size = 16
	 * and has initial load factor = 0.75 ( number of keys/ size of hash table)
	 * .'. initially number of rooms = 12
	 **/
	// maintain load factor = 0.75
	private int hashingFunction(int key) {
		return (key%SIZE);
	}
	
	//should be O(1)
	//currently: O(n)
	@Override
	public boolean containsKey(int key) {
		for(Object map: mapping){
			if(map.equals()){
				return true;
			}
		}
		return false;
	}

	//Framework implementation: O(1)
	//current time: O(n)
	@Override
	public boolean containsValue(T value) {
		for(Object map: mapping){
			if(value.equals(map)){
				return true;
			}
		}
		return false;
	}

	@Override
	public T get(E arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		return ( size() ==0);
	}

	@Override
	public T put(E key, T value) {
		int hashKey = hashingFunction((int)key);
		
	}

	@Override
	public int size() {
		return this.SIZE;
	}
}
