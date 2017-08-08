package assignment1;

import org.junit.*;

public class GreatestCommonDivisorTest {
	GreatestCommonDivisor divisor;
	
	@Before
	public void setup(){
		divisor= new GreatestCommonDivisor();
	}
	
//Positive Test Cases:
	
	/** When two numbers are relatively prime*/
	@Test
	public void testForCoPrimeNumbers(){
		Assert.assertEquals(1, divisor.gcd(2, 1));
	}
	
	/** When 2 numbers have a common factor between them*/
	@Test
	public void testForCommonFactor(){
		Assert.assertEquals(6, divisor.gcd(12,18));
	}
	
	/** 2 Prime numbers that have factors only as the number themselves*/
	@Test
	public void testForPrimeNumbers(){
		Assert.assertEquals(1, divisor.gcd(101,3));
	}
	
	/**Test for base condition, when divisor = 0 */
	@Test
	public void testForNumberOneZero(){
		int expectedGCD=divisor.gcd(0,3);
		Assert.assertEquals(3, expectedGCD);
	}
	
	/** When the second number is prime, 0 is divisible by all numbers*/
	@Test
	public void testForNumberSecondZero(){
		Assert.assertEquals(5, divisor.gcd(5,0));
	}
	
	/** When the second number is prime, 0 is divisible by all numbers*/
	@Test
	public void testForBothNumberZero(){
		int expectedGCD=divisor.gcd(0,0);
		Assert.assertEquals(0, expectedGCD);
	}
	
//Negative Test Cases:
	
	/** When either of the number is negative*/
	@Test(expected=IllegalArgumentException.class)
	public void testForNegativeNumber(){
		divisor.gcd(-2,3);
	}

	/** When either of the number is negative*/
	@Test(expected=IllegalArgumentException.class)
	public void testForNegativeDivisor(){
		divisor.gcd(2,-3);
	}
	
	/** When both the numbers are negative*/
	@Test(expected=IllegalArgumentException.class)
	public void testForBothNegativeNumbers(){
		divisor.gcd(-2,-3);
	}
}
