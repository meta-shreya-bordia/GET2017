package assignment1;

public class InfixToPostfix {
	private MyStack<Character> stack;
	
	public InfixToPostfix(){
		stack = new MyStack<Character>();
	}
	
	public String postfixExpression(String toParse){
		if(toParse == null || toParse ==""){
			return toParse;
		}
		
		String postfixExpression = "";
		
		for(char operand: toParse.toCharArray()){
			System.out.println(operand);
			if(Character.isDigit(operand) || Character.isLetter(operand)){
				//if operand: add to print block
				postfixExpression += operand;
			}else if(operand == '('){
				//push to stack: always: no checks
				stack.push(operand);
			}else if(operand == ')'){
				// pop until '(' encountered
				// if no '(' encountered even when stack empty: parenthesis mismatch: throw exception
				while( !stack.isEmpty() && stack.peek() !='(' ){
					postfixExpression += stack.pop();
				}
				
				//is stack empty but stack.peek!= '('
				if(stack.isEmpty() && stack.peek()!='('){
					return "Parenthesis mis-match";
				}else{
					//if peek = '(' : pop the starting parenthesis
					stack.pop();	//do not add to final expr
				}
			}else if( isOperator(operand) ){
				while(!stack.isEmpty() && stack.peek() !='(' && getOperatorPrecedence(operand) >= getOperatorPrecedence(stack.peek())){
					postfixExpression += stack.pop();
				}
				
				//if stack is empty, or op2 precedence is higher: push to stack
				stack.push(operand);
			}
		}
		
		//iterated to the end of string:
		while(!stack.isEmpty() && stack.peek()!= '('){
			postfixExpression += stack.pop();
		}
		
		if(!stack.isEmpty()){
			return "Parenthesis mis-match";
		}else{
			return postfixExpression;
		}
	}
	
	
	private boolean isOperator(char operator){
		String operatorList = "*/%+-&|^=";
		
		for(char c: operatorList.toCharArray()){
			if(operator == c){
				return true;
			}
		}
		return false;
	}
	
	private static int getOperatorPrecedence(char operator) {
		switch(operator) {
										//highest precedence for evaluation
			case '/':	//DIVIDE
			case '*':	//MULTIPLY
			case '%':	//MODULAS
				return 1;
				
			case '+':	//ADDITION operator
			case '-':	//SUBTRACTION operator
				return 2;
				
			case '&':	//AND operator
				return 3;
			case '^':	//XOR operator
				return 4;
			case '|':	//OR operator
				return 5;
			
			case '=':	//ASSIGNMENT
				return 6;
				
			default:
				return 10;				//lowest precedence
		}
	}
}
