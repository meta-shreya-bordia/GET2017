package assignment1;

import java.util.Arrays;

public class BinarySearch<T extends Comparable<T>> {
	private Object[] list;
	private final int DEFAULT_SIZE = 10;
	private int size;
	private int totalElements = 0;
	
	BinarySearch(){
		size = DEFAULT_SIZE;
		list = new Object[DEFAULT_SIZE];
	}
	
	/**@Method	binarySearch(T element)
	 * searching starts from the middle of an array
	 * (only for sorted arrays)
	 **/
	//Time Complexity: O(n)
	public int binarySearch(T element) {
		if( element == null) {
			return -1;
		}
		
		Arrays.sort(list, 0, totalElements);
		return binarySearch(0, totalElements-1, element);
	}
	
	
	/**@Method	binarySearch(int startIndex, int endIndex, T element)
	 * if element > array[middle], traverse the right array
	 * if element < array[middle], traverse the left array
	 * @return	type = int, leftmost position of element in list
	 * 						or if element is not found: -1
	 **/
	//return the leftmost element: iterative approach
	private int binarySearch(int startIndex, int endIndex, T element){
		int foundIndex  = -1;
		
		while(startIndex <= endIndex) {
			int middleIndex = startIndex + (endIndex - startIndex)/2 ;
			
			int difference = ((T)list[middleIndex]).compareTo(element);
			
			//if middle element is equal/greater than the element: move towards the left side array to find the leftmost
			if( difference == 0) {
				foundIndex = middleIndex;
			}
			
			//search the right side
			if( difference < 0 ) {
				startIndex = middleIndex+1;
			//search the left side
			}else if( difference >= 0) {
				endIndex = middleIndex-1;
			}
		}
		
		return foundIndex;
	}
	
	/**@Method add(T element)
	 * add an element at the end of the array
	**/
	public void add(T element) {
		if(element == null) {
			throw new NullPointerException();
		}
		
		if(totalElements == size) {
			list = Arrays.copyOf(list, size*2);
		}
		
		list[totalElements++] = element;
	}
	
	/**@Method	get(int index)
	 * get element in the array at specified position
	 **/
	public T get(int index) {
		return (T)list[index];
	}
	
	public static void main(String[] args) {
		BinarySearch<Integer> s = new BinarySearch<Integer>();
		for( int i = 10; i>= 1; i= i-2) {
			s.add((Integer)i);
		}
		System.out.println(s.binarySearch(4));
		
		s = new BinarySearch<Integer>();
		for( int element = 10; element > -5; element = element-2) {
			s.add((Integer)element);
		}
		System.out.println(s.binarySearch(4));		
	}
}
