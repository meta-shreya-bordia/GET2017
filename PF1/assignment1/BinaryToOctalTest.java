package assignment1;
import org.junit.*;

//Test Class for testing conversion from binary to octal no.
public class BinaryToOctalTest {
	BinaryToOctal convertor;
	
	/** creating an object **/
	@Before
	public void setUp(){
		convertor = new BinaryToOctal();
	}
	
//Positive Cases	
	/**Test for 0 as single binary number **/
	@Test
	public void testForBinary0(){
		// Compares expected = 0 value with actual received from function(int)
		Assert.assertEquals(0, convertor.convertBinaryToOctal(0));
	}
	
	/**Test for a binary number stating with 0 (treated as binary)**/
	@Test
	public void testBinary(){
		// 00 is treated as binary number in java
		Assert.assertEquals(5, convertor.convertBinaryToOctal(Integer.parseInt("00101")));
	}
	
	/** Converts binary number to octal number*/
	@Test
	public void testForBinaryNo(){
		// Compares expected = 65 value with actual received from function(int)
		Assert.assertEquals(65, convertor.convertBinaryToOctal(110101));
	}
	
//Negative number
	/** Passing a decimal number **/
	@Test(expected = NumberFormatException.class)
	public void testDecimalValue(){
		// Raises an exception as no is not binary
		convertor.convertBinaryToOctal(1935);
	}
	
	/** Passing a character, treated as UNICODE number **/
	@Test(expected = NumberFormatException.class)
	public void testCharacterValue(){
		// Raises an exception as no is not binary (UNICODE char)
		convertor.convertBinaryToOctal('a');
	}
	
	
		
}
