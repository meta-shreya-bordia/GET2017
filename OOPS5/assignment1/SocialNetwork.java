package assignment1;

import java.util.*;
import java.util.Map.Entry;

/**@Class	SocialNetwork
 * Controller class for the social network interface
 * Execution of program starts here
 * */
public class SocialNetwork {
	/**Files to access*/
	private static String read_user_profiles   = "UserProfile.csv";
	private static String read_user_connection = "Connection.csv";
	
	/**Main menu items covered*/
	public static void main(String[] args) {
		showAllUserProfiles();
		showAllConnections();
		Node current_user = Graph.getProfileByName();
		showProfile(current_user);
		
		Scanner input = new Scanner(System.in);
		System.out.println("Do you want to add a new user? Y/N");
		
		if("y".equals(input.nextLine().trim().toLowerCase())){
			Record.insertNewUser();
		}
		
		System.out.println("Do you want to add a new connection? Y/N");
		
		if("y".equals(input.nextLine().trim().toLowerCase())){
			System.out.println("Enter name of user you want to connect to:");
		
			String user_to_connect_to = input.nextLine();
			Record.insertNewConnection(current_user, user_to_connect_to);
		}
		
		input.close();
		/** 1. Show list of all available users (People and organisation)
		 *  2. Show list of all connections 
		 *  3. Scan user input to view summary details(user details and their connections)
		 *  4. Add a new connection/user
		 *  5. Print the updated connection list
		 *  6. Search for Nodes by name
		 * **/
	}
	
	/**Print the list of all valid users existing**/
	public static void showAllUserProfiles() {
		System.out.println("\n\nVIEW ALL USERS");
		
		//Iterating the data_file from list of nodes
		Map<Integer, Node> hm = Graph.readUserProfiles(read_user_profiles);
		Set<Entry<Integer, Node>> set = hm.entrySet(); 
		Iterator<Entry<Integer, Node>> i = set.iterator();
		
		while(i.hasNext()) {
			Map.Entry<Integer, Node> me = (Map.Entry<Integer, Node>) i.next();
			System.out.println(me.getValue().getEntity().getType() + " : "+ me.getValue().getEntity().getUserName() );
		}
	}
	
	/**@Method	showAllConnections()
	 * Print the list of all valid connections for a user
	 * @return	type = void
	 * **/
	public static void showAllConnections() {
		System.out.println("\n\nVIEW ALL USERS ALL CONNECTIONS");
		Map<Node, Connection> hm = Graph.readUserConnections(read_user_connection);
		
		Set<Entry<Node, Connection>> set = hm.entrySet(); 
		Iterator<Entry<Node, Connection>> i = set.iterator();
		
		while(i.hasNext()) {
			Map.Entry<Node, Connection> me = (Map.Entry<Node, Connection>) i.next();
			System.out.println( me.getKey().getEntity().getUserName() + " is connected to ");
			
			List<Node> connect = me.getValue().getConnections();
			for(int j=0; j< connect.size(); j++) {
				System.out.println("\t\t" + connect.get(j).getEntity().getUserName());
			}
		}
	}
	
	/**@Method showAllConnections()
	 * calls appropriate sub class that holds sub values
	 * @return type =void, updates connections
	 * **/
	public static void showProfile(Node current_user){
		//System.out.println("user"+  ("user".equals(current_user.getEntity().getType())));
		//System.out.println("organisation".equals(current_user.getEntity().getType()));
		
		if(current_user == null){
			System.out.println("wrong credentials");
		}else if("user".equals(current_user.getEntity().getType())){
			showSpecificUserProfile(current_user);
		}else if("organisation".equals(current_user.getEntity().getType())){
			showSpecifiOrganisationProfile(current_user);
		}
	}
	
	/**@method		showSpecificUserProfile(Node current_user)
	 * display result only for people sub type entity
	 *  summaries differ as each type holds different values
	 * **/
	public static void showSpecificUserProfile(Node current_user){
		System.out.println("Hello, "+ current_user.getEntity().getUserName() +". Welcome to the social network."
				+ "\nHere are your details:\t"
				+ "\nYour login id is:\t"    + current_user.getEntity().getId()
				+ "\nYour current age is:\t" + ( (People) current_user.getEntity()).getAge()
				+ "\nYour hobbies include:\t"+ ( (People)current_user.getEntity()).getHobbies() );
	
		findConnections(current_user);
	}
	
	/**@method		showSpecificOrganisationProfile(Node current_user)
	 * display result only for organisation sub type entity
	 *  summaries differ as each type holds different values
	 * **/
	public static void showSpecifiOrganisationProfile(Node current_user){
		System.out.println("Hello, "+ current_user.getEntity().getUserName() +". Welcome to the social network."
				+ "\nHere are your details: "
				+ "\nYour login id is: \t"+ current_user.getEntity().getId()
				+ "\nYour Domain is:   \t"+ ((Organisation) current_user.getEntity()).getDomain()
			);
		findConnections(current_user);
	}
	
	public static void findConnections(Node current_user){
		System.out.println("Here are your connections: ");
		
		List<Node> all_connections = new ArrayList<Node>();
		if(Graph.getUserConnections() != null && Graph.getUserConnections().get(current_user)!= null){
			all_connections = Graph.getUserConnections().get(current_user).getConnections();
		
			if(all_connections != null && all_connections.size() > 0){
				for(int i=0; i< all_connections.size(); i++)
				System.out.println("\t"+all_connections.get(i).getEntity().getUserName());
			}
		}else{
			System.out.println("You are not connected to anyone."
							+"\n Connect now?");		
		}
	}
}
