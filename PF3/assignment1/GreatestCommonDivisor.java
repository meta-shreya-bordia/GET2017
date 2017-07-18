package assignment1;

/**
 * Greatest Common Divisor of two numbers is the largest number that divides both of them. 
 * Using Eulid's theorem, complexity can be reduced. 
 **/
public class GreatestCommonDivisor {
	RecursiveRemainder find_remainder = new RecursiveRemainder();
	
	int gcd(int x, int y) {
		if(x < 0 | y < 0)
			throw new  IllegalArgumentException();
		
		// base condition
		if(x ==0)
			return y;
		
		if(y==0)
			return x;
		
		return gcd(y, find_remainder.rem(x, y));
	}
}
