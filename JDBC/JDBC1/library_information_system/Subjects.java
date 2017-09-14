package library_information_system;

/**@Class	Subjects
 * genre for different book domains
 **/
public class Subjects {
	private int subject_id;
	private String subject_name;
	
	public Subjects(int subject_id, String subject_name) {
		this.subject_id = subject_id;
		this.subject_name = subject_name;
	}
	
	public int getSubjectId() {
		return subject_id;
	}
	
	public void setSubjectId(int subject_id) {
		this.subject_id = subject_id;
	}
	
	public String getSubjectName() {
		return subject_name;
	}
	
	public void setSubjectName(String subject_name) {
		this.subject_name = subject_name;
	}	
}
