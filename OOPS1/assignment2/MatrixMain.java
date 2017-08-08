package assignment2;

import java.util.Scanner;

/**@Class	MatrixMain
 * User interface based scanning and printing onto console
 * */
public class MatrixMain {
	
		/**@Method	printMatrix(String msg, Matrix view_matrix)
		 * print matrix in row x column format
		 * @return	type =void, display only
		 * **/
		static void printMatrix(String msg, Matrix view_matrix) {
			System.out.println(msg);
			
			for(int i = 0; i < view_matrix.row_size; i++) {
				for(int j = 0; j < view_matrix.column_size; j++) {
					System.out.print(view_matrix.matrix[i][j]+"\t");
				}
				System.out.println();
			}
		}
		
		/**@Method	scanMatrix(String msg, MatrixOperations scan_matrix)
		 * scan element by element input matrix
		 * */
		static MatrixOperations scanMatrix(String msg, MatrixOperations scan_matrix) {
			System.out.println(msg);
			
			Scanner input = new Scanner(System.in);
			
			for(int i = 0; i < scan_matrix.row_size; i++) {
				for(int j = 0; j < scan_matrix.column_size; j++) {
					scan_matrix.addElements(i, j, input.nextInt());
				}
			}
			
			return scan_matrix;
		}


		public static void main(String[] args) {
			Scanner input = new Scanner(System.in);

	//Instantiate an object
			System.out.println("Enter size of matrix: ");
			int row = input.nextInt();
			int column = input.nextInt();
	
			MatrixOperations m = new MatrixOperations(row, column);
			m = scanMatrix("Enter elements of matrix, row by row: ", m);
			printMatrix("Matrix elements are: ", m.showMatrix());
	
	//Adding two Matrixes
			MatrixOperations add_matrix = new MatrixOperations(row, column);
			add_matrix = scanMatrix("Enter elements for addition: ", add_matrix);
			printMatrix("Addition Result: ", m.addMatrix(add_matrix));
			
	//Multiplying two Matrixes
			System.out.println("Enter size of another matrix for multiplication: ");
			row = input.nextInt();
			column = input.nextInt();
			MatrixOperations multiply_matrix = new MatrixOperations(row, column);

			multiply_matrix = scanMatrix("Enter elements of matrix, row by row: ", multiply_matrix);
			printMatrix("Multiplication Result: ", m.multiplyMatrix(multiply_matrix));
				
	//Transpose of a matrix
			printMatrix("Transpose of matrix: ", m.transposeMatrix());
			
			input.close();
		}
}
