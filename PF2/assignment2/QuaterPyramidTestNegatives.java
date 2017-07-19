package assignment2;

import org.junit.Before;
import org.junit.Test;
/**
 * Negative test cases include checks for null, zero values or incorrect inputs.
 * These raise exceptions that must be handled. 
 * **/
public class QuaterPyramidTestNegatives {
	InverseQuaterPyramid pyramid;
	
	/** create an object **/
	@Before
	public void setUp(){
		pyramid = new InverseQuaterPyramid();
	}
	
	/**test for zero number or when row_no is greater than possible rows for pattern**/
	// when row = 0
	@Test(expected = NumberFormatException.class)
	public void testForZeroSpaceRow(){
		pyramid.space(0, 5);
	}
	
	//when size of pattern is 0
	@Test(expected = NumberFormatException.class)
	public void testForZeroSpaceSize(){
		pyramid.space(5, 0);
	}
	
	//when row =0 (numbering starts from 1)
	@Test(expected = NumberFormatException.class)
	public void testForZeroNumber(){
		pyramid.number(0, 5);
	}
	
	// when size of pattern is input as 0, pattern not possible
	@Test(expected = NumberFormatException.class)
	public void testForZeroNumberSize(){
		pyramid.number(5, 0);
	}
	
	// create a pattern for size = 0
	@Test(expected = NumberFormatException.class)
	public void testForZeroSize(){
		pyramid.makePyramid(0);
	}
	
	/** test for negative number or when row_no is negative **/
	//test values of row is negative
	@Test(expected = NumberFormatException.class)
	public void testForNegativeRowSpace(){
		pyramid.space(-3, 5);
	}
	
	//pattern size =0, no pattern can exist
	@Test(expected = NumberFormatException.class)
	public void testForNegativeSizeSpace(){
		pyramid.space(5, -2);
	}
	
	//when row no is negative, no row exists
	@Test(expected = NumberFormatException.class)
	public void testForNegativeNumberSpace(){
		pyramid.number(-10, 2);
	}
	
	// when size of pattern is negative, no number pattern exists
	@Test(expected = NumberFormatException.class)
	public void testForNegativeSizeNumber(){
		pyramid.number(2, -3);
	}
	
	// when size of pattern is negative
	@Test(expected = NumberFormatException.class)
	public void testForNegativeSize(){
		pyramid.makePyramid(-2);
	}
	
	/** when row size is greater than possible number of rows **/
	// spacing when row is out of bounds
	@Test(expected = NumberFormatException.class)
	public void testForLargerRowNoSpace() {
		pyramid.space(10, 5);
	} 
	
	// numbering when row value is larger than possible
	@Test(expected = NumberFormatException.class)
	public void testForLargerRowNoNumber() {
		pyramid.space(15, 5);
	} 
}

/**	@Test(expected = NumberFormatException.class)
public void testForNull(){
	pyramid.makePyramid(null);
}
**/