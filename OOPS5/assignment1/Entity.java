package assignment1;

/**@Class	Entity
 * Base class that defines the different types of users
 * in the networking site
 * Type can be people or organisation
 * **/

public class Entity {
	protected int id;
	protected String type;
	protected String user_name;
	
	/** default getters to access private data items*/
	public int getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getUserName() {
		return user_name;
	}

	public Entity() {
		
	}
	
	/**@Method	setValues(String user_profile)
	 * downcast to appropriate user class
	 * @return	type = Entity, initialized entity type objects
	 * **/
	public Entity setValues(String user_profile) {
		if(user_profile.trim().contains("user")){
			return new People().setValues(user_profile);
		}else if(user_profile.trim().contains("organisation")) {
			return new Organisation().setValues(user_profile);
		}
		return null;
	}	
}	 	