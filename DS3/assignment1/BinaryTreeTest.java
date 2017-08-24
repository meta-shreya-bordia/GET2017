package assignment1;

import org.junit.*;

public class BinaryTreeTest {
	BinaryTree tree;
	
	@Before
	public void setUp(){
		tree = new BinaryTree();
	}
	
	@Test
	public void testAddingNullNode(){
		tree.addNode(null);
		
		Assert.assertEquals(null, tree.getRoot());
	}
	
	@Test
	public void inOrderTraversalOfEmptyTree(){
		
	}
	
	@Test
	public void preOrderTraversalOfEmptyTree(){
		
	}
	
	@Test
	public void postOrderTraversalOfEmptyTree(){
		
	}
	
	@Test
	public void testAddDifferentDataType(){
		
	}
	
	@Test
	public void testInOrderTraversal(){
		
	}
	
	@Test
	public void testPreOrderTraversal(){
		
	}
	
	@Test
	public void testPostOrderTraversal(){
		
	}
}
