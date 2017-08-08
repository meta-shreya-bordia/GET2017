package assignment1;

/**
 * Remainder theorem is based on the face that division remainder can be achieved by repeated subtraction 
 * */
public class RecursiveRemainder {
	/**
	 * @Method	rem(int x, int y)
	 * find remainder of x divided by y through repeated subtraction
	 * @param	x: dividend
	 * @param	y: divisor
	 * */
	public int rem(int x, int y) {
		if(x < 0 | y <= 0)
			throw new IllegalArgumentException();
		
		//base condition
		 return ( (x < y) ? x : rem(x-y, y)) ;
	}
}
