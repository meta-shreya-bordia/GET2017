package assignment1;

/**
 * Interface top force calculator to include basic arithmetic operations
 * **/

public interface InterfaceOperations {
	public int add(int number1, int number);
	public int subtract(int number1, int number2);
	public long multiply(int number1, int number);
	public double divide(int number1, int number2);
	public int modulas(int number1, int number);
	
	public double squareRoot(int number);
	public long exponent(int number, int power);

	public Number evaluate(int number1, int number2, char operator);
}
