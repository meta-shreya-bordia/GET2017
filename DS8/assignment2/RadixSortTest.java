package assignment2;

import java.util.*;
import org.junit.*;

public class RadixSortTest {
	Sort sortList;
	List<Integer> expected;
	
	//reinitialize object for every test
	@Before
	public void setUp(){
		sortList = new QuickSort();	
		expected = new LinkedList<Integer>();
	}
	
	//Test sort for empty list
	@Test
	public void testEmptyListSort(){
		sortList.sort();
		Assert.assertEquals(expected , sortList.getList());
	}
	
	//Test For Single Element In List
	@Test
	public void testForSingleElementInList(){
		expected.add(0);
		Assert.assertTrue( sortList.add(0) );
		
		Collections.sort(expected);
		sortList.sort();
		
		Assert.assertEquals(expected , sortList.getList());
	}
	
	//When the linked list is descending sorted: Worst Time
	@Test
	public void testForWorstTimeComplexity(){
		for( int element = 10; element >= 0; element--){
			sortList.add(element);
			expected.add(element);
		}
		
		Collections.sort(expected);
		sortList.sort();
		
		Assert.assertEquals(expected, sortList.getList());
	}
	
	//test for best time complexity: when list is already sorted
	@Test
	public void testForBestTimeComplexity(){
		for( int element = 1; element < 10; element++){
			sortList.add(element);
			expected.add(element);
		}
		
		Collections.sort(expected);
		sortList.sort();
		
		Assert.assertEquals(expected, sortList.getList());
	}
	
	//Test for average time complexity: when list is sorted till middle, then reverse sorted
	@Test
	public void testForAverageTimeComplexity(){
		for( int element = 1; element < 5; element++){
			sortList.add(element);
			expected.add(element);
		}
		for( int element = 30; element > 25; element--){
			sortList.add(element);
			expected.add(element);
		}
		
		Collections.sort(expected);
		sortList.sort();
		
		Assert.assertEquals(expected, sortList.getList());
	}
	
	//Test for sorting duplicate elements
	@Test
	public void testForDuplicates(){
		for( int element = 20; element > 8; element--){
			sortList.add(element);
			sortList.add(element);
			
			expected.add(element);
			expected.add(element);
		}
		
		Collections.sort(expected);
		sortList.sort();
		
		Assert.assertEquals(expected, sortList.getList());
	}
	
	//test for negative numbers added to list
	@Test
	public void testForNegativeNumber(){
		for( int element = 4; element > -4; element--){
			sortList.add( new Integer(element));
			
			expected.add(element);
		}
		
		Collections.sort(expected);
		sortList.sort();
		
		Assert.assertEquals(expected, sortList.getList());
	}
	
	//test adding a null element to the list
	@Test
	public void testForNullElementAdd(){
		sortList.add( new Integer(1));
		sortList.add(null);

		expected.add( new Integer(1));
//		expected.add(null);
		
		Collections.sort(expected);
		sortList.sort();
		
		Assert.assertEquals(expected, sortList.getList());		
	}
	
	//Test radix sort works for large dis-connected numbers
	@Test
	public void testForLargeDigits(){
		for( int element = 4; element > 0; element--){
			sortList.add( new Integer(element));
			sortList.add( new Integer(1000- element));
			
			
			expected.add(element);
			expected.add(1000- element);
		}
		
		Collections.sort(expected);
		sortList.sort();
		
		Assert.assertEquals(expected, sortList.getList());
	}
}