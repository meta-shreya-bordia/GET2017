package assignment3;

public class SinglyLinkedList<E extends Comparable<E>> implements IList{
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
			if(this.head.data != null ){
				add_node.next = this.head;
			}
			
			this.head = add_node;
			total_elements++;
			return;
		}
		
		//else: iterate to position
		Node previous 	  = this.head;
		Node current_node = this.head.next;
		int iterater = 0;
		
		while(current_node!= null & iterater < index-1){
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
		previous.next = current_node.next;
		return true;
	}

	@Override
	public boolean remove(Object element) {			
		Node previous = null;
		Node current_node = this.head;
		
		while(current_node!= null && current_node.data != element){
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
		this.head = this.mergeSort(head);
	}
	
	private boolean isValidIndex(int index){
		if(this.head == null || index < 0 || index > total_elements){
			throw new IndexOutOfBoundsException();
		}
		
		return true;
	}
	
	private Node getMiddleNode(Node current_node) {
		if(current_node == null)
			return current_node;
		
		Node iterate_two = current_node.next;
		Node iterate_one = current_node;
		
		while(iterate_two != null) {
			iterate_two = iterate_two.next;
			if(iterate_two.next != null) {
				iterate_one = iterate_one.next;
				iterate_two = iterate_one.next;
			}
		}
		
		return iterate_one;
	}
	
	private Node mergeSort(Node current_node){
		if(current_node == null || current_node.next == null){ //if ll is empty, or contains only 1 element
			return head;
		}
		
		Node middle = getMiddleNode(current_node);		//divides into 2 linkedlist. middle.next = null;
		Node rightList = middle.next;
		
		Node left = mergeSort(current_node);
		Node right= mergeSort(rightList);
		
		return merge(left, right);
	}
	
	private Node merge(Node left_index, Node right_index){
		Node sorted_head = null;
		
		/**Base condition to exist the recursion*/
		if(left_index == null)
			return right_index;
		if(right_index == null)
			return left_index;
		
		//if left ll element is smaller than right index element
		if( ((Comparable<E>) left_index.getElement()).compareTo((E)right_index.getElement() ) <= 0 ) {
			sorted_head = left_index;
			
			//recursively add to the ll
			sorted_head.next = merge(left_index.next, right_index);
		}else {
			sorted_head = right_index;
			sorted_head.next = merge(left_index, right_index.next);
		}
		
		return sorted_head;
	}
}
