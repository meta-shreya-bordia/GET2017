package view;

import java.util.Scanner;
import facade.*;

/**@Class	UI
 * User interface for console based interaction
 * between user and LIS application
 **/
public class UI {
	Scanner input;
	Validations check;
	Controller controller;
	
	public UI(){
		input = new Scanner(System.in);
		check = new Validations();
		controller = new Controller();
	}
	
	public static void main(String[] args){
		UI userConsole = new UI();
		
		while(true){
			userConsole.displayMenu();
			userConsole.performAction( userConsole.getOption() );
		}
	}
	
	/*@Method	displayMenu()
	 * display options available for end-user
	 */
	public void displayMenu(){
		System.out.println("1. View books by author"
					   + "\n2. Issue a book"
				       + "\n3. Delete un-issued books"
					   + "\n4. Exit");
	}
	
	/*@Method	getOption()
	 * user input for option from the menu
	 * @return	type = int, option number
	 */
	public int getOption(){
		System.out.println("Enter your option:");
		int option = input.nextInt();
		
		while(option <= 0 || option > 4){
			System.out.println("Invalid choice"
					+ "\nEnter valid option:");
			option = input.nextInt();
		}
		
		return option;
	}
	
	/*@Method	performAction(int option)
	 * perform appropriate action upon opotion selection
	 */
	public void performAction(int option){
		switch( option ){
		case 1: 
			System.out.println( controller.getBooksByAuthor( getAuthorName() ) );
			break;
		case 2:
			System.out.println( controller.issueABook(getBookName(), getMemberId()));
			break;
		case 3:
			System.out.println( controller.deleteUnusedBooks() );
			break;
		case 4: System.exit(0);
		}
	}
	
	/*@Method	getMemberId()
	 * get user's member id for issuing a book
	 */
	public int getMemberId(){
		System.out.println("Enter your member id:");
		int memberId = input.nextInt();
		
		while( !check.checkMemberId(memberId) ){
			System.out.println("Invalid member id details"
					+ "\nEnter valid id:");
			memberId = input.nextInt();
		}
		
		return memberId;
	}
	
	/*@Method	getBookName()
	 * user input to issue book by book name
	 */
	public String getBookName(){
		System.out.println("Enter book name:");
		input.nextLine();
		String bookName = input.next();
		
		while( !check.checkBookName(bookName) ){
			System.out.println("Invalid book name"
						+ "\nEnter valid book name:");
			input.nextLine();
			bookName = input.next();
		}
		
		return bookName;
	}
	
	/*@Method	getAuthorName()
	 * get user input for searching/listing by author name
	 */
	public String getAuthorName(){
		System.out.println("Enter Author name to search:");
		String authorName = input.next();
		
		while( !check.checkAuthorName(authorName) ){
			System.out.println("Invalid author name"
					+ "\nEnter valid author name:");
			authorName = input.next();
		}
		
		return authorName;
	}
}
