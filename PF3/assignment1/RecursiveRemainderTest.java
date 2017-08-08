package assignment1;

import org.junit.*;

public class RecursiveRemainderTest {
RecursiveRemainder remainder;

	@Before
	public void setUp() {
		remainder = new RecursiveRemainder();
	}

//Positive Test Cases:
	
	/** When divident is larger than divisor*/
	@Test
	public void testForLargerDivident(){
		Assert.assertEquals(0, remainder.rem(2, 1));
	}
	
	/** When divisor is larger than divident*/
	@Test
	public void testForSmallDividend(){
		Assert.assertEquals(12, remainder.rem(12,18));
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
