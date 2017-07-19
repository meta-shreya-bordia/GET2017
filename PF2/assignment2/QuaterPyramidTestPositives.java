package assignment2;

import org.junit.*;
/**
 * Positive test cases include checks for base condition, boundary values values or central range inputs.
 * The expected values must match those generates by the method.
 * **/
public class QuaterPyramidTestPositives {
	InverseQuaterPyramid pyramid;
	
	@Before
	public void setUp(){
		pyramid = new InverseQuaterPyramid();
	}
	
	/** Method: testForBaseCondition
	 * Base Condition test:
	 * Minimum size of pattern = 1
	 * **/
	@Test
	public void testForOne(){
		String expected_space = "";
		// space for row =1 when size=1
		Assert.assertEquals(expected_space, pyramid.space(1,1));
		
		String expected_no = "1 ";
		// number module returns the numbers printed in the pattern for the row
		Assert.assertEquals(expected_no, pyramid.number(1, 1));

		String[] expected = {"1 \n"};
		// complete pattern representation must match
		Assert.assertArrayEquals(expected, pyramid.makePyramid(1));
	}
	
	/** Method: testForRandomSize
	 * Testing between the range [1,9]
	 * **/
	@Test
	public void testRandom(){
		String expected_space = "    ";
		// space for any random possible row is compared
		Assert.assertEquals(expected_space, pyramid.space(3, 5));
		
		String expected_no = "1 2 3 ";
		// number module returns the numbers printed in the pattern for the row
		Assert.assertEquals(expected_no, pyramid.number(3, 5));

		String[] expected = {"1 2 3 4 5 \n",
						     "  1 2 3 4 \n",
						     "    1 2 3 \n",
						     "      1 2 \n",
						     "        1 \n"};
		// complete pattern representation must match
		Assert.assertArrayEquals(expected, pyramid.makePyramid(5));
	}
	
	/** Method: testForRowNumber
	 * Modular testing, checking validating of row numbers acceptable for pattern of size n
	 * */
	@Test
	public void testForRowNumber(){
		String expected_space = "    ";
		// space for any random possible row is compared
		Assert.assertEquals(expected_space, pyramid.space(3, 5));
		
		String expected_no = "1 2 3 ";
		// number module returns the numbers printed in the pattern for the row
		Assert.assertEquals(expected_no, pyramid.number(3, 5));		
	}
}
