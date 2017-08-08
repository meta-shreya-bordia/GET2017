package assignment2;

import org.junit.*;

public class LinearSearchTestPositive {
	LinearSearch search;
	
	@Before
	public void setUp() {
		search = new LinearSearch();
	}
	
	/** When element exists in the array*/
	@Test
	public void testWhenElementInArray() {
		int[] input = {1, 6, 9, 12, 15, 17, 23, 89};
		
		Assert.assertEquals(3, search.linearSearch(input, 12));
	}
	
	/** When element does not exist in the array*/
	@Test
	public void testWhenElementNotInArray() {
		int[] input = {1, 6, 9, 12, 15, 17, 23, 89};
		
		Assert.assertEquals(8, search.linearSearch(input, 16));
	}
	
	/** return first instance of occurrence of element**/
	@Test
	public void testWhenDuplicateElementInArray() {
		int[] input = {1, 6, 9, 12, 12, 12, 12, 15, 17, 23, 89};
		
		Assert.assertEquals(3, search.linearSearch(input, 12));
	}
	
	

}
