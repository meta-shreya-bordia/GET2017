package assignment1;
/**
 * Create a pattern of pyramid of numbers starting from 1 to given size and from size to 1  
 * pattern starts from center with the row_number and number value decreases till 1
 * **/
public class Pyramid {
	
	/**
	 * Method: space(int row, int n)
	 * For spacing on each row before number depending on row number
	 * @param row  describes row no
	 * @param n    describes size of pyramid
	 * @return 	   type = string, value = number of spaces for row
	 */
	public String space(int row, int n){
		if(n<=0 | row >= 2*n | row <=0)
			throw new NumberFormatException();
	
		String spacing = "";
		
		if(row> n)
			row = 2*n -row;
		
		for(int row_value = 1; row_value<= 2*(n-row); row_value++){
			spacing += " ";
		}
		
		return spacing;
	}
	
	/**
	 * Method: number(int row, int n)
	 * denote increasing and decreasing order of each row
	 * @param row  describes row no
	 * @param n    describes size of pyramid
	 * @return 	   type = string, value = numbers for row
	 */
	public String number(int row, int n){
		if(n<=0 | row >= 2*n | row <=0)
			throw new NumberFormatException();
	
		if(row> n)
			row = 2*n -row;;
		
		String numbering = "";
		
		for(int row_value = 1; row_value<= row; row_value++){
			numbering += row_value+" ";
		}
		
		for(int row_value= row-1; row_value>= 1; row_value--){
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
		
		String[] pyramid = new String[2*n -1];
		int k=0;
		
		for(int row_no= 1; row_no < n; row_no++){
			pyramid[k++] = space(row_no, n)+number(row_no, n)+ "\n";
		}

		for(int row_no = n ; row_no > 0; row_no--){
			pyramid[k++] = space(row_no, n)+number(row_no, n)+"\n";
		}
		
		return pyramid;
	}
}
