package assignment1;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * @Class	Graph
 * establishes connections between two entities
 * maintains mapping of connection of each to other user
 * */

public class Graph {
	private static BufferedReader reader;
	
	//Map of all entity profiles
	private static Map<Integer, Node> user_profiles = new HashMap<Integer, Node>();	
	//Map of all connections of each node
	private static Map<Node, Connection> user_connections = new HashMap<Node, Connection>();
	
	public static Map<Integer, Node> getUserProfiles() {
		return user_profiles;
	}

	public static Map<Node, Connection> getUserConnections() {
		return user_connections;
	}
	
	/**
	 * @method	getProfileByName()
	 * search an entity from a map of entities
	 * when duplicate names are found,
	 * their unique ids are compared by user input
	 * @return	Node: current user's profile details 
	 * */
	public static Node getProfileByName() {
		Scanner input = new Scanner(System.in);
		System.out.println("\n\nEnter you name to login");
		String user_name = input.nextLine();
		
		/**To remove upper limit on number of possible matches
		 * iterating a list of duplicate names lists
		 * **/
		List<Node> matched_nodes = new ArrayList<Node>();
		Set<Entry<Integer, Node>> set = user_profiles.entrySet(); 
		Iterator<Entry<Integer, Node>> i = set.iterator();
		
		while(i.hasNext()) {
			Map.Entry<Integer, Node> me = (Map.Entry<Integer, Node>) i.next();
			
			if( user_name != null && me.getValue().getEntity().getUserName().trim().equals(user_name.trim())) {
				matched_nodes.add(me.getValue());
			}
		}
		
		/**
		 * if no matched node found, then incorrect user id
		 * When multiple matches of same name
		 * */
		if(matched_nodes != null && matched_nodes.size() > 0) {
			if(matched_nodes.size() == 1) {
				return matched_nodes.get(0);
			}
			System.out.println("Enter your user id: ");
			int id = input.nextInt();
			
			for(int j =0; j< matched_nodes.size(); j++) {
				if(matched_nodes.get(j).getEntity().getId() == id) {
					return matched_nodes.get(j);
				}
			}
			return null;
		}
		input.close();
		return null;
	}

	/**@Method	readuserProfiles(filename)
	 * reads all user profile and details from UserProfile.csv
	 * @return	mapping of unique id codes and other profile details
	 * **/
	public static Map<Integer, Node> readUserProfiles(String filename){
		try {
			reader = new BufferedReader(new FileReader(new File(filename)));
			
			String user_details;
			
			while((user_details = reader.readLine()) != null) {	
				Entity u = new Entity().setValues(user_details);
				user_profiles.put(u.getId(), new Node(u));
			}			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return user_profiles;
	}
	
	/**
	 * @Method	readUserConnections(filename)
	 * read connect of each user to other users in user profile
	 * determines relationship between users
	 * @return	type = Map<Node, Node[]> each node connected to array of nodes
	 * */
	public static Map<Node, Connection> readUserConnections(String filename){
		try {
			reader = new BufferedReader(new FileReader(new File(filename)));
			
			String connection;
			while((connection = reader.readLine()) != null) {
				addAConnection(connection);
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		return user_connections;
	}

	/**
	 * @Method	addAConnection(String line)
	 * read user connections from file
	 * creating and updating nodes by creating a connection between them
	 * **/
	public static void addAConnection(String line) {
		String[] s = line.trim().split(":");

		Node n1, n2;
		if (line != null && s.length > 0 && (n1 = isValidNode(s[0])) != null) {
			String[] s1 = s[1].trim().split(",");

			if (s[1] != null && s1.length > 0) {
				for (String connection : s1) {
					if ((n2 = isValidNode(connection)) != null) {						
						n1.addAConnection(n2);
					}
				}
				user_connections.put(n1, n1.connected_to);
			}
		}
	}
	
	/**
	 * @method	isValidNode(String id)
	 * validate a user input product id that is mapped to appropriate user entity
	 * @return	type = Node, if null, invalid product code
	 * 						else valid node reference
	 * */
	public static Node isValidNode(String id) {
		int user_id = Integer.parseInt(id.trim());
		if ( user_id != -1 && user_profiles.size() >0 && user_profiles.containsKey(user_id) ) {
			return user_profiles.get(user_id);
		}
		return null;		
	}
}
