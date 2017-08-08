package assignment2;

/**
 * @Class	Matrix: superclass implementing object creation and displaying matrix elements
 * */
public class Matrix{
	protected int row_size, column_size;
	protected int[][] matrix;
	
	public Matrix(){
		matrix = null;
	}
	
	public Matrix(int row, int column){
		if(row <=0 | column <= 0)
			throw new IllegalArgumentException();
		
		row_size = row;
		column_size = column;
		matrix = new int[row_size][column_size];
	}
	
	/**@Method	showMatrix()
	 * @return	type = Matrix object, print matrix held by object
	 * */
	public Matrix showMatrix(){
		return this;
	}
	
	/**@Method	addElements(int row_position, int column_position, int element)
	 * add element at specific position in matrix
	 * @return	type = void, updates matrix
	 * */
	public void addElements(int row_position, int column_position, int element){
		if(row_position < 0 | column_position < 0) {
			throw new IllegalArgumentException();
		}
		
		if(row_position >= row_size | column_position >= column_size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		this.matrix[row_position][column_position] = element;
	}
}
