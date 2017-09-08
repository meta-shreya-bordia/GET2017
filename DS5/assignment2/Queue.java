package assignment2;

import java.util.*;

public class Queue<E extends Object> {
	private List<E> queue;
	private final int HEAD = 0;
	
	public Queue() {
		queue = new LinkedList<E>();
	}
	
	/**@Method	add(E element)
	 * Inserts the specified element into this queue
	 * @return	type = boolean,
	 * 			throws NullPointerException() is element is null
	 **/
	public boolean add(E element) {
		if( element == null) {
			throw new NullPointerException();
		}
		
		queue.add( queue.size() , element);
		return true;
	}
	
	/**@Method	offer()
	 * add element without throwing exception
	 * @return	type = boolean, does not throw an exception
	 **/
	public boolean offer(E element){
		if( element == null ){
			return false;
		}
		
		queue.add( queue.size() , element);
		return true;
	}
	
	/**@Method	element()
	 * Retrieves, but does not remove, the head of this queue.
	 * @return	type = E, element at head of queue
	 * 			throws NoSuchElementException when queue is empty
	 **/
	public E element() {
		if( isEmpty() ){
			throw new NoSuchElementException();
		}
		
		return queue.get(HEAD);
	}
	
	/**@Method	peek()
	 * Retrieves, but does not remove, the head of this queue,
	 *  or returns null if this queue is empty.
	 * @return	type = E, element at the top of the queue
	 **/
	public E peek() {
		if( isEmpty() ){
			return null;
		}
		
		return queue.get(HEAD);
	}
	
	/**@Method	poll()
	 * Retrieves, but does not remove, the head of this queue,
	 *  or returns null if this queue is empty.
	 * @return	does not throw an exception, return null 
	 **/
	public E poll() {
		if( isEmpty() ){
			return null;
		}
		
		return queue.remove(HEAD);
	}
	
	/**@Method	remove
	 * Retrieves and removes the head of this queue.
	 * @return	type = E, element at the head of the queue
	 * 			throws NoSuchElementException when queue is empty
	 **/
	public E remove() {
		if( isEmpty() ){
			throw new NoSuchElementException();
		}
		
		return queue.remove(HEAD);
	}

	public boolean isEmpty(){
		return (queue.size() == 0);
	}
	
	/**@Method	size()
	 * @return	type = int, number of elements in the queue
	 **/
	public int size(){
		return queue.size();
	}
}
