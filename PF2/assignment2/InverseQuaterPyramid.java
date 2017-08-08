package assignment2;
/**
 * Create a pattern of pyramid of numbers starting from given size to 1  
 * pattern starts from 1 with the row_number and number value increases till row_no for each row
 * each row now prints till value decreases to 1
 * **/
public class InverseQuaterPyramid {
	
		/**
		 * Method: space(int row, int n)
		 * For spacing on each row before number depending on row number
		 * @param row  describes row no
		 * @param n    describes size of pyramid
		 * @return 	   type = string, value = number of spaces for row
		 */
		String space(int row, int n){
			if(n<=0 | row<=0 | row> n)
				throw new NumberFormatException();
			
			String spacing = "";
			
			for(int i= 1 ; i<= 2*(row -1); i++){
				spacing += " ";
			}
		
			return spacing;
		}
		
		/**
		 * Method: number(int row, int n)
		 * denote increasing number for each row
		 * @param row  describes row no
		 * @param n    describes size of pyramid
		 * @return 	   type = string, value = numbers for row
		 */
		public
		String number(int row, int n){
			if(n<=0 | row<=0 | row> n)
				throw new NumberFormatException();
			
			String numbering = ""; 
			
			for(int row_value=1 ; row_value <= n-row+1 ; row_value++){
				numbering += row_value+" ";
			}
		
			return numbering;
		}
		
		/**
		 * Method: makePyramid(int n)
		 * create pyramid pattern
		 * @param n    describes size of pyramid
		 * @calls	   space(row, n), number(row, n)
		 * @return 	   type = string[], value = complete pattern
		 */
		public String[] makePyramid(int n){
			if(n<=0)
				throw new NumberFormatException();
	
			String[] pyramid = new String[n];
			
			for(int row_no= 0; row_no < n; row_no++){
				pyramid[row_no] = space(row_no+1, n)+number(row_no+1, n)+ "\n";
			}
			
			return pyramid;
		}
}
