package assignment1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.*;

public class TowerOfHanoiTest {
	TowerOfHanoi disk_moves;
	List<String> expected;
	
	/** Initalizing object common for each test case*/
	@Before
	public void setUp() {
		disk_moves = new TowerOfHanoi();
		expected = new ArrayList<String>();
	}
	
/** Positive Test Cases*/
	//Base Condition: To move only one element from source to destination
	@Test
	public void testForDirectMoveToDestination() {
		String[] moves = {"Move Disk 1 from A to B"
				 };	
		expected.addAll(Arrays.asList(moves));
		// compare expected nmber of moves and disk actual movements
		Assert.assertEquals(expected, disk_moves.towerOfHanoi("A", "B", "C", 1));
	}

	//To move multiple elements from source to destination: needs temporary array
	@Test
	public void testForSteppedMoveToDestination() {
		String[] moves = {
				"Move Disk 1 from A to B",
				"Move Disk 2 from A to C",
				"Move Disk 1 from B to C",
				"Move Disk 3 from A to B",
				"Move Disk 1 from C to C",
				"Move Disk 2 from C to B",
				"Move Disk 1 from C to B"
							};
		
		expected.addAll(Arrays.asList(moves));
		// compare expected nmber of moves and disk actual movements
		Assert.assertEquals(expected, disk_moves.towerOfHanoi("A", "B", "C", 3));
	}

/** Negative Test cases**/
	//Test case when number of disk is zero
	@Test(expected=IllegalArgumentException.class)
	public void TestForZeroDisk(){
		disk_moves.towerOfHanoi("A", "B", "C", 0);	
	}
	
	//Test case when number of disk is negative
	@Test(expected=IllegalArgumentException.class)
	public void TestForNegativeDisk(){
		disk_moves.towerOfHanoi("A", "B", "C", -2);	
	}
	
	//Test case when number of disk is negative
	@Test(expected= NullPointerException.class)
	public void TestForNullDisk(){
		disk_moves.towerOfHanoi("A", null, "C", 5);	
	}
}
