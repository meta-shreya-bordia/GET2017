package assignment1;

import org.junit.Before;
import org.junit.Test;
/**
 * Negative test cases include checks for null, zero values or incorrect inputs.
 * These raise exceptions that must be handled. 
 * **/
public class PyramidTestNegatives {
	Pyramid whole_pyramid;
	
	/** create an object **/
	@Before
	public void setUp(){
		whole_pyramid = new Pyramid();
	}
	
	/*** how to check that char is not passed**/
	@Test(expected = NumberFormatException.class)
	public void testForChar(){
		whole_pyramid.makePyramid('#');
	}
	
	/**test for zero number or when row_no is greater than possible rows for pattern**/
	// when row = 0
	@Test(expected = NumberFormatException.class)
	public void testForZeroSpaceRow(){
		whole_pyramid.space(0, 5);
	}
	
	//when size of pattern is 0
	@Test(expected = NumberFormatException.class)
	public void testForZeroSpaceSize(){
		whole_pyramid.space(5, 0);
	}
	
	//when row =0 (numbering starts from 1)
	@Test(expected = NumberFormatException.class)
	public void testForZeroNumber(){
		whole_pyramid.number(0, 5);
	}
	
	// when size of pattern is input as 0, pattern not possible
	@Test(expected = NumberFormatException.class)
	public void testForZeroNumberSize(){
		whole_pyramid.number(5, 0);
	}
	
	// create a pattern for size = 0
	@Test(expected = NumberFormatException.class)
	public void testForZeroSize(){
		whole_pyramid.makePyramid(0);
	}
	
	/** test for negative number or when row_no is negative **/
	//test values of row is negative
	@Test(expected = NumberFormatException.class)
	public void testForNegativeRowSpace(){
		whole_pyramid.space(-3, 5);
	}
	
	//pattern size =0, no pattern can exist
	@Test(expected = NumberFormatException.class)
	public void testForNegativeSizeSpace(){
		whole_pyramid.space(5, -2);
	}
	
	//when row no is negative, no row exists
	@Test(expected = NumberFormatException.class)
	public void testForNegativeNumberSpace(){
		whole_pyramid.number(-10, 2);
	}
	
	// when size of pattern is negative, no number pattern exists
	@Test(expected = NumberFormatException.class)
	public void testForNegativeSizeNumber(){
		whole_pyramid.number(2, -3);
	}
	
	// when size of pattern is negative
	@Test(expected = NumberFormatException.class)
	public void testForNegativeSize(){
		whole_pyramid.makePyramid(-2);
	}
	
	/** when row size is greater than possible number of rows **/
	// spacing when row is out of bounds
	@Test(expected = NumberFormatException.class)
	public void testForLargerRowNoSpace() {
		whole_pyramid.space(10, 5);
	} 
	
	/** when row size is greater than possible number of rows **/
	// numbering when row value is larger than possible
	@Test(expected = NumberFormatException.class)
	public void testForLargerRowNoNumber() {
		whole_pyramid.space(15, 5);
	} 
}

/*	Integer does not accept null value
@Test(expected = NumberFormatException.class)
public void testForNull(){
	whole_pyramid.makePyramid(null);
}
*/
