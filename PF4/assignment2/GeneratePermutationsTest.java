package assignment2;

import java.util.*;
import org.junit.*;

public class GeneratePermutationsTest {
	GeneratePermutations permute;
	List<String> expected;
	
	@Before
	public void setUp() {
		permute = new GeneratePermutations();	
		expected = new ArrayList<String>();
	}

//Positive Test Cases
	/**when input string has all different characters*/
	@Test
	public void testAllDifferentChars() {
		permute.generatePermutation("ABC");
		
		String[] all_permutations = { "ABC", "ACB", "BAC", "BCA", "CAB", "CBA"};
		expected.addAll(Arrays.asList(all_permutations));
		
		Assert.assertEquals(expected, permute.permutations);
	}
	
	/**when input string has all same characters*/
	@Test
	public void testAllSameChars() {
		permute.generatePermutation("AAA");
		
		String[] all_permutations = {"AAA"};
		expected.addAll(Arrays.asList(all_permutations));
		
		Assert.assertEquals(expected, permute.permutations);
	}
	
	/**when input string has only one character*/
	@Test
	public void testForOneCharacter() {
		permute.generatePermutation("#");
		
		String[] all_permutations = { "#"};
		expected.addAll(Arrays.asList(all_permutations));
		
		Assert.assertEquals(expected, permute.permutations);
	}
	
	/**when input string has only one character*/
	@Test
	public void testForEmptyInput() {
		permute.generatePermutation("");
		
		String[] all_permutations = { ""};
		expected.addAll(Arrays.asList(all_permutations));
		
		Assert.assertEquals(expected, permute.permutations);
	}
	
//Negative test cases
	/**when input string is null*/
	@Test(expected = NullPointerException.class)
	public void testForNullInput() {
		permute.generatePermutation(null);
	}
}
