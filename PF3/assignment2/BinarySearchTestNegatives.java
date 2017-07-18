package assignment2;

import org.junit.*;

/**
 * Negative test cases include checks for null, zero values or incorrect inputs.
 * These raise exceptions that must be handled. 
 * **/
public class BinarySearchTestNegatives {
	BinarySearch search;
	
	@Before
	public void setUp() {
		search = new BinarySearch();
	}
	
	/* Null Sized Array*/
	@Test(expected = NullPointerException.class)
	public void testNullArray() {
		int[] input = null;
		search.binarySearch(input, 0);
	}
	
	/* When array is empty*/
	@Test(expected = NegativeArraySizeException.class)
	public void testBlankArray() {
		int[] input = {};
		search.binarySearch(input, 10);
	}
	
	/* When array size is set as negative*/
	@Test(expected = NegativeArraySizeException.class)
	public void testNegativeSizeArray() {
		int[] input = new int[-2];
		search.binarySearch(input, 7);
	}
}
