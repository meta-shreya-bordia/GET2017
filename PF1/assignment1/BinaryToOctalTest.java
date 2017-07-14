package assignment1;
import org.junit.*;

//Test Class for testing conversion from binary to octal no.
public class BinaryToOctalTest {
	BinaryToOctal convertor;
	
	// create object
	@Before
	public void setUp(){
		convertor = new BinaryToOctal();
	}
	
	//Test for 0 as single binary number
	@Test
	public void testForBinary0(){
		// Compares expected = 0 value with actual received from function(int)
		Assert.assertEquals(0, convertor.convertBinaryToOctal(0));
	}
	
	@Test
	public void testForBinaryNo(){
		// Compares expected = 65 value with actual received from function(int)
		Assert.assertEquals(65, convertor.convertBinaryToOctal(110101));
	}
	
	@Test(expected = Exception.class)
	public void testForInvalidValue(){
		// Raises an exception as no is not binary
		convertor.convertBinaryToOctal(1234);
	}
	
	@Test
	public void testBinary(){
		// 00 is treated as binary number in java
		Assert.assertEquals(4, convertor.convertBinaryToOctal(Integer.parseInt("00101")));
	}	
}
