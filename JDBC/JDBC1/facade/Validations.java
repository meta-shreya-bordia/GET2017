package facade;

import dao.LISdao;

/**@Class	Validations
 * check valid user input
 **/
public class Validations {
	LISdao lis;
	
	public Validations() {
		lis = new LISdao();
	}
	
	/*@Method	checkMemberId(int memberId)
	 * check valid member id entry, return true
	 * @return	type = boolean
	 */
	public boolean checkMemberId(int memberId) {
		return (lis.getMember(memberId) == null)? false : true;
	}
	
	/*@Method	checkBookName(String bookName)
	 * check valid book name entry
	 * @return	type = boolean
	 */
	public boolean checkBookName(String bookName) {
		return (lis.getBookTitle(bookName) == null)? false : true;		
	}
	
	/*@Method	checkAuthorName(String authorName)
	 * check valid author name entry
	 * @return	type = boolean
	 */
	public boolean checkAuthorName(String authorName) {
		return (lis.getAuthor(authorName) == null)? false : true;
	}
}
