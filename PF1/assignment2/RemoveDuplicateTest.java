package assignment2;
import org.junit.*;

public class RemoveDuplicateTest {

	RemoveDuplicate duplicate_element;

	//initalize object
	@Before
	public void setUp(){
		duplicate_element = new RemoveDuplicate();
	}

/** Positive Cases*/
	// when all element of array are different
	@Test
	public void testAllDifferent(){
		int[] input = {2,80,4,6,8,-1,10,1,17,13,21};
		int[] expected = {2,80,4,6,8,-1,10,1,17,13,21};
		int[] actual   = duplicate_element.removeDuplicate(input);
		
		// compare 2 arrays in size and values returned by function
		Assert.assertArrayEquals(expected, actual);
	}
	
	//when all elements of array are same
	@Test
	public void testAllSameElements(){
		int[] input = {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2};
		int[] expected = {2};
		int[] actual   = duplicate_element.removeDuplicate(input);
		
		// compare 2 arrays in size and values returned by function
		Assert.assertArrayEquals(expected, actual);
	}
	
	//testing for a random number of duplicates
	@Test
	public void testForOneElement(){
		int[] input = {1};
		int[] expected = {1};
		int[] actual   = duplicate_element.removeDuplicate(input);
			
		// compare new arrays returned and expected
		Assert.assertArrayEquals(expected, actual);
	}
	
	// Any element can have any random number of duplicates
	@Test
	public void testForRandomCase(){
		int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9,12,147,45,587,145, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		int[] expected = {1,2,3,4,5,6,7,8,9,14,56, 67,56,78};
		int[] actual   = duplicate_element.removeDuplicate(input);
			
		// compare new arrays returned and expected
		Assert.assertArrayEquals(expected, actual);
	}
	
	//when array is empty
	@Test
	public void testForBlank(){
		int[] input = {};
		int[] expected = {};
			
		//check for empty arrays
		Assert.assertArrayEquals(expected, duplicate_element.removeDuplicate(input));		
	}
		
/** Negative Test Cases: */	
	//test null array
	@Test(expected = NullPointerException.class)
	public void testForNull(){
		duplicate_element.removeDuplicate(null);
	}
	
	
}
