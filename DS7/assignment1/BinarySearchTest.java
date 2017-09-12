package assignment1;

import org.junit.*;

/**@Class	BinarySearchTest
 * logarithmic searching algorithm O(n lg n)
 * test that binary search array returns the leftmost element from the array
 **/
public class BinarySearchTest {
	BinarySearch<Integer> searchInteger = null;
	BinarySearch<String> searchString = null;
	
	@Before
	public void setUp() {
		searchInteger = new BinarySearch<Integer>();
		searchString  = new BinarySearch<String>();
	}
	
/******NULL TESTS*******/
	/**@Method	testForAddingNullElement()
	 * adding null element to the array
	 **/
	@Test(expected = NullPointerException.class)
	public void testForAddingNullElement() {
		searchInteger.add(null);
	}
	
	/**@Method	testForSearchingInEmptyList()
	 * searching element in an empty list
	 **/
	@Test
	public void testForSearchingInEmptyList() {
		Assert.assertEquals(-1,  searchInteger.binarySearch(10) );
	}
	
	/**@Method	testForSearchingNullElement()
	 * searching null element in a list
	 **/
	@Test
	public void testForSearchingNullElement() {
		searchInteger.add(2);
		searchInteger.add(-2);
		searchInteger.add(1010);
		searchInteger.add(2);
		searchInteger.add(1);
		searchInteger.add(10);
		searchInteger.add(10);

		Assert.assertEquals(-1,  searchString.binarySearch(null) );
	}
	
/***TEST FOR FINDING AT RIGHTMOST POSITION******/
	/**@Method	testAtRightMostPosition()
	 * element at righmost position: found in O(n lg n) time
	 **/
	@Test
	public void testAtRightMostPosition() {
		for( int element = 10; element > -5; element = element-2) {
			searchInteger.add(element);
		}
		
		Integer input = 10;
		
		Assert.assertEquals(7, searchInteger.binarySearch(input));
		Assert.assertEquals(input , (Integer)searchInteger.get(7));
	}
	
	/**@Method	testSearchForLargeElementNotInList()
	 * search the right array to find element does not exist in list
	 **/
	@Test
	public void testSearchForLargeElementNotInList() {
		for( int element = 10; element > -5; element = element-2) {
			searchInteger.add(element);
		}
		
		Assert.assertEquals(-1, searchInteger.binarySearch(1000));
	}

/***TEST FOR FINDING AT LEFTMOST POSITION*****/	
	/**@Method	testAtLeftMostPosition()
	 * when element is at the first index
	 * and searching starts from middle
	 **/
	@Test
	public void testAtLeftMostPosition() {
		for( int element = 10; element > -5; element = element-2) {
			searchInteger.add(element);
		}
		
		Integer input = -2;
		
		Assert.assertEquals( 1 , searchInteger.binarySearch(input));
		Assert.assertEquals(input , (Integer)searchInteger.get(1));
	}
	
	/**@Method	testSearchForNegativeElementNotInList()
	 * traverse the left array, when element does not exist in list
	 **/
	@Test
	public void testSearchForNegativeElementNotInList() {
		for( int element = 10; element > -5; element = element-2) {
			searchInteger.add(element);
		}
		
		Assert.assertEquals(-1, searchInteger.binarySearch(-5));
	}
	
/***FINDING ELEMENT IN DUPLICATES****/
	/**@Method	testSearchDuplicates()
	 * Find leftmost in duplicates list
	 **/
	public void testSearchDuplicates() {
		searchString.add("hi");
		searchString.add("hillo");
		searchString.add("HI");
		searchString.add("Hi");
		searchString.add("hI");
		searchString.add(" hi");
		
		Integer expected = 1;
		
		Assert.assertEquals(expected, (Integer)searchString.binarySearch("hi"));
		Assert.assertEquals("hi", searchString.get(expected));
	}
	
	/**@Method	testForDuplicates()
	 * Find leftmost in duplicates list
	 **/
	@Test
	public void testForDuplicates() {
		searchInteger.add(2);
		searchInteger.add(-2);
		searchInteger.add(1010);
		searchInteger.add(2);
		searchInteger.add(1);
		searchInteger.add(10);
		searchInteger.add(10);
		
		Integer input = 10;
		Integer expected = 4;
		
		Assert.assertEquals(expected, (Integer)searchInteger.binarySearch(input));
		Assert.assertEquals(input , (Integer)searchInteger.get(expected));
	}
}