package assignment1;

import java.util.*;

/**@Class	Connection
 * create an edge between two nodes
 * for directed graph
 * */
public class Connection{
	//Adjacency list of a node for a node
	private List<Node> connections;
		
	public Connection(){
		connections = new ArrayList<Node>();
	}
	
	//Return list of all nodes connected to this node
	public List<Node> getConnections(){
		return this.connections;
	}
	
	//create an edge between two nodes
	public void addAConnection(Node n2) {
		this.connections.add(n2);
	}
}
