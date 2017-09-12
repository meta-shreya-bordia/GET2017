package assignment1;

class Node<E extends Comparable> {

	private E data;
	Node<E> left;
	Node<E> right;
	
	Node( E element){
		this.data = element;
	}
	
	E getElement() {
		return this.data;
	}
}
