package assignment1;

import java.util.ArrayList;
import java.util.List;

public class TowerOfHanoi {

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
		 
		moves.addAll(towerOfHanoi(source, temp, destination, numOfDisk-1));
		moves.add("Move Disk "+numOfDisk+" from "+source+" to "+destination);
		moves.addAll(towerOfHanoi(temp, destination, temp, numOfDisk-1));
		
		return moves;
	}
	
	public static void main(String[] args){
		TowerOfHanoi t = new TowerOfHanoi();
		
		List<String> output = new ArrayList<String>();
		output = t.towerOfHanoi("A", "B", "C", 3); //Max List Size
		
		System.out.println("Number of moves: "+ output.size());
		for(int i=0; i< output.size(); i++){
			System.out.println(output.get(i));
		}
		
		/**output = t.towerOfHanoi("A", "B", "C", 12); //Overrides strings
		
		System.out.println("Number of moves: "+ output.size());
		for(int i=0; i< output.size(); i++){
			System.out.println(output.get(i));
		}**/
	}
}
