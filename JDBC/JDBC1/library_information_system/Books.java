package library_information_system;

/**@Class	Books
 * maintain logs of all the books purchased
 * their cost price
 * their unique key: accessionNumber
 * and status (issued/available)
 **/
public class Books {
	private int accessionNumber;
	private int titleId;
	private String purchaseDate;
	private float price;
	private int status;
	
	public Books(int accessionNumber, int titleId, String purchaseDate, float price, int status) {
		super();
		this.accessionNumber = accessionNumber;
		this.titleId = titleId;
		this.purchaseDate = purchaseDate;
		this.price = price;
		this.status = status;
	}
	
	public int getAccessionNumber() {
		return accessionNumber;
	}
	
	public void setAccessionNumber(int accessionNumber) {
		this.accessionNumber = accessionNumber;
	}
	public int getTitleId() {
		return titleId;
	}
	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
