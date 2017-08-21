package assignment3;

class Node {
	Object data;
	Node next;
	
	Node(){
		this.next = null;
	}
	
	Node(Object data){
		this.data = data;
		this.next = null;
	}
	
	Object getElement(){
		return this.data;
	}
}
