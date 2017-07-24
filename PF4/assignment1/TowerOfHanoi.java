package assignment1;

import java.util.ArrayList;
import java.util.List;

/**Tower of Hanoi problem deals with transfering a plank of smaller size from source to destination
* using a temporary stack
* when only one peg can be moved at one time
* and larger peg cant be placed onto smaller peg
**/
public class TowerOfHanoi {
	/**@Method	towerOfHanoi(String source, String destination, String temp, int numOfDisk)
	* solution for moving 1 peg from source to destination
	* can be extended for some k pegs
	* which can be generalised for any number of pegs
	*/
	List<String> towerOfHanoi(String source, String destination, String temp, int numOfDisk){
		if(numOfDisk <= 0)
			throw new IllegalArgumentException();
		
		if(source == null | destination == null | temp == null)
			throw new NullPointerException();
		
		List<String> moves = new ArrayList<String>();
		
		//base condition to exit loop
		 if( numOfDisk == 1){
			moves.add("Move Disk 1 from "+source+" to "+destination);
			
			return moves;
		}
		
		// recursive addition of all steps to be moved to destination
		moves.addAll(towerOfHanoi(source, temp, destination, numOfDisk-1));
		moves.add("Move Disk "+numOfDisk+" from "+source+" to "+destination);
		moves.addAll(towerOfHanoi(temp, destination, temp, numOfDisk-1));
		
		return moves;
	}
	
	/** Testing for 1 additional peg when blocks are 3
	*/
	public static void main(String[] args){
		TowerOfHanoi t = new TowerOfHanoi();
		
		List<String> output = new ArrayList<String>();
		output = t.towerOfHanoi("A", "B", "C", 3); //Max List Size
		
		System.out.println("Number of moves: "+ output.size());
		for(int i=0; i< output.size(); i++){
			System.out.println(output.get(i));
		}
	}
}
