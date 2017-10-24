package assignment2;

public class Controller {
	IMap<Integer, Guest> roomAllotment;
	
	public Controller() {
		roomAllotment= new MyHashMap<Integer, Guest>();
	}
	
	public void setTotalNumberOfRooms(int totalNumberOfRooms){
		roomAllotment.setSize(totalNumberOfRooms);
	}
	
	/**@Method	isPrimeNumber(int n)
	 * check number of rooms is a prime number
	 * (Condition for hashing)
	 **/
	public boolean isPrimeNumber(int n){
		boolean flag = true;
		
		if( n == 2) {
			flag=true;
		}else if( n%2 == 0 ) {
			flag=false;
		}else {
			for(int i= 3;  i< Math.sqrt(n)+1; i=i+2 ) {
				if( n%i == 0) {
					flag=false;
					break;
				}
			}
		}
		return flag;
	}
	
	/**@Method	bookRoom(Guest addGuest)
	 * collision avoidance: by open addressing
	 * @return	type = int, selected room number
	 **/
	public int bookRoom(Guest addGuest){
		int roomNumber = hashFunction(addGuest.getGuestAge());
		
		while( roomAllotment.containsKey(roomNumber) ){
			roomNumber = hashFunction(roomNumber+1);
		}
		
		roomAllotment.put(roomNumber, addGuest);
		return roomNumber;
	}
	
	/**@Method	hashFunction
	 * The hash function is calculated by dividing age by number of rooms
	 * @return	type = int, hash calue computed
	 * Time complexity: O(1)
	 **/
	private int hashFunction(int key) {
		return ( key % roomAllotment.size() );
	}
	
	public Object[] getRoomDetails(){
		return roomAllotment.getMap();
	}
}
