package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import jdbc_connection.JDBCConnection;
import library_information_system.*;

/**@Class	LISdao
 * dao for accessing DB
 **/
public class LISdao {
	JDBCConnection db_connection;
	
	public LISdao() {
		db_connection = JDBCConnection.getConnection();
	}
	
	/*ASSIGNMENT 1.
	 * Fetch all the books published by author, given the name of the author. 
	 * Return the books data (List of Titles).
	 **(return list of valid author books for authors by same name)**
	*/
	public List<Titles> getBooksByAuthor(String author_name){
		String query = "SELECT T.title_id, T.title_name, T.subject_id, T.publisher_id"
					+ " FROM titles T, title_author TA"
					+ " WHERE T.title_id = TA.title_id"
					+ " AND TA.author_id = "
						+ " (SELECT A.author_id "
						+ " FROM author AS A"
						+ " WHERE A.author_name = '"+author_name+"');";
		
		List<Titles> booksByAuthor = new ArrayList<Titles>();
		
		try {
			ResultSet rs = db_connection.getData(query);
			while(rs != null && rs.next() ) {
				booksByAuthor.add( new Titles(rs.getInt("title_id"), rs.getString("title_name"), rs.getInt("subject_id"), rs.getInt("publisher_id")) );
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return booksByAuthor;
	}
	
	/*ASSIGNMENT 2.
	 * Given the name of the book, to be issued by an existing member.
	 * Return flag to indicate whether the  the book has been issued or not.
	 */
	public boolean issueBook(String book_name, int member_id) {
		String query = "SELECT accession_number" + 
						" FROM books" + 
						" WHERE status = 1"	//status = 1 is book is available; 0 = issued
						 + " AND title_id ="+
						   " (SELECT T.title_id" + 
						   " FROM titles T" + 
						   " WHERE title_name = '"+ book_name +"');";
		
		try {
			ResultSet result = db_connection.getData(query);
			if(result.next()) {
				int accession_number = result.getInt("accession_number");
				
				/** Add book issue
				 * with associated author
				 * update status of available book's accession number to issued(false)
				 **/
				String addEntry = " INSERT INTO book_issue(accession_number, member_id)"
								+ " VALUES("+accession_number+","+member_id+")";
				
				return db_connection.setData(addEntry);
			}else {
				//If all the books for said name are already issued
				return false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/*ASSIGNMENT 3.
	 * Delete all those books which were not issued in last 1 year. 
	 * Return the number of books deleted.
	 */
	public int deleteUnissuedBooks() {
		int count = 0;
		String query = "SELECT * FROM books"
					 + " WHERE accession_number NOT IN"
					 + " (SELECT BI.accession_number"
					 + " FROM book_issue AS BI"
					 + " WHERE timestampdiff(YEAR, BI.issue_date, NOW()) < 1);";
		
		try {
			ResultSet rs = db_connection.getData(query);
			while(rs != null && rs.next()) {
				count++;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
	
/**********VALIDATION QUERIES *********/
	/**@Method	getMember(int member_id)
	 * search the database if the member id is valid
	 * @return	type = Members, if valid member object
	 **/
	public Members getMember(int member_id){
		String query = "SELECT * "
					+ " FROM members"
					+ " WHERE member_id = "+member_id+";";
		
		try {
			ResultSet rs = db_connection.getData(query);
			
			if(rs.next() ) {
				return new Members(rs.getInt("member_id"), rs.getString("member_name"), rs.getString("address_line1"), rs.getString("address_line2"), rs.getString("category"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**@Method	getAuthor(String author_name)
	 * Get instance of author if valid author name
	 * @return	type = Author, get instance of author from the author name
	 * 			or null, if this author name does not exist in DB
	 **/
	public Author getAuthor(String author_name){
		String query = "SELECT * "
					+ " FROM author"
				    + " WHERE author_name = '"+author_name+"';";
		
		try {
			ResultSet rs = db_connection.getData(query);
			
			if(rs != null && rs.next() ) {
				return new Author(rs.getInt("author_id"), rs.getString("author_name"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**@Method 	getBookTitle(String title_name)
	 * if a book of said title exists in DB, return the object associated with the title name
	 * else return null
	 * @return	type = Titles, POJO for valid book title details
	 **/
	public Titles getBookTitle(String title_name){
		String query = "SELECT * "
					+ " FROM titles"
				    + " WHERE title_name = '"+title_name+"';";
		
		try {
			ResultSet rs = db_connection.getData(query);
			
			if(rs != null && rs.next() ) {
				return new Titles(rs.getInt("title_id"), rs.getString("title_name"), rs.getInt("subject_id"), rs.getInt("publisher_id"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Helper class to validate DB operations
	 **/
	public static void main(String[] args) {
		LISdao lis = new LISdao();
		//validation
		System.out.println( lis.getAuthor("booyah") == null);
		System.out.println( lis.getAuthor("Green").getAuthorName() );
		System.out.println( lis.getAuthor(null) == null);
		
		System.out.println( lis.getBookTitle("booyah") == null);
		System.out.println( lis.getBookTitle("Harry Potter").getTitleName());
		System.out.println( lis.getBookTitle(null) == null );
		
		System.out.println( lis.getMember(0)  == null);
		System.out.println( lis.getMember(5).getMember_name());
		System.out.println( lis.getMember(-90) == null);
		
		System.out.println("\n\n\n\n\n\n\n");
		
		//query operations
		System.out.println( lis.getBooksByAuthor("Black").size());
		System.out.println( lis.issueBook("Around the world", 1));
		System.out.println( lis.deleteUnissuedBooks() );
	}
}