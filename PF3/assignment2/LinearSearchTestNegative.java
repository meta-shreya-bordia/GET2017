package assignment2;

import org.junit.*;

/**
 * Negative test cases include checks for null, zero values or incorrect inputs.
 * These raise exceptions that must be handled. 
 **/
public class LinearSearchTestNegative {
	LinearSearch search;
	
	@Before
	public void setUp() {
		search = new LinearSearch();
	}
	
	/* When array is null*/
	@Test(expected = NullPointerException.class)
	public void testNullArray() {
		int[] input = null;
		search.linearSearch(input, 0);
	}
	
	/* When array is empty*/
	@Test(expected = NegativeArraySizeException.class)
	public void testBlankArray() {
		int[] input = {};
		search.linearSearch(input, 10);
	}
	
	/* When array size is negative */
	@Test(expected = NegativeArraySizeException.class)
	public void testNegativeSizeArray() {
		int[] input = new int[-2];
		search.linearSearch(input, 7);
	}
}
