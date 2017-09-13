package library_information_system;

/**@Class	Titles
 * book ISBN number
 * and associated title
 **/
public class Titles {
	private int title_id;
    private String title_name;
    private int subject_id;
    private int publisher_id;
	public Titles(int title_id, String title_name, int subject_id, int publisher_id) {
		this.title_id = title_id;
		this.title_name = title_name;
		this.subject_id = subject_id;
		this.publisher_id = publisher_id;
	}
	
	public int getTitleId() {
		return title_id;
	}
	public void setTitleId(int title_id) {
		this.title_id = title_id;
	}
	public String getTitleName() {
		return title_name;
	}
	public void setTitleName(String title_name) {
		this.title_name = title_name;
	}
	public int getSubjectId() {
		return subject_id;
	}
	public void setSubjectId(int subject_id) {
		this.subject_id = subject_id;
	}
	public int getPublisherId() {
		return publisher_id;
	}
	public void setPublisherId(int publisher_id) {
		this.publisher_id = publisher_id;
	}
}