package assignment1;

public class Node {
	Entity entity;
	Connection connected_to;
	
	public Node(Entity new_user) {
		this.entity = new_user;
		connected_to = new Connection();
	}
	
	public void addAConnection(Node node_to_add) {
		this.connected_to.addAConnection(node_to_add);
	}

	public Entity getEntity() {
		return this.entity;
	}

	public Connection getConnectionTo() {
		return connected_to;
	}
	
}
