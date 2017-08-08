package assignment2;

/**
 * linearly iterate over each element to check if its the required element
 * */
public class LinearSearch {
	/**
	 * @Method	linearSearch(int[] input, int search_element)
	 * used by test case to search an element index by index in a linear array
	 * @return	index where element is found
	 * */
	public int linearSearch(int[] input, int search_element) {
		if(input == null)
			throw new NullPointerException();
		
		if(input.length <= 0)
			throw new NegativeArraySizeException();
		
		return linearSearch(input, 0, search_element);
	}
	
	int linearSearch(int[] input, int index, int search_element) {
		return (index >= input.length || input[index] == search_element) ? index : linearSearch(input, index+1, search_element);
	}
}
