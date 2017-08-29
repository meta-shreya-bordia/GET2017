package assignment2;

import java.util.*;

public class UniqueCharacterCount {
	private static Map<String, Integer> cacheMemory =  new HashMap<String, Integer>();
	
	public int computeResult(String checkString){
		if(checkString == null || checkString == ""){
			return 0;
		}
			
		String inputString = checkString.trim().toLowerCase();
		
		if( cacheMemory.containsKey(inputString) ){
			return cacheMemory.get( inputString );
		}
		
		int uniqueCharCount = getUniqueCharacterCount( inputString );
		setCacheResult(inputString, uniqueCharCount);
		
		return uniqueCharCount;
	}
	
	public int getUniqueCharacterCount(String input) {
		Set<Character> uniqueChars = new HashSet<Character>();
		
		for( char ch: input.toCharArray() ){
			uniqueChars.add( ch );
		}
		
		return uniqueChars.size();
	}
	
	public void setCacheResult(String input, int uniqueCharCount){
		cacheMemory.put( input , uniqueCharCount );
	}
	
	public int getCachedResult(String input){
		if(! cacheMemory.containsKey(input)){
			return 0;
		}
		return cacheMemory.get(input);
	}
}
