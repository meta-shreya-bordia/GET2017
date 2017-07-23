package assignment2;

/**
 * Split array into 2 halves to search element
 * */
public class BinarySearch {
	/**
	 * @Method	binarySearch(int[] input, int search_element)
	 * test all primary conditions
	 * */
	public int binarySearch(int[] input, int search_element) {
		if(input == null)
			throw new NullPointerException();
		
		if(input.length <= 0)
			throw new NegativeArraySizeException();
		
		return binarySearch(input, 0, input.length-1, search_element);
	}

	/**
	 * @Method	binarySearch(int[] input, int start_index, int end_index, int search_element)
	 * check at middle element for search element
	 * @return	index at which element is found
	 * */
	static int binarySearch(int[] input, int start_index, int end_index, int search_element) {
		// base condition to exit recursive stack
		if(end_index < start_index) {
			return -1;
		}

		int middle_element = (start_index + end_index) / 2;
		
		// condition if element is found
		if(search_element == input[middle_element]) {
			return middle_element;			
		}else if(search_element < input[middle_element]) {
			end_index = middle_element -1;
		}else{
			start_index = middle_element +1 ;
		}
		
		return binarySearch(input, start_index, end_index, search_element);
	}
}