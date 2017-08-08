package assignment1;

import org.junit.*;

public class FindLargestDigitTest {
	FindLargestDigit largest_digit;

	@Before
	public void setup(){
		largest_digit= new FindLargestDigit();
	}
	
// Positive Test Cases:
	/** Base Condition test
	 * when digit is zero
	 * */
	@Test
	public void testForZero(){
		int expectedDigit= largest_digit.getLargestDigit(0);
		
		Assert.assertEquals(0, expectedDigit);
	}
	
	/** Single Digit Condition test
	 * */
	@Test
	public void testForSingleDigitNumber(){
		int expectedDigit= largest_digit.getLargestDigit(2);
		Assert.assertEquals(2, expectedDigit);
	}
	
	/** When all the digits are same
	 * */
	@Test
	public void testForSameDigitNumber(){
		int expectedDigit= largest_digit.getLargestDigit(444);
		Assert.assertEquals(4, expectedDigit);
	}
	
	/** All digits are different (increasing or decreasing order of digit value)
	 * */
	@Test
	public void testDifferentDigitNumber(){
		int expectedDigit= largest_digit.getLargestDigit(9743);
		Assert.assertEquals(9, expectedDigit);
	}
	
// Negative Test Cases:
	@Test(expected=IllegalArgumentException.class)
	public void testForNumberNegative(){
		largest_digit.getLargestDigit(-864);
	}
}
