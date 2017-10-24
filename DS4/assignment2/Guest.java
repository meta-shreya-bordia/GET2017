package assignment2;

public class Guest {
	private String guestName;
	private int guestAge;
	private int roomAlloted;
	
	public Guest() {
		
	}
	
	public Guest(String name, int age) {
		this.guestName = name;
		this.guestAge  = age;
	}
	
	public void allocateRoom(int roomNumber) {
		this.roomAlloted = roomNumber;
	}

	public String getGuestName() {
		return guestName;
	}

	public int getGuestAge() {
		return guestAge;
	}

	public void setRoomAlloted(int roomNumber){
		this.roomAlloted = roomNumber;
	}
	
	public int getRoomAlloted() {
		return roomAlloted;
	}
}
