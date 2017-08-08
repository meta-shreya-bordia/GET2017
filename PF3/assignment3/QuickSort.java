package assignment3;

public class QuickSort {
	
	/**
	 * @Method	quickSort(int[] input)
	 * sorts input array by selecting a pivot element and diving the array into subarrays
	 * @param	input array that contains unsorted elements
	 * @return	type = void, sorts the input array
	 * */
	public void quickSort(int[] input) {
		if(input == null)
			throw new NullPointerException();
		
		if(input.length <= 0)
			throw new NegativeArraySizeException();
		
		 quickSort(input, 0, input.length-1); 
	} 
	
	/**
	 * @Method	quickSort(int[] input)
	 * overwritten method that holds the sub array starting and ending index for sub-array
	 * @param	sub array  
	 * @param	start index of sub array
	 * @param	end index of sub array
	 * @return	type = void, sorts the input array
	 * */
	public static void quickSort(int[] input, int start_index, int end_index) { 
		int index = partition(input, start_index, end_index); 
		
		// Recursively call quick-sort with left part of the partitioned array 
		if (start_index < index-1) {
			quickSort(input, start_index, index-1); 
		}
		
		// Recursively call quick sort with right part of the partitioned array 
		if (end_index > index) {
			quickSort(input, index, end_index); 
		}
	} 
	
	/**
	 * @Method	quickSort(int[] input)
	 * Divides array from pivot, left side contains elements less than pivot while right side contains elements greater than pivot.
	 * @param	sub-array to be partitioned
	 * @param	lower bound of the array
	 * @param 	upper bound of the array
	 * @return	type = int, the partition index
	 * */
	public static int partition(int[] array, int left, int right) {
		int pivot = array[left]; 
		
		// taking first element as pivot 
		while (left <= right) {
			
			//searching number which is greater than pivot, bottom up 
			while(array[left] < pivot) { 
				left++; 
			} 
			
			//searching number which is less than pivot, top down 
			while (array[right] > pivot) { 
				right--; 
			} 
			
			// swap the values 
			if (left <= right) {
				int tmp = array[left]; 
				
				array[left] = array[right]; 
				array[right] = tmp; 
				
				//increment left index and decrement right index 
				left++; 
				right--; 
			}
		} 
		
		return left; 
	}
}
