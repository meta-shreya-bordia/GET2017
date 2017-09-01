package assignment1;

import java.util.*;
import org.junit.*;

public class TreeSortTest {
	TreeSort<Integer> treeInt;
	TreeSort<String> treeString;
	
	@Before
	public void setUp() {
		treeInt = new TreeSort<Integer>();
		treeString = new TreeSort<String>();
	}
	
	@Test
	public void testAddNull() {
		Assert.assertFalse( treeInt.add(null) );
	}
	
	@Test
	public void testAddDuplicateRollNumber() {
		Assert.assertTrue( treeInt.add(10));
		treeInt.add(10);
		
		//Assert.assertEquals( 1, treeInt.size() );
	}
	
	@Test
	public void testPrintNullTree() {
		Assert.assertEquals("", (String)treeInt.sortTree() );
	}
	
	@Test
	public void testSortElements() {
		Assert.assertTrue( treeInt.add(100) );
		Assert.assertTrue( treeInt.add(1) );
		Assert.assertTrue( treeInt.add(10) );
		Assert.assertTrue( treeInt.add(111) );
		
		Assert.assertEquals("1->10->100->111->", treeInt.sortTree());
	}
	
	@Test
	public void testStringTypeRollNumber() {
		Assert.assertTrue( treeString.add("E17/112") );
		Assert.assertTrue( treeString.add("E17/113") );
		Assert.assertTrue( treeString.add("E17/110") );
		Assert.assertTrue( treeString.add("E17/111") );
		
		Assert.assertEquals("E17/110->E17/111->E17/112->E17/113->", treeString.sortTree() );
	}
	
	@Test
	public void testGetSortedTree() {
		Assert.assertTrue( treeString.add("E17/112") );
		Assert.assertTrue( treeString.add("E17/111") );
		Assert.assertTrue( treeString.add("E17/113") );
		Assert.assertTrue( treeString.add("E17/110") );

		List<String> tree = treeString.getTree();
		
		Assert.assertEquals( "E17/110", tree.get(0) );
		Assert.assertEquals( "E17/111", tree.get(1) );
		Assert.assertEquals( "E17/112", tree.get(2) );
		Assert.assertEquals( "E17/113", tree.get(3) );
	}
}
