package assignment1;

import java.util.*;

/**@Class	TreeSort
 * Tree sort is a sorting algorithm that is based on BST.
 * It first creates a BST from the elements of the input
 * 	and then performs an in-order traversal
 * to get the elements in sorted order.
**/
public class TreeSort<E extends Comparable<E>>{
	private Node<E> head;
	private String treeSort;
	List<E> list;

	public TreeSort() {
		head = null;
		list = new ArrayList<E>();
	}
	
	/**@Method	add(E rollNumber)
	 * add an element to tree in sorted format
	 * starting from root, compare at every node, element value stored
	 * @return	type = boolean, if element added = true;
	 * 							else of duplicate: not added = false
	 **/
	public boolean add(E rollNumber) {
		if( rollNumber == null){
			return false;
		}
		
		head = add(head, rollNumber);
		return true;
	}
	
	/**@Method	add(Node node, E element)
	 * if rollNumber is a unique value, insert it as a node
	 * 	if smaller than parent node value: left;
	 * 	if larger: right
	 * 	else do not add to list
	 * @return type = Node<E>, element added
	 **/
	// Time Complexity: O(n lg n)
	private Node<E> add(Node<E> nodePtr, E element){
		if( nodePtr == null ){
			return new Node<E>(element);
		}	
		
		//when element is bigger than parent node: save to right
		if( nodePtr.getElement().compareTo( element ) < 0 ){
			nodePtr.right = add( nodePtr.right, element );
		}else if( nodePtr.getElement().compareTo( element ) > 0 ){
			nodePtr.left = add( nodePtr.left, element);
		}else{
			return null;
		}	
		
		return nodePtr;
	}

	/**@Method	sortTree()
	 * maintain BST upon insertion
	 * in-order traversal to retrieve how elements are stored
	 * @return	type = String, node data
	 **/
	public String sortTree(){
		treeSort = "";
		return inOrderTraversal(head);
	}
	
	/**@Method	inOrderTraversal(Node<E> node)
	 * recursively iterate over each element
	 * @return	type = String, node data
	 **/
	private String inOrderTraversal(Node<E> node){
		if(node == null){
			return treeSort;
		}
		
		//LNR
		inOrderTraversal(node.left);
		treeSort+= (node.getElement() + "->");
		inOrderTraversal(node.right);
		
		return treeSort;
	}
	
	/**@Method	getTree()
	 * get a list of all elements in in-order 
	 * @return	type = List<E>, node data array
	 **/
	public List<E> getTree(){
		if(head == null){
			return null;
		}
		
		return getTree(head);
	}
	
	/**@Method	getTree(Node<E> node)
	 * recursively iterate over each node
	 * @return	type = List<E>, node data array
	 **/
	private List<E> getTree(Node<E> node){
		if(node == null){
			return list;
		}
		
		//LNR
		getTree(node.left);
		list.add(node.getElement());
		getTree(node.right);
		
		return list;
	}
	
	public static void main(String[] args) {
		TreeSort<String> tree = new TreeSort<String>();
		
		tree.add("E17/112");
		tree.add("E17/111");
		tree.add("E17/117");
		tree.add("E17/115");
		
		System.out.println( tree.sortTree() );
//		System.out.println( tree.getTree().toString() );
	}
}