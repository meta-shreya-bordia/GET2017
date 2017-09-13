package library_information_system;

/**@Class	BookIssue
 * maintain log of all the books issued
 * and their corresponding due dates
 **/
public class BookIssue {
	private String issue_date;
	private int accession_number;
	private int member_id;
	private String due_date;
	
	public BookIssue(String issue_date, int accession_number, int member_id, String due_date) {
		super();
		this.issue_date = issue_date;
		this.accession_number = accession_number;
		this.member_id = member_id;
		this.due_date = due_date;
	}
	public String getIssueDate() {
		return issue_date;
	}
	public void setIssueDate(String issue_date) {
		this.issue_date = issue_date;
	}
	public int getAccessionNumber() {
		return accession_number;
	}
	public void setAccessionNumber(int accession_number) {
		this.accession_number = accession_number;
	}
	public int getMemberId() {
		return member_id;
	}
	public void setMemberId(int member_id) {
		this.member_id = member_id;
	}
	public String getDueDate() {
		return due_date;
	}
	public void setDueDate(String due_date) {
		this.due_date = due_date;
	}
}
