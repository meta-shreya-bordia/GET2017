package assignment2;

import org.junit.*;

/**
 * Positive test cases include checks for base condition, boundary values values or central range inputs.
 * The expected values must match those generates by the method.
 * **/

public class MatrixTestPositives {
MatrixOperations matrix;
	
	@Before
	public void setUp() {
		matrix = new MatrixOperations(2, 3);
	}

// Initializing an object
	@Test
	public void testForPositiveSize() {
		matrix = new MatrixOperations(2, 3);
		
		Assert.assertEquals(2, matrix.row_size);
		Assert.assertEquals(3, matrix.column_size);
	}
	
// Adding elements to matrix
	@Test
	public void testForAddingElement() {
		matrix.addElements(1, 2, 12);
		
		Assert.assertEquals(12, matrix.showMatrix().matrix[1][2]);
	}
	
// Display elements of matrix	
	@Test
	public void testDisplayingMatrix() {
		int[][] expected = {{1, 4},
							{2, -6}};
		
		matrix = new MatrixOperations(2, 2);
		matrix.addElements(0,0, 1);
		matrix.addElements(0,1, 4);
		matrix.addElements(1,0, 2);
		matrix.addElements(1,1,-6);
		
		for(int i=0; i< matrix.row_size; i++) {
			Assert.assertArrayEquals(expected[i], matrix.showMatrix().matrix[i]);
		}		
	}
	
// Add two matrices
	@Test
	public void testForAddingMatrices() {
		MatrixOperations addmatrix = new MatrixOperations(2, 3);
		matrix.addElements(0,0, 1);
		matrix.addElements(0,1, 4);
		matrix.addElements(0,2, 3);
		matrix.addElements(1,0, 2);
		matrix.addElements(1,1,-6);
		matrix.addElements(1,2, 0);
		
		addmatrix.addElements(0,0, 1);
		addmatrix.addElements(0,1, 4);
		addmatrix.addElements(0,2,-3);
		addmatrix.addElements(1,0, 2);
		addmatrix.addElements(1,1, 6);
		addmatrix.addElements(1,2, 0);
		
		Matrix m = matrix.addMatrix(addmatrix);
		
		int[][] expected = {{2, 8, 0},
							{4, 0, 0}};
		
		for(int i=0; i< m.row_size; i++) {
			Assert.assertArrayEquals(expected[i], m.matrix[i]);
		}
	}
	
// Multiply two matrices
	@Test
	public void testMultiplyMatrices() {
		MatrixOperations multiplymatrix = new MatrixOperations(3, 2);
		matrix.addElements(0,0, 1);
		matrix.addElements(0,1, 4);
		matrix.addElements(0,2, 3);
		matrix.addElements(1,0, 2);
		matrix.addElements(1,1,-6);
		matrix.addElements(1,2, 0);
		
		multiplymatrix.addElements(0,0, 1);
		multiplymatrix.addElements(0,1, 4);
		multiplymatrix.addElements(1,0, 2);
		multiplymatrix.addElements(1,1, 6);
		multiplymatrix.addElements(2,0, 0);
		multiplymatrix.addElements(2,1, 0);
		
		Matrix m = matrix.multiplyMatrix(multiplymatrix);
		
		int[][] expected = {{9, 28},
							{-10, -28}};
		
		for(int i=0; i< m.row_size; i++) {
			Assert.assertArrayEquals(expected[i], m.matrix[i]);
		}
	}
	
//Transpose a matrix
	@Test
	public void testTranspose() {
		matrix.addElements(0,0, 1);
		matrix.addElements(0,1, 4);
		matrix.addElements(0,2, 3);
		matrix.addElements(1,0, 2);
		matrix.addElements(1,1,-6);
		matrix.addElements(1,2, 0);
 		
		int[][] expected = {{1, 4,3},
							{2,-6,0}};

		for(int i=0; i< matrix.row_size; i++) {
			Assert.assertArrayEquals(expected[i], matrix.matrix[i]);
		}
	}
}
