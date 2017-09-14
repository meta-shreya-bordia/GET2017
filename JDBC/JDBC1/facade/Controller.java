package facade;

import java.util.List;

import dao.LISdao;
import library_information_system.Titles;

/**@Method	Controller
 * access the database for accessing the query
 * and validate user input
 **/
public class Controller {
	LISdao lis;
	
	public Controller(){
		lis = new LISdao();
	}
	
	/*@Method	getBooksByAuthor(String authorName)
	 * get book titles for books written by the author
	 * (if multiple author name are same, return books by all these authors)
	 */
	public String getBooksByAuthor(String authorName){
		List<Titles> booksByAuthor = lis.getBooksByAuthor(authorName);

		if( booksByAuthor.size() == 0){
			return "Sorry, we do not have any books by this author";
		}else{
			String bookTitles = "Books by author: "+authorName+" are: ";
			
			for(Titles title: booksByAuthor ){
				bookTitles += "\n"+title.getTitleName();
			}
			return bookTitles;
		}
	}
	
	/*@Method	issueABook(String bookName, int memberId)
	 * insert into database if book is not already issued
	 * and then issue to said member
	 * else return availability is null
	 * @return	type = String, display status of book_allotment
	 */
	public String issueABook(String bookName, int memberId){
		if( ! lis.issueBook(bookName, memberId) ){
			return "Dear member, "+memberId+" all books by the title '"+bookName+"' are unavailable";
		}else{
			return "Dear member, "+memberId+" you have been issued book: "+bookName;
		}
	}
	
	/*@Method	deleteUnusedBooks()
	 * delete un-issued books for one year
	 * (cascade delete records of past issues and returns)
	 * @return	type = String, return count of books deleted from LIS
	 */
	public String deleteUnusedBooks(){
		int numberOfBooksDeleted = lis.deleteUnissuedBooks();
		if( numberOfBooksDeleted == 0){
			return "No book has been deleted";
		}else{
			return "Unissued for one year: "+ numberOfBooksDeleted+" have been deleted from record";
		}
	}
}
