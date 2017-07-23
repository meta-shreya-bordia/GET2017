package assignment3;

import org.junit.*;

/**
 * Negative test cases include checks for null, zero values or incorrect inputs.
 * These raise exceptions that must be handled. 
 **/

public class QuickSortTestNegatives {
	QuickSort sort;
	
	//instantiate an object
	@Before
	public void setUp() {
		sort = new QuickSort();
	}

	/**
	 * @Method	testNullArray()
	 * When input array is null
	 * */
	@Test(expected = NullPointerException.class)
	public void testNullArray() {
		int[] input = null;
		
		sort.quickSort(input);
	}
	
	/**
	 * @Method	testBlankArray()
	 * When input array is empty
	 * */
	@Test(expected = NegativeArraySizeException.class)
	public void testBlankArray() {
		int[] input = {};
		
		sort.quickSort(input);
	}
	
	/**
	 * @Method	testNegativeSizeArray()
	 * When input array size is negative
	 * */
	@Test(expected = NegativeArraySizeException.class)
	public void testNegativeSizeArray() {
		int[] input = new int[-2];
		
		sort.quickSort(input);
	}
}
