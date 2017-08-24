package assignment1;

class Node<E extends Object> {
	private E data;
	Node<E> next;
	
	Node(){
		this.next = null;
	}
	
	Node(E data){
		this.data = data;
		this.next = null;
	}
	
	E getElement(){
		return this.data;
	}
}
