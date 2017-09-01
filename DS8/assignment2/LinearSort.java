package assignment2;

import java.util.List;

//WORST TIME COMPLEXITY: O(n2)
public abstract class LinearSort extends Sort{
	
	/**@Method	findLargest()
		//TRUE: RADIX SORT
		//FALSE: COUNTING SORT
	* find the largest number in the list
	**/
	//Worst Time: O(n)
	public static boolean hasLargeDigits(List<Integer> input) {
		for( Integer number : input ) {
			// break when number greater than 99 is found: break out of loop: choose Radix Sort
			if( number > 99 ) {
				return true;
			}
		}
		
		return false;
	}	

	/**@Method	find the max number in the list
	 * TIME: Theta(n)
	 * @return	type = int, return max number in list
	 **/
	protected int findMax(){
		int max = 0;
		for(int index =0; index < input.size(); index++){
			if( input.get(index) > max){
				max = input.get(index);
			}
		}
		return max;
	}
	
	/**@method	getMaxDigits(int maxNumber)
	 * repeated division by 10 to fid length of number
	 * @return	type = int, length of number
	 **/
	protected int getMaxDigits(int maxNumber){
		return (int)(Math.log10(maxNumber + 1));
	}
}
