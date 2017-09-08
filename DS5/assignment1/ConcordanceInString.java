package assignment1;

import java.util.*;

public class ConcordanceInString {
	Map<Character, List<Integer>> characterCount;
	
	public ConcordanceInString() {
		characterCount = new HashMap<Character, List<Integer>>();
	}
	
	public void getCharPositions(String input) {
		for(int position = 0; position < input.length(); position++) {
			char inputChar = input.charAt(position);
			
			if( characterCount.containsKey( inputChar ) ) {
				characterCount.get(inputChar).add( position );
			}else{
				List<Integer> elementAtPosition = new ArrayList<Integer>();
				elementAtPosition.add( position );
				characterCount.put( inputChar, elementAtPosition );
			}
		}
	}
	
	public String printCharPosition(String input) {
		String outputString = "";
		
		if(input == null || characterCount.size() == 0) {
			return outputString;
		}
		
		getCharPositions(input);
		
		outputString = "{";
		for( Map.Entry<Character, List<Integer>> inputChar : characterCount.entrySet()) {
			outputString += inputChar.getKey() + "=" + inputChar.getValue().toString() + ",";
		}
		outputString += "}";
		
		return outputString;
	}
	
	public static void main(String[] a) {
		String findConcordance = "aaaaa";
		
		ConcordanceInString operation = new ConcordanceInString();
		System.out.println( operation.printCharPosition(findConcordance) );
	}
}
