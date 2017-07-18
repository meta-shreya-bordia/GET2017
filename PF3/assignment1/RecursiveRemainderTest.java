package assignment1;

import org.junit.*;

public class RecursiveRemainderTest {
RecursiveRemainder remainder;

	@Before
	public void setUp() {
		remainder = new RecursiveRemainder();
	}

//Positive Test Cases:
	
	/** When two numbers are relatively prime*/
	@Test
	public void testForCoPrimeNumbers(){
		Assert.assertEquals(1, remainder.rem(2, 1));
	}
	
	/** When 2 numbers have a common factor between them*/
	@Test
	public void testForCommonFactor(){
		Assert.assertEquals(6, remainder.rem(12,18));
	}
	
	/** 2 Prime numbers that have factors only as the number themselves*/
	@Test
	public void testForPrimeNumbers(){
		Assert.assertEquals(1, remainder.rem(101, 3));
	}
	
	/** When dividend is zero */
	@Test
	public void testDividendAsZero(){
		int expectedRemainder= remainder.rem(0,1);
		Assert.assertEquals(0, expectedRemainder);
	}

//Negative Test Cases:
	/** When divisor is 0*/
	@Test(expected=IllegalArgumentException.class)
	public void TestForDivisorZero(){
		remainder.rem(2, 0);
	}
	
	/** When either of the number is negative*/
	@Test(expected=IllegalArgumentException.class)
	public void TestForDividendNegative(){
		remainder.rem(-2, 3);
	}
	
	/** When either of the number is negative*/
	@Test(expected=IllegalArgumentException.class)
	public void TestForDivisorNegative(){
		remainder.rem(2,-3);
	}
	
	/** When either of the number is negative*/
	@Test(expected=IllegalArgumentException.class)
	public void TestForBothNegative(){
		remainder.rem(-2,-3);
	}
}
