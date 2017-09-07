package assignment4;

class Node {
	Object data;
	Node next;
	Node previous;
	
	Node(){
		this.next = null;
		this.previous = null;
	}
	
	Node(Object data){
		this.data = data;
		this.next = null;
	}
	
	Object getElement(){
		return this.data;
	}
}
