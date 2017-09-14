package library_information_system;

/**@Class	Author
 * book writer
 * Author id to uniquely identify an author
 * and corresponding name
 **/
public class Author {
	private int author_id;
	private String author_name;

	Author(){
		
	}
	
	public Author(int id, String name) {
		this.author_id = id;
		this.author_name = name;
	}
	
	public int getAuthorId() {
		return author_id;
	}
	public String getAuthorName() {
		return author_name;
	}
	
	
}
