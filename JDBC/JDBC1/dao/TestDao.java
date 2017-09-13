package dao;

import java.sql.*;
import java.util.List;

import org.junit.*;

import library_information_system.Titles;

/**@Class	TestDAO
 * test database access-update operations
 **/
public class TestDao {
	LISdao getQuery;
	
	@Before
	public void setUp(){
		getQuery = new LISdao();
	}
	
	/*@Method	testGetBooksByAuthor()
	 * get List<Titles> of books by an author
	 */
	@Test
	public void testGetBooksByAuthor() throws SQLException{
		List<Titles> actual = getQuery.getBooksByAuthor("Black");
		
		Assert.assertEquals(3,  actual.size());
		Assert.assertEquals("Harry Potter", actual.get(0).getTitleName() );
		Assert.assertEquals("Sherlock", actual.get(1).getTitleName() );
		Assert.assertEquals("The great gatsby", actual.get(2).getTitleName() );
	}
	
	/*@Method	testGetBooksByInvalidAuthor()
	 * get books by an author that has no books in DB
	 * Or is an invalid author name
	 */
	@Test
	public void testGetBooksByInvalidAuthor() throws SQLException{
		List<Titles> actual = getQuery.getBooksByAuthor("Burminghum");
		
		Assert.assertEquals(0,  actual.size());
	}
	
	/*@Method	testGetBooksByNullAuthor()
	 * Null value for an author's name
	 */
	@Test
	public void testGetBooksByNullAuthor() throws SQLException{
		List<Titles> actual = getQuery.getBooksByAuthor(null);
		
		Assert.assertEquals(0,  actual.size());
	}
	
	/*@Method	testAvailableForIssueBook()
	 * issue from available(not-issued) book
	 * Update books table by updating status to false/0/issued
	 */
	@Test
	public void testAvailableForIssueBook() throws SQLException{
		Assert.assertTrue(getQuery.issueBook("Harry Potter", 1));
	}
	
	/*@Method	testAllIssuedBook()
	 * if all books(different accession number) for same book title
	 * have been issued, then no book can be issued
	 */
	@Test
	public void testAllIssuedBook() throws SQLException{
		Assert.assertFalse(getQuery.issueBook("Harry Potter", 1));
	}
	
	/*@Method	testDeleteCount()
	 * get count of all records deleted
	 * where books that have not been issued for a year are deleted
	 */
	@Test
	public void testDeleteCount(){
		Assert.assertEquals(4, getQuery.deleteUnissuedBooks());
	}
}
