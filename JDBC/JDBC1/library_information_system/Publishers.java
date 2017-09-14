package library_information_system;

/**@Class	Publishers
 * publishers for associated books
 **/
public class Publishers {
	private int publisher_id;
	private String publisher_name;
	
	public Publishers(int publisher_id, String publisher_name) {
		super();
		this.publisher_id = publisher_id;
		this.publisher_name = publisher_name;
	}
	
	public int getPublisher_id() {
		return publisher_id;
	}
	
	public void setPublisher_id(int publisher_id) {
		this.publisher_id = publisher_id;
	}
	
	public String getPublisher_name() {
		return publisher_name;
	}
	
	public void setPublisher_name(String publisher_name) {
		this.publisher_name = publisher_name;
	}	
}
