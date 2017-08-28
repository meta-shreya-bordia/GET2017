package assignment4;

public class DoublyLinkedList implements IList{
	private Node head;
	private int total_elements;
	
	public DoublyLinkedList(){
		this.head = null;
	}
	
	@Override
	public void add(int index, Object element) {
		isValidIndex(index);
		
		Node add_node = new Node(element);
		
		//insertion at start of list
		if(index == 0){
			if(this.head != null){
				add_node.next = this.head;
			}
			this.head = add_node;
			
			total_elements++;
			return;
		}
		
		//else iterate to that position
		Node current_node = this.head;
		int iterator = 0;
		
		while(iterator < index){
			current_node = current_node.next;
			iterator++;
		}
		
		add_node.next = current_node.next;
		add_node.previous = current_node;
		
		//if adding at the last position 
		if(current_node.next != null){
			current_node.next.previous = add_node;
		}
	}

	@Override
	public boolean remove(int index) {
		isValidIndex(index);
		
		Node current_node = this.head;
		int iterator = 0;
		
		//if element matches at head
		if(index == 0) {
			this.head = this.head.next;
		}
		
		while(iterator < index) {
			current_node = current_node.next;
			iterator++;
		}
		
		//if element is not the last element of the list
		if(current_node.next.next != null) {
			current_node.next.previous = current_node;
			current_node.next = current_node.next.next;
		}else{	//if last element
			current_node.next = null;
		}
		
		total_elements--;
		return true;
	}

	@Override
	public boolean remove(Object element) {
		if(this.head == null) {
			throw new NullPointerException();
		}
		
		Node current_node = this.head;
		
		//search the list
		while(current_node != null & current_node.data != element) {
			current_node = current_node.next;
		}
		
		//complete iteration of list
		if(current_node == null) {
			return false;
		}
		
		//else remove the element
		if(current_node.next != null) {
			current_node.previous = current_node.next;
		}else {
			current_node.previous = null;
		}
		
		total_elements--;
		return true;
	}

	@Override
	public Object get(int index) {
		isValidIndex(index);
		
		Node current_node = this.head;
		int iterator = 0;
		
		while(iterator < index) {
			current_node = current_node.next;
		}
		
		return current_node.data;
	}

	// non-recursive
	@Override
	public void reverse() {
		//reverse an empty list or if list has only one element
		if(this.head == null || this.head.next == null) {
			return;
		}
		
		Node current_node = this.head;
		
		//iteratively change pointers to each node
		while(current_node.next != null) {
			Node next_ptr = current_node.next;
			current_node.next = current_node.previous;	//next pointer points to the previous node
			current_node.previous = next_ptr;			//previous pointer now points to the old next node
			
			current_node = next_ptr;					//traverse the list
		}
		
		//at the end of the list: when next node is null
		this.head = current_node;
	}

	//merge sort
	@Override
	public void sort() {
		//sort an empty list or if list has only one element
		if(head == null || this.head.next == null) {
			return;
		}
		
		
	}
	
	public int size(){
		return this.total_elements;
	}
	
	private boolean isValidIndex(int index){
		if(this.head== null || index < 0 || index > this.size()){
			throw new IndexOutOfBoundsException();
		}
		
		return true;
	}
}
