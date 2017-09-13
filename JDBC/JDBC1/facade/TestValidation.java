package facade;

import org.junit.*;

/**@Class	TestValidation
 * test query validity for requisite functionality
 **/
public class TestValidation {
	Validations checkValid;
	
	@Before
	public void setUp(){
		checkValid = new Validations();
	}
	
	/*@Method	testInvalidMemberId()
	 * assert for invalid member id ( int value comparison )
	 */
	@Test
	public void testInvalidMemberId(){
		Assert.assertFalse(checkValid.checkMemberId(0));
	}
	
	/*@Method	testValidMemberId()
	 * assert for valid member id ( int value comparison )
	 */
	@Test
	public void testValidMemberId(){
		Assert.assertTrue(checkValid.checkMemberId(1));
	}
	
	/*@Method	testInvalidBookName()
	 * assert for invalid book name
	 *(when book name is either empty or does not exist in DB)
	 */
	@Test
	public void testInvalidBookName(){
		Assert.assertFalse(checkValid.checkBookName(" "));
	}	
	
	/*@Method	testNullBookName()
	 * assert for null parameter as book name
	 */
	@Test
	public void testNullBookName(){
		Assert.assertFalse(checkValid.checkBookName(null));
	}	
	
	/*@Method	testValidBookName()
	 * assert that @param bookName exists in DB
	 */
	@Test
	public void testValidBookName(){
		Assert.assertTrue(checkValid.checkBookName("Harry Potter"));
	}	

	/*@Method	testNullAuthorName()
	 * passing a null parameter author name in DB
	 */
	@Test
	public void testNullAuthorName(){
		Assert.assertFalse(checkValid.checkAuthorName(null));
	}	
	
	/*@Method	testInvalidAuthorName()
	 * (when author name is either empty or does not exist in DB)
	 */
	@Test
	public void testInvalidAuthorName(){
		Assert.assertFalse(checkValid.checkAuthorName("pretty"));
	}	
	
	/*@Method	testValidAuthorName()
	 * assert that @param authorName exists in DB
	 */
	@Test
	public void testValidAuthorName(){
		Assert.assertTrue(checkValid.checkAuthorName("Green"));
	}	
}
