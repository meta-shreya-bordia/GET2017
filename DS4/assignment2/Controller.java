package assignment2;

public class Controller {
	IMap<Integer, Guest> roomAllotment;
	
	public Controller() {
		roomAllotment= new MyHashMap<Integer, Guest>();
	}
	
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
	
	public int allocateRoom(int guestAge) {
		// alocate by hashing with 
	}
}
