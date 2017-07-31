package assignment3;

import org.junit.*;

/**
 * * Positive test cases include checks for base condition, boundary values values or central range inputs.
 * The expected values must match those generates by the method.
 * * Negative test cases include checks for null, zero values or incorrect inputs.
 * These raise exceptions that must be handled. 
 * */
public class ChessboardQueensTest {
	ChessboardQueens placement;
	
	/** Initialize object for class to be tested*/
	@Before
	public void setUp() {
		placement = new ChessboardQueens();
	}

//Positive Test Cases:
	/** For matrix of size 3x3 or less
	 * no arrangement is possible**/
	@Test
	public void testFoImpossiblePlacement() {
		Assert.assertFalse(placement.nQueen(3));
	}
	
	/** For matrix of size 4x4 and more
	 * only one possible arrangement of queens**/
	@Test
	public void testFoPossiblePlacement() {
		Assert.assertTrue(placement.nQueen(4));
		
		int[][] expected = { {0, 0, 1, 0},
							 {1, 0, 0, 0},
							 {0, 0, 0, 1},
							 {0, 1, 0, 0}
							};
		
		for(int check=0; check< expected.length; check++) {
			Assert.assertArrayEquals(expected[check], placement.chessboard[check]);
		}
	}
	
//Negative Test Cases
	/** When matrix size is 0, no matrix can be formed*/
	@Test(expected = IllegalArgumentException.class)
	public void testForZeroMatrixSize() {
		placement.nQueen(0);
	}

	/** When matrix size is negative, no matrix can be formed*/
	@Test(expected = IllegalArgumentException.class)
	public void testForNegativeMatrixSize() {
		placement.nQueen(-7);
	}
}
