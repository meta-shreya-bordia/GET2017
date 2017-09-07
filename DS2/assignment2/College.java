package assignment2;

public class College {
	private int collegeRank;
	private String collegeName;
	private int totalSeats;
	private int seatsFilled;
	
	public College(){
		
	}
	
	public College(int rank, String collegeName, int totalSeats){
		this.collegeRank = rank;
		this.collegeName = collegeName;
		this.totalSeats  = totalSeats;
	}
	
	public int getCollegeRank() {
		return collegeRank;
	}
	public void assignCollegeRank(int collegeRank) {
		this.collegeRank = collegeRank;
	}
	
	public int getTotalSeats() {
		return totalSeats;
	}
	public void updateTotalSeats() {
		this.totalSeats = totalSeats+1;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public int getSeatsFilled() {
		return seatsFilled;
	}
}
