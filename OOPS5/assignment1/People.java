package assignment1;

public class People extends Entity{
	private int age;
	private String hobbies; 
	
	public Entity setValues(String user_profile) {
		String[] values = user_profile.trim().split(",");
		
		if(user_profile != null && values  != null && values.length > 0) {
			this.id			= Integer.parseInt(values[0].trim());
			this.type		= values[1].trim();
			this.user_name  = values[2].trim();
			
			this.age 		= Integer.parseInt(values[3].trim());
			this.hobbies 	= values[4].trim();
		}
		return this;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String getHobbies() {
		return this.hobbies;
	}

}
