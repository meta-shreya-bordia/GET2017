package assignment5;
import org.junit.*;

public class CheckArraySortingTest {
	CheckArraySorting classify;
	
	@Before
	public void setUp(){
		classify = new CheckArraySorting();
	}
	
/** Positive Test Cases: */
	//Ascending sorted
	@Test
	public void testAscSort(){
		int[] input = {1, 2, 3, 4, 5, 5, 89, 400};
		
		//classified as ascending sorted
		Assert.assertEquals("Array in ascending sorted order", 1, classify.checkSortArray(input));
	}
	
	//Descending sorted
	@Test
	public void testDscSort(){
		int[] input = {90, 89, 88, 88, 78, 67, 56};
		//classified as descending sorted
		Assert.assertEquals("Array in decending sorted order", 2, classify.checkSortArray(input));
	}
	
	//Unsorted
	@Test
	public void testUnsort(){
		int[] input = {8, 9, 0, 3, 7, 6, 14, 45, 9};
		//classified as unsorted
		Assert.assertEquals("Array is unsorted", 0, classify.checkSortArray(input));
	}
	
	//for equal element array
	@Test
	public void testSameElement(){
		int[] input = {5,5,5,5,5,5,5,5,5,5,5,5,5,5};
		//classified as ascending sorted
		Assert.assertEquals("Array in ascending sorted order", 1, classify.checkSortArray(input));
	}
	
/** Negative Test Cases*/
	//Exception raised
	@Test(expected = NullPointerException.class)
	public void testNull(){
		classify.checkSortArray(null);
	}
		
	// blank is Unsorted 
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testBlank(){
		int[] input = {};
		//classified as unsorted
		Assert.assertEquals("Array is unsorted", 0, classify.checkSortArray(input));
	}
}
