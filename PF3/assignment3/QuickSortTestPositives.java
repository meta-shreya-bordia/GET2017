package assignment3;

import org.junit.*;

/**
 * Positive test cases include checks for base condition, boundary values values or central range inputs.
 * The expected values must match those generates by the method.
 **/
public class QuickSortTestPositives {
	QuickSort sort;
	
	//instantiate an object
	@Before
	public void setUp() {
		sort = new QuickSort();
	}
	
	//Test Base Condition: when size of input is 1
	@Test
	public void testForOneElement() {
		int[] input = {1};
		int[] expected = {1};
		
		sort.quickSort(input);
		
		//Compare the expected array with actual output from method 
		Assert.assertArrayEquals(expected, input);
	}
	
	//Test when array is already sorted
	@Test
	public void testForAscSortedArray() {
		int[] input = {-6, 1, 2, 3, 5, 8, 20, 23};
		int[] expected = {-6, 1, 2, 3, 5, 8, 20, 23};
		
		sort.quickSort(input);
		
		//Compare the expected array with actual output from method 
		Assert.assertArrayEquals(expected, input);
	}
	
	@Test
	public void testForDscSortedArray() {
		int[] input = {230, 89, 67, 23, 12, 7, 4, 1, -2, -4};
		int[] expected = {-4, -2, 1, 4, 7, 12, 23, 67, 89, 230};
		
		sort.quickSort(input);
		
		//Compare the expected array with actual output from method 
		Assert.assertArrayEquals(expected, input);
	}
	
	@Test
	public void testForUnSortedArray() {
		int[] input = {2,5,8,9,10, 77, 55, 11};
		int[] expected = {2, 5, 8, 9, 10, 11, 55, 77};
		
		sort.quickSort(input);
		
		//Compare the expected array with actual output from method 
		Assert.assertArrayEquals(expected, input);
	}
	
	@Test
	public void testForAllSameElements() {
		int[] input = {8,8,8,8,8,8,8,8,8,8,8};
		int[] expected = {8,8,8,8,8,8,8,8,8,8,8};
		
		sort.quickSort(input);
		
		//Compare the expected array with actual output from method 
		Assert.assertArrayEquals(expected, input);
	}
}