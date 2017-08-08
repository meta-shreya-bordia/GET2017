package assignment2;

import org.junit.*;
import java.util.*;


/**
 * Negative test cases include checks for null, zero values or incorrect inputs.
 * These raise exceptions that must be handled. 
 * **/

public class MatrixTestNegatives {
	MatrixOperations matrix;
	
	@Before
	public void setUp() {
		matrix = new MatrixOperations(2, 3);
	}

// Initializing an object
	@Test(expected = IllegalArgumentException.class)
	public void testForZeroSize() {
		matrix = new MatrixOperations(0, 3);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testForNegativeSize() {
		matrix = new MatrixOperations(-2, 3);
	}
	
// Adding elements to matrix
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testForOutOfBoundsRow() {
		matrix.addElements(20, 2, 12);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testForIllegalColumn() {
		matrix.addElements(1, -4, 12);
	}
	
// Display elements of matrix	
	@Test(expected = NullPointerException.class)
	public void testForNullObject() {
		matrix = null;
		matrix.showMatrix();
	}
	
// Add two matrixes
	@Test(expected = Exception.class)
	public void testForNullBaseMatrix() {
		MatrixOperations addmatrix = null;
		addmatrix.addMatrix(matrix);
	}
	
	@Test(expected = NullPointerException.class)
	public void testForNullMatrix() {
		MatrixOperations addmatrix = null;
		matrix.addMatrix(addmatrix);
	}
	
	@Test(expected = InputMismatchException.class)
	public void testForIncompatibleMatrix() {
		MatrixOperations addmatrix = new MatrixOperations(2, 4);
		addmatrix.addMatrix(matrix);
	}
	
// Multiply two arrays
	@Test(expected = NullPointerException.class)
	public void testNullObjectMultiply() {
		MatrixOperations multiplymatrix = null;
		matrix.multiplyMatrix(multiplymatrix);
	}
	
	@Test(expected = InputMismatchException.class)
	public void testIncompatibleMultiply() {
		matrix.multiplyMatrix(matrix);
	}
	
//Transpose a matrix
	@Test(expected = NullPointerException.class)
	public void testNullTransposal() {
		matrix =null;
		matrix.transposeMatrix();
	}
}
