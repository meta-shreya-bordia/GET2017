package assignment1;

public class Node<E> {
	private E data;
	Node left;
	Node right;
	
	Node(){
		
	}
	
	public Node(E element){
		this.data = element;
	}
	
	public E getElement(){
		return (E)this.data;
	}
}
