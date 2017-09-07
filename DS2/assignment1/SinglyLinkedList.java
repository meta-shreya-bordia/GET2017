package assignment1;

public class SinglyLinkedList<E> implements IList{
	private Node head;
	private int total_elements;
	
	public SinglyLinkedList(){
		head = null;
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
	public Node remove(int index) {
		isValidIndex(index);
		
		Node removed;
		//removing an element at the start of list
		if(index == 0){
			removed = this.head;
			this.head = this.head.next;
			return removed;
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
		
		//remove from end of list: current node is the one being removed
		removed = current_node;
		previous.next = current_node.next;
		
		return removed;
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
		
		return current_node.getElement();
	}

	private boolean isValidIndex(int index){
		if(index < 0 || index > total_elements){
			throw new IndexOutOfBoundsException();
		}
		
		return true;
	}
}
