package library_information_system;

/**@Class	TitleAuthor
 * unique identification relation
 * between title and author
 * (One title can have multiple authors
 * Same name titles by different authors)
 **/
public class TitleAuthor {
	private int title_id;
	private int author_id;
	public TitleAuthor(int title_id, int author_id) {
		super();
		this.title_id = title_id;
		this.author_id = author_id;
	}
	public int getTitle_id() {
		return title_id;
	}
	public void setTitle_id(int title_id) {
		this.title_id = title_id;
	}
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	
	
}
