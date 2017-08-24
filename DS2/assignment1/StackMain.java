package assignment1;

import java.util.*;

public class StackMain {
	public static void main(String[] args){
		String toParse = getUserInput();
    		String evaluatedExpression = new InfixToPostfix().postfixExpression(toParse);
		
		System.out.println("Your infix expression: \n"
							+toParse +"\n"
							+"to: \n"
							+evaluatedExpression);
	}
	
	public static String getUserInput(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter expression to evaluate: ");
		
		String input = scan.nextLine();
		scan.close();
		
		return input;
	}
}
