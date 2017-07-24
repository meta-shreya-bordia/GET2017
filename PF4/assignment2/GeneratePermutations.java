package assignment2;

import java.util.*;

/**Generate all possible permutations of a string in alphabetical order
* string permutations of same length
*/
public class GeneratePermutations {
	public List<String> permutations;
	
	/**@Method	generatePermutation (String input)
	* sort out the duplicate permutations by using set
	* LinkedHashSet is used to maintain order of elements in a set
	*  @return	type = List<String>, all possible permutations
	*/
	public List<String> generatePermutation (String input){
		if(input == null)
			throw new NullPointerException();
		
		permutations = new ArrayList<String>();
		generatePermutation("", input);
		
		permutations = new ArrayList<String>(new LinkedHashSet<String>(permutations));
		return permutations;
	}

	/**@Method	generatePermutation(String prefix, String input)
	* overloaded method that fixes a part of string and then tests all possible permutations for remaining substring
	*  @return	type = void, updates List of permutations
	*/
	private void generatePermutation(String prefix, String input) {
		if (input.length() == 0) {
			permutations.add(prefix);
		}
		
		for (int index = 0; index < input.length() ; index++){
			generatePermutation(prefix + input.charAt(index), input.substring(0, index) + input.substring(index+1, input.length()));
		}
	}
	
	/**Tester method for a string with all different characters
	*/
	public static void main(String[] args) {
		GeneratePermutations s = new GeneratePermutations();
		s.generatePermutation("ABC");
		System.out.println(s.permutations.toString());
	}
}
