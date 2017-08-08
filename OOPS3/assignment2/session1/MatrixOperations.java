package session1;

import java.util.InputMismatchException;

/**
 * @Class MatrixOperations implements all matrix operations indicated in
 *        interface methods: add, multiply, transpose
 */
public class MatrixOperations extends Matrix implements IMatrixOperations {
	public MatrixOperations() {
	}

	public MatrixOperations(int row, int column) {
		super(row, column);
	}

	/**
	 * @Method addMatrix(Matrix to_add) add two matrices matrices must have same row
	 *         and column size for addition
	 * @return type = Matrix object, new added matrix
	 */
	public Matrix addMatrix(Matrix to_add) {
		if (this == null | to_add == null)
			throw new NullPointerException();

		if (this.row_size != to_add.row_size | this.column_size != to_add.column_size) {
			throw new InputMismatchException();
		}

		Matrix add_result = new Matrix(row_size, column_size);
		for (int row = 0; row < row_size; row++) {
			for (int column = 0; column < column_size; column++) {
				add_result.matrix[row][column] = this.matrix[row][column] + to_add.matrix[row][column];
			}
		}

		return add_result;
	}

	/**
	 * @Method multiplyMatrix(Matrix to_multiply) multiply two matrices matrices
	 *         must satisfy m1.column_no = m2.row_no condition to multiply
	 * @return type = Matrix object, new multiplied matrix
	 */
	public Matrix multiplyMatrix(Matrix to_multiply) {
		if (this.column_size != to_multiply.row_size)
			throw new InputMismatchException();

		Matrix multiplied = new Matrix(this.row_size, to_multiply.column_size);

		for (int row = 0; row < multiplied.row_size; row++) {
			for (int column = 0; column < multiplied.column_size; column++) {
				for (int common_index = 0; common_index < this.column_size; common_index++)
					multiplied.matrix[row][column] += this.matrix[row][common_index]
							* to_multiply.matrix[common_index][column];
			}
		}

		return multiplied;
	}

	/**
	 * @Method transposeMatrix() convert row x column matrix to column x row matrix
	 * @return type = Matrix object, column x row matrix
	 */
	public Matrix transposeMatrix() {
		Matrix transpose = new Matrix(column_size, row_size);

		for (int row = 0; row < row_size; row++) {
			for (int column = 0; column < column_size; column++) {
				transpose.matrix[column][row] = this.matrix[row][column];
			}
		}

		return transpose;
	}
}