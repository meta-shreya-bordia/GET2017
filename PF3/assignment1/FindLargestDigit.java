package assignment1;

public class FindLargestDigit {
	RecursiveRemainder find_remainder = new RecursiveRemainder();
	
	/**
	 * @Method	maximumNumber(int max_digit, int remainder_digit)
	 * find and store the largest digit found
	 * @param	max_digit: the largest digit in a given number
	 * @param	remainder_digit: current last digit of number
	 * @return	type = int, value = current max_digit
	 * */
	public int maximumNumber(int max_digit, int remainder_digit){
		return((max_digit>=remainder_digit)?max_digit:remainder_digit);
	}
	
	/**
	 * @Method	getLargestDigit(int x)
	 * by repeated division and remaninder theorem, find the largest digit in a number
	 * @param	x: number containing largest digit
	 * @return	type = int, value = maximum digit in a number
	 * */
	public int getLargestDigit(int x){
		if(x<0)
			throw new IllegalArgumentException();
	
		if(x==0){
			return 0;
		}
		
		return(maximumNumber(find_remainder.rem(x,10), getLargestDigit(x/10)));
		}
}

/**
public static void main(String args[]){
	FindLargestDigit largestDigit=new FindLargestDigit();
	System.out.println(largestDigit.getLargestDigit(13520));
	System.out.println(largestDigit.getLargestDigit(444));
	System.out.println(largestDigit.getLargestDigit(0));
	System.out.println(largestDigit.getLargestDigit(-444));
**/