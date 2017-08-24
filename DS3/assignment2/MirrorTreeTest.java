package assignment2;

import org.junit.*;

public class MirrorTreeTest {
	BinaryTree tree1;
	BinaryTree tree2;
	
	@Before
	public void setUp(){
		tree1 = new BinaryTree();
		tree2 = new BinaryTree();
	}
	
	//When both trees are null: mirror
	@Test
	public void testBlankTrees(){
		Assert.assertTrue( MirrorTree.isMirror(tree1, tree2) );
	}
	
	//When either one of the tree is empty but not the other one
	@Test
	public void testOneBlankTree(){
		tree1.addNode(1);
		Assert.assertFalse( MirrorTree.isMirror(tree1, tree2) );
	}
	
	//When tree2 is same as tree 1: not mirror images
	@Test
	public void testSameTree(){
		tree1.addNode(" Root ");
		tree1.addNode(" LeftOfRoot ");
		tree1.addNode(" RightOfRoot ");
		tree1.addNode("");
		
		tree2 = tree1;
		Assert.assertFalse( MirrorTree.isMirror(tree1, tree2) );
	}
	
	//When trees are mirror images of each other
	public void testMirrorImages(){
		tree1.addNode(true);
		tree1.addNode(false);
		tree1.addNode(true);
		tree1.addNode(false);
		tree1.addNode(true);
		
		tree2.addNode(true);
		tree2.addNode(true);
		tree2.addNode(false);
		tree2.addNode(true);
		tree2.addNode(false);
		
		Assert.assertTrue( MirrorTree.isMirror(tree1, tree2) );
	}
	
	//When data type of trees are different
	@Test
	public void testDifferentType(){
		tree1.addNode(10);
		tree1.addNode(70);
		tree1.addNode(35);
		
		tree2.addNode("10");
		tree2.addNode("70");
		tree2.addNode("35");
		
		Assert.assertFalse( MirrorTree.isMirror(tree1, tree2) );
	}
	
	@Test
	public void testNullTree(){
		Assert.assertTrue( MirrorTree.isMirror(null, tree2) );
	}
}
