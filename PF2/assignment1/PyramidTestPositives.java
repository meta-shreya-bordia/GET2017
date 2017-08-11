package assignment1;

import org.junit.*;
/**
 * Positive test cases include checks for base condition, boundary values values or central range inputs.
 * The expected values must match those generates by the method.
 * **/
public class PyramidTestPositives {
	Pyramid whole_pyramid;
	
	@Before
	public void setUp(){
		whole_pyramid = new Pyramid();
	}
	
	/** Method: testForBaseCondition
	 * Base Condition test:
	 * Minimum size of pattern = 1
	 * **/
	@Test
	public void testForBaseCondition(){
		String expected_space = "";
		// space for row =1 when size=1
		Assert.assertEquals(expected_space, whole_pyramid.space(1,1));
		
		String expected_no = "1 ";
		// number module returns the numbers printed in the pattern for the row
		Assert.assertEquals(expected_no, whole_pyramid.number(1, 1));
		
		String[] expected = {"1 \n"};
		// complete pattern representation must match
		Assert.assertArrayEquals(expected, whole_pyramid.makePyramid(1));		
	}
	
	/** Method: testForRandomSize
	 * Testing between the range
	 * **/
	@Test
	public void testForRandomSize(){
		String expected_space = "      ";
		// space for any random possible row is compared
		Assert.assertEquals(expected_space, whole_pyramid.space(3, 6));
		
		String expected_no = "1 2 3 2 1 ";
		// number module returns the numbers printed in the pattern for the row
		Assert.assertEquals(expected_no, whole_pyramid.number(3, 6));
		
		String[] expected = {
						 "          1 \n", 
						 "        1 2 1 \n",
						 "      1 2 3 2 1 \n",
						 "    1 2 3 4 3 2 1 \n",
						 "  1 2 3 4 5 4 3 2 1 \n",
						 "1 2 3 4 5 6 5 4 3 2 1 \n",
						 "  1 2 3 4 5 4 3 2 1 \n",
						 "    1 2 3 4 3 2 1 \n",
						 "      1 2 3 2 1 \n",
						 "        1 2 1 \n",
						 "          1 \n" };
		// complete pattern representation must match
		Assert.assertArrayEquals(expected, whole_pyramid.makePyramid(6));
	}
	
	/** Method: testForRowNumber
	 * Modular testing, checking validating of row numbers acceptable for pattern of size n
	 * */
	@Test
	public void testForRowNumber(){
		String expected_space = "    ";
		// space for any random possible row is compared
		Assert.assertEquals(expected_space, whole_pyramid.space(8, 5));
		
		String expected_no = "1 2 1 ";
		// number module returns the numbers printed in the pattern for the row
		Assert.assertEquals(expected_no, whole_pyramid.number(8, 5));		
	}
}