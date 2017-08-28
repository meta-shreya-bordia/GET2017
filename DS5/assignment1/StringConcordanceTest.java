package assignment1;

import org.junit.*;

public class StringConcordanceTest {
	ConcordanceInString operation;
	
	@Before
	public void setUp() {
		operation = new ConcordanceInString();
	}
	
	@Test
	public void testNullString() {
		Assert.assertEquals("", operation.printCharPosition(null));
	}
	
	@Test
	public void testEmptyString() {
		Assert.assertEquals("", operation.printCharPosition(""));
	}
	
	@Test
	public void testSingleCharacterString() {
		Assert.assertEquals("{a=[0],}", operation.printCharPosition("a"));
	}
	
	@Test
	public void testNumberString() {
		Assert.assertEquals("{1=[0],2=[1],}", operation.printCharPosition("12"));
	}
	
	@Test
	public void testAllSameCharacterString() {
		Assert.assertEquals("{a=[0,1,2,3,4,5],}", operation.printCharPosition("aaaaa"));
	}
	
	@Test
	public void testAllDifferentCharacterString() {
		Assert.assertEquals("{a=[0],b=[1],c=[2],}", operation.printCharPosition("abc"));
	}
}
