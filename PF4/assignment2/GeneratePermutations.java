package assignment2;

import java.util.*;

public class GeneratePermutations {
	public List<String> permutations;
	
	public List<String> generatePermutation (String input){
		if(input == null)
			throw new NullPointerException();
		
		permutations = new ArrayList<String>();
		generatePermutation("", input);
		
		permutations = new ArrayList<String>(new LinkedHashSet<String>(permutations));
		return permutations;
	}

	private void generatePermutation(String prefix, String input) {
		if (input.length() == 0) {
			permutations.add(prefix);
		}
		
		for (int index = 0; index < input.length() ; index++){
			generatePermutation(prefix + input.charAt(index), input.substring(0, index) + input.substring(index+1, input.length()));
		}
	}
	
	public static void main(String[] args) {
		GeneratePermutations s = new GeneratePermutations();
		s.generatePermutation("ABC");
		System.out.println(s.permutations.toString());
	}
}
