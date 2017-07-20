package assignment1;

public class Operations implements InterfaceOperations{
	
	Buttons button = new Buttons();
	
	/**
	 * @Method	evaluate(int number1, int number2, char operator)
	 * when = operator is clicked
	 * @param int number1, int number2, char operator(arithmetic operation to perform)
	 * @return	type = Number, super class of built-in data types
	 * */
	public Number evaluate(int number1, int number2, char operator) {
		//find button.value = operator
	
		switch(operator) {
			/** Call method to execute and return result on basis of operator clicked*/
		}
		
		return 0;
	}
	
	/** Add 2 numbers*/
	public int add(int number1, int number2) {
		return 0;
	}
	
	/** subtract 2 numbers*/
	public int subtract(int number1, int number2) {
		return 0;
	}
	
	/** multiply 2 numbers*/
	public long multiply(int number1, int number2) {
		return 0;
	}
	
	/** divide 2 numbers
	 * handle exception of divide by zero
	 * */
	public double divide(int dividend, int divisor) {
		return 0;
	}
	
	/** modulas of a number
	 * handle exception of divide by zero
	 **/
	public int modulas(int dividend, int divisor) {
		return 0;
	}
	
	 /** find positive square root of a number
	 **/
	public double squareRoot(int number) {
		return 0;
	}
	
	/** find exponent of a numbers
	 * */
	public long exponent(int number, int power) {
		return 0;
	}	
}
