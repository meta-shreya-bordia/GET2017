package assignment3;

public class SinglyLinkedList implements IList{
	private Node head;
	private int total_elements;
	
	public SinglyLinkedList(){
		head = new Node();
	}
	
	@Override
	public void add(int index, Object element) {
		isValidIndex(index);
		
		Node add_node = new Node(element);
		
		//Insert to start of list
		if(index == 0){
			//when list is not empty
			if(this.head != null ){
				add_node.next = this.head;
			}
			this.head = add_node;
			total_elements++;
			return;
		}
		
		//else: iterate to position
		Node previous 	  = new Node();
		Node current_node = this.head;
		int iterater = index;
		
		while(current_node!= null & iterater < index){
			previous = current_node;
			current_node = current_node.next;
			iterater++;
		}
		
		add_node.next = previous.next;
		previous.next = add_node;
		
		total_elements++;
	}

	@Override
	public boolean remove(int index) {
		isValidIndex(index);
		
		//removing an element at the start of list
		if(index == 0){
			this.head = this.head.next;
			return true;
		}
		
		//else, iterate to the position
		Node previous = new Node();
		Node current_node = this.head;
		int iterater = 0;
		
		while(current_node!=null & iterater < index){
			previous = current_node;
			current_node = current_node.next;
			iterater++;
		}
		
		//remove from end of list: current node to r
		
		return true;
	}

	@Override
	public boolean remove(Object element) {			
		Node previous = null;
		Node current_node = this.head;
		
		while(current_node!= null & current_node.data != element){
			previous = current_node;
			current_node = current_node.next;
		}
		
		//element does not belong to list
		if(current_node == null){
			return false;
		}
		
		//if found at first position
		if(previous == null){
			this.head = this.head.next;
			return true;
		}
		
		previous.next = current_node.next; //dereference the node
		return true;
	}

	@Override
	public Object get(int index) {
		isValidIndex(index);
		
		Node current_node = this.head;
		int iterater = 0;
		
		while(iterater < index){
			current_node = current_node.next;
			iterater++;
		}
		
		return current_node.data;
	}

	// non recursive iteration: O(n)
	@Override
	public void reverse() {
		if(this.head == null || this.head.next == null) {
			return;
		}
		
		Node previous = null;
		Node current_node = this.head;
		
		while(current_node != null) {
			Node next_ptr = current_node.next;
			current_node.next = previous;
			previous = current_node;
			
			current_node = next_ptr;
		}
		
		this.head = previous;
	}

	//merge sort: compareTo
	@Override
	public void sort() {
		
	}
	
	private boolean isValidIndex(int index){
		if(this.head == null || index < 0 || index > total_elements){
			throw new IndexOutOfBoundsException();
		}
		
		return true;
	}
}
