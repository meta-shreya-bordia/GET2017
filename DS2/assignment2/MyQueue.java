package assignment2;

/**
 *  a)void enqueue( item )  - Adding an Object item
	b)Object dequeue( ) -  Remove and return the least recent item inserted
	c)void makeEmpty( ) -  Remove all items of queue and make queue empty
	d)Object getFront( ) - Return least recently inserted item

 **/
public class MyQueue<E extends Object> {
	private Object[] queue;
	private int head, rear;
	
	private final int DEFAULT_SIZE = 10;
	private int size = DEFAULT_SIZE;
	
	public MyQueue() {
		queue= new Object[size];
		head = -1; rear = -1;
	}
	
	public void enqueue(E element) {
		//adding to an empty queue
		if((rear-head) == size) {
			resize();
		}
		
		if(isEmpty()) {
			head = 0;
		}
		
		queue[++rear] = element;
	}
	
	/**
	 * Trade-off between space and time complexity
	 * updating the head pointer of array can lead to memory space running out
	 * however, shifting per dequeue O(m*n) leads to timeouts
	**/
	public Object dequeue() {
		if(isEmpty()) {
			throw new NullPointerException();
		}
		
		return queue[head++];	//update the head pointer
	}
	
	/**@Method makeEmpty()
	 * since memory is garbage collected
	 * no need to nullify each element 
	 * update the size of the queue, start and end pointers
	 **/
	public void makeEmpty() {
		this.queue = new Object[DEFAULT_SIZE];
		size = DEFAULT_SIZE;
		head = -1; rear = -1;
	}
	
	/**@Method	getFront()
	 * peek element at the start(head) of queue
	 * without removing it from queue
	 **/
	public Object getFront() {
		if(isEmpty()) {
			throw new NullPointerException();
		}
		
		return this.queue[head];
	}
	
	/**
	 * Solution to memory leaks:
	 * resizing when an element is added to queue 
	 * also, resizing when too many elements have been deleted
	 **/
	//iterative copy and resizing the array: O(old_size)
	private void resize() {
		size *= 2;
		Object[] copyTo = new Object[size];
		for(int index=0; index<size/2; index++) {
			copyTo[index] = this.queue[head + index];
		}
		this.queue = copyTo;
	}
	
	/**@Method	isEmpty()
	 * check if head & rear are at same position & head pointer is negative
	 * @return	type = boolean
	 **/
	private boolean isEmpty() {
		return (head == -1 & head == rear);
	}
	
	public int size() {
		if(head == -1)
			return 0;
		
		return rear-head;
	}
}
