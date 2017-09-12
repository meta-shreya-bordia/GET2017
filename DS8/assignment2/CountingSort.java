package assignment2;

import java.util.*;

/**@Method	CountingSort
 * sorting on the basis of digit at position
 **/
public class CountingSort extends LinearSort{

	private int[] count;
	private Integer[] finalSort;
	
	public CountingSort() {
		
	}
	
	/**@Method	sort()
	 * Tradeoff between
	 * finding the largest number for which to compute index (TIME: O(n))
	 * (iterate over each element)
	 * vs
	 * (SPACE CONSTANT= O(99))
	 **/
	@Override
	public void sort() {
		count = new int[ findMax()+1 ];		//or find largest number in it
		finalSort = new Integer[input.size()];
		
		countingSort();
	}
	
	/**@Class	countingSort()
	 * count digit
	 * compute its hash for position
	 * move element to said position
	 * @return	type = void, returns sorted list
	 **/
	private void countingSort(){
		//find the count of each element 		
		for( int index = 0; index < input.size(); index++){
			count[input.get(index)] += 1;
		}
		
		//update count to find position of each element
		for(int counter = 1; counter < count.length; counter++){
			count[counter] += count[counter-1];
		}
		
        // Build the output character array
        for (int index = 0; index < finalSort.length ; index++){
            finalSort[count[input.get(index)] -1] = input.get(index);
            count[input.get(index)] -= 1;
        }
        
        this.input = Arrays.asList(finalSort);
	}
	
	public static void main(String[] args){
		CountingSort s = new CountingSort();
		
		for(int i= 5; i>=0; i--){
			s.add(i);
			s.add(i);
		}
		
		s.sort();
		
		System.out.println( s.getList() );
	}	
}