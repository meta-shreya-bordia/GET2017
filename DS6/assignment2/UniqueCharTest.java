package assignment2;

import org.junit.*;

public class UniqueCharTest {
	UniqueCharacterCount charCounter = null;
	
	@Before
	public void setUp(){
		charCounter = new UniqueCharacterCount();
	}
	
	@Test
	public void testNullString(){
		Assert.assertEquals(0, charCounter.computeResult(null));
	}
	
	@Test
	public void testEmptyString(){
		Assert.assertEquals(0, charCounter.computeResult(""));
	}
	
	@Test
	public void testSpaceString(){
		Assert.assertEquals(1, charCounter.computeResult(" "));
	}
	
	@Test
	public void testSameCharacterString(){
		Assert.assertEquals(1, charCounter.computeResult("ooooooo"));
	}
	
	@Test
	public void testAllDifferentString(){
		Assert.assertEquals(15, charCounter.computeResult("Compute Any String"));
	}
	
	@Test
	public void testSameCharDifferentCaseString(){
		Assert.assertEquals(2, charCounter.computeResult("OoOoOopPp"));
	}
	
	@Test
	public void testIsCacheMissResult(){
		Assert.assertNotEquals(13, charCounter.getCachedResult("Holla from this end"));
	}
	
	@Test
	public void testIsCachedResult(){
		String input = "Holla from this end";
		int expected = 14;
		
		Assert.assertNotEquals(expected, charCounter.getCachedResult(input));
		
		Assert.assertEquals(expected, charCounter.computeResult(input));
		Assert.assertEquals(expected, charCounter.getCachedResult(input));
	}
}
