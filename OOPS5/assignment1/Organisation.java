package assignment1;

public class Organisation extends Entity{
	private String domain;

	public Entity setValues(String user_profile) {
		String[] values = user_profile.trim().split(",");
		
		if(user_profile != null && values  != null && values.length > 0) {
			this.id			= Integer.parseInt(values[0].trim());
			this.type		= values[1].trim();
			this.user_name  = values[2];
			
			this.domain 	= values[3];
		}
		return this;
	}

	public String getDomain() {
		return domain;
	}


}
