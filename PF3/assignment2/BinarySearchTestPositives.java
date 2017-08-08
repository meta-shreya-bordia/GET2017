package assignment2;

import org.junit.*;

/**
 * Positive test cases include checks for base condition, boundary values values or central range inputs.
 * The expected values must match those generates by the method.
 * **/
public class BinarySearchTestPositives {
	BinarySearch search;
	
	@Before
	public void setUp() {
		search = new BinarySearch();
	}
	
	/* When element exists in the list*/
	@Test
	public void testWhenElementInArray() {
		int[] input = {1, 6, 9, 12, 15, 17, 23, 89};
		
		Assert.assertEquals(3, search.binarySearch(input, 12));
	}
	
	/* When element does not exist in the list*/
	@Test
	public void testWhenElementNotInArray() {
		int[] input = {1, 6, 9, 12, 15, 17, 23, 89};
		
		Assert.assertEquals(-1, search.binarySearch(input, 16));
	}
	
	/** return first on multiple instance of element**/
	@Test
	public void testWhenDuplicateElementInArray() {
		int[] input = {1, 6, 9, 12, 12, 12, 12, 15, 17, 23, 89};
		
		Assert.assertEquals(5, search.binarySearch(input, 12));
	}
	
}
