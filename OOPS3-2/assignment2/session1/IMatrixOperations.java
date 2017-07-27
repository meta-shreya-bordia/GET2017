package session1;

/**
 * Force Matrix to perform these operations by implementing the Interface
 */
public interface IMatrixOperations {
	public Matrix addMatrix(Matrix matrix2);

	public Matrix multiplyMatrix(Matrix matrix2);

	public void addElements(int element, int row_position, int column_position);

	public Matrix transposeMatrix();
}
