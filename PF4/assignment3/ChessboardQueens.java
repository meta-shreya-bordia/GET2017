package assignment3;

/** The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other.
 */

public class ChessboardQueens {
	private int queen_count;
	public int[][] chessboard;

	/**@Method	nQueen(int dimensionOfMatrix)
	 * sets chessboard[][] values to 0
	 * @return	type = boolean, value = true or false if possible to place N Queens on boards
	 * */
	boolean nQueen(int dimensionOfMatrix) {
		if(dimensionOfMatrix <= 0)
			throw new IllegalArgumentException();
				
		queen_count = dimensionOfMatrix;
		chessboard = new int[dimensionOfMatrix][dimensionOfMatrix];
		
		for(int i=0; i< dimensionOfMatrix; i++) {
			for(int j=0; j< dimensionOfMatrix; j++) {
				chessboard[i][j] = 0;
			}
		}
	
		return placeQueen(0);
	}
	
	/**@Method	placeQueen(int column)
	 * place a queen at selected column for some row
	 * @calls	checkIfPossibleToPlaceQueenHere which returns true is no already placed queens are in conflict
	 * @return	type = boolean, value = updates chessboard
	 * */
	boolean placeQueen(int column) {

		//base condition to exit loop
		if(queen_count == 0 | column >= chessboard.length)
			return true;
		
		//check if queen can be placed by placement and backtracking 
		for(int row = 0; row < chessboard.length; row++) {
			if(checkIfPossibleToPlaceQueenHere(row, column)) {
				queen_count--;
				chessboard[row][column] = 1;
			
				// check for other queen placements
				if(placeQueen(column+1)) {
					return true;
				}
				
				//else	BACKTRACK
				queen_count++;
				chessboard[row][column] = 0;
			}
		}
		
		//impossible to fit onto this column
		return false;
	}

	/**@Method	checkIfPossibleToPlaceQueenHere(int row, int column)
 	* check only for previous:
 	* left columns (checkRow)
 	* left Upper Diagonal (checkUpperDiagonal)
 	* left Lower Diagonal (checkLowerDiagonal)
 	* @return	type = boolean, true is placing queen is possible 
 	* */
	public boolean checkIfPossibleToPlaceQueenHere(int row, int column) {
		if ( checkRow(row, column) & checkUpperDiagonal(row, column) & checkLowerDiagonal(row, column) )
			return true;
		
		return false;
	}
	
	/** @Method	checkRow(int row, int column)
	 * check all left side column of particular row
	 * that no queen exists
	 * @return	if no queen in said row
	 * */
	boolean checkRow(int row, int column) {		
		if(column < 0)
			return true;
		
		return ( (chessboard[row][column] == 1) ? false : checkRow(row, --column) );
	}
	
	/** @Method	checkUpperDiagonal(int row, int column)
	  * check relative diagonal of particular index
	 * that no queen exists
	 * @return	true if no queen in said diagonal
	 * */
	boolean checkUpperDiagonal(int row, int column) {
		if(row<0 | column < 0)
			return true;
		
		return ( (chessboard[row][column] ==1) ? false : checkUpperDiagonal(--row, --column) );
	}
	
	/** @Method	checkLowerDiagonal(int row, int column)
	 * check relative diagonal of particular index
	 * that no queen exists
	 * @return	true if no queen in said diagonal
	 * */
	boolean checkLowerDiagonal(int row, int column) {
		if(row >= chessboard.length | column < 0)
			return true;
		
		return ( (chessboard[row][column] ==1) ? false : checkLowerDiagonal(++row, --column) );
	}
}