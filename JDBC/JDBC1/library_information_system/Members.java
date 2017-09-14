package library_information_system;

/**@Class	Members
 * all members enlisted in the LIS
 **/
public class Members {
	private int memberId;
	private String member_name;
	private String address_line1;
	private String address_line2;
	private String category;

	public Members(int memberId, String member_name, String address_line1, String address_line2, String category) {
		super();
		this.memberId = memberId;
		this.member_name = member_name;
		this.address_line1 = address_line1;
		this.address_line2 = address_line2;
		this.category = category;
	}
	
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getAddress_line1() {
		return address_line1;
	}
	public void setAddress_line1(String address_line1) {
		this.address_line1 = address_line1;
	}
	public String getAddress_line2() {
		return address_line2;
	}
	public void setAddress_line2(String address_line2) {
		this.address_line2 = address_line2;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
