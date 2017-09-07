package assignment2;

public class Node<E>{
	private E data;
	Node left;
	Node right;
	
	public Node(E data){
		this.data = data;
	}
	
	public E getElement(){
		return this.data;
	}
}
