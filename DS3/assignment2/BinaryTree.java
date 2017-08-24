package assignment2;

public class BinaryTree<E> {
	private Node root;
	
	BinaryTree(){
		root = null;
	}
	
	public Node getRoot(){
		return this.root;
	}
	
	/**@Method	addNode(E element)
	 * user access method for adding a node to tree
	 * @return	type=void, adds to linked-tree
	**/
	public void addNode(E element){
		this.root = addNode(this.root, element);
	}
	
	public void inOrderTraversal(){
		inOrderTraversal(this.root);
	}
	
	public void preOrderTraversal(){
		preOrderTraversal(this.root);
	}

	public void postOrderTraversal(){
		postOrderTraversal(this.root);
	}
	
	/**@Method	addNode(Node node, E element)
	 * check for corresponding left then right child
	 * from root and elements
	 * to form a complete binary tree.
	**/
	private Node addNode(Node node, E element){
		if (node == null){
            node = new Node(element);
		}else{
            if(node.left == null)
                node.left = addNode(node.left, element);
            else
                node.left = addNode(node.left, element);             
        }
        return node;
	}
	
	/**
  	1. Traverse the left subtree, i.e., call Inorder(left-subtree)
   	2. Visit the root.
   	3. Traverse the right subtree, i.e., call Inorder(right-subtree)
   	**/
	private void inOrderTraversal(Node node){
		//LNR
		inOrderTraversal(node.left);
		System.out.print(node.getElement() + "->");
		inOrderTraversal(node.right);
	}
	
	/**@Method	preOrderTraversal(Node node)
	1. Visit the root.
   	2. Traverse the left subtree, i.e., call Preorder(left-subtree)
   	3. Traverse the right subtree, i.e., call Preorder(right-subtree)
	**/
	private void preOrderTraversal(Node node){
		//NLR
		System.out.print(node.getElement() + "->");
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}
	
	/**@Method	postOrderTraversal(Node root)
	1. Traverse the left subtree, i.e., call Postorder(left-subtree)
   	2. Traverse the right subtree, i.e., call Postorder(right-subtree)
   	3. Visit the root.
	 **/
	private void postOrderTraversal(Node node){
		//LRN
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.println(node.getElement()+ "->");
	}
}
