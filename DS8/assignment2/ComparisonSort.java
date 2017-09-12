package assignment2;

import java.util.*;

public abstract class ComparisonSort extends Sort{
	/** TRUE => QuickSort	FALSE => BubbleSort **/
	//Time: O(1)
	public static boolean largeSize(List<Integer> input) {
		if( input.size() <= 10 ) {
			return false;
		}
		
		return true;
	}
	
	/**Exponential time increase if method in parent class**/
	//Swap these elements
	protected void swap(int index1, int index2) {
		int swap = input.get(index1);
		
		input.set(index1, input.get(index2));
		input.set(index2, swap);
	}
}
