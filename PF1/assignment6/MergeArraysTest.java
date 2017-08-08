package assignment6;
import org.junit.*;

public class MergeArraysTest{

	MergeArrays merger;
	
	@Before
	public void setUp(){
		merger = new MergeArrays();
	}

/** Positive Test cases*/
	// 2 ascending arrays
	@Test
	public void testAscendingArray(){
		int[] a = {7,7,7,7};
		int[] b = {2,4,6,9};
		int[] expected = {2,4,6,7,7,7,7,9};
		
		int[] c= new int[a.length+b.length];
		// merge array a and b (sorted) into c in sorted manner
		Assert.assertArrayEquals(expected, merger.join(a, a.length, b, b.length, c));
	}
	
	//2 descending arrays
	@Test
	public void testDecendingArray(){
		int[] a = {7, 4, 1, 0};
		int[] b = {20, 12, 8, 7, 5, 1, 0};
		int[] expected = {20, 12, 8, 7, 7, 5, 4, 1, 1, 0, 0};
		
		int[] c= new int[a.length+b.length];
		// merge array a and b (sorted) into c in sorted manner
		Assert.assertArrayEquals(expected, merger.join(a, a.length, b, b.length, c));
	}
	
	//empty array
	@Test
	public void testForBlankArray(){
		int[] a = {};
		int[] b = {2,4,6,9};
		int[] expected = {2,4,6,9};
		
		int[] c= new int[a.length+b.length];
		// merge array a and b (sorted) into c in sorted manner
		Assert.assertArrayEquals(expected, merger.join(a, a.length, b, b.length, c));
	}

/** Negative cases*/
	//null array
	@Test(expected = NullPointerException.class)
	public void testForNullArray(){
		int[] a = null;
		int[] b = {2, 5, 6, 9};
		int[] expected = {2,4,6,9};
		
		int[] c= new int[a.length+b.length];
		Assert.assertArrayEquals(expected, merger.join(a, a.length, b, b.length, c));
		}
}
