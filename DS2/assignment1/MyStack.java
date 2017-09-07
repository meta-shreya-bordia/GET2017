package assignment1;

public class MyStack<E extends Comparable<E>> {
	private IList<E> stack;
	private static final int TOP_OF_STACK =0;
	
	public MyStack(){
		stack = new SinglyLinkedList<E>();		
	}
	
	public E pop() {
		Node popped = stack.remove(TOP_OF_STACK); 
		return (E)popped.getElement();
	}
	
	public void push(E element) {
		stack.add(TOP_OF_STACK, element);;
	}
	
	public boolean isEmpty() {
		return ( stack.get(TOP_OF_STACK) == null );
	}
	
	public E peek(){
		return stack.get(TOP_OF_STACK);
	}
}
