package assignment2;

public class MirrorTree<E> {
	/**
	1. Their root node’s key must be same
	2. Left subtree of root of ‘a’ and right subtree root of ‘b’ are mirror.
	3. Right subtree of ‘a’ and left subtree of ‘b’ are mirror.
	 **/
	public static boolean isMirror(BinaryTree tree1, BinaryTree tree2){
		return isMirror(tree1.getRoot(), tree2.getRoot());
	}
	
	public static boolean isMirror(Node root1, Node root2){
		if(root1 == null && root2 == null){
			return true;
		}else if(root1 == null || root2 == null){ //if only one of them is empty
			return false;
		}
		
		//compare recursively
		return ( root1.getElement().equals(root2.getElement())
				&& isMirror(root1.left, root2.right)
				&& isMirror(root1.right, root2.left));
	}
}
