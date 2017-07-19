package assignment5;

/* 0: unsorted
 * 1: ascending sorted
 * 2: descending sorted
 * */
public class CheckArraySorting {	
	public int checkSortArray(int[] a){
		if(a==null)
			throw new NullPointerException();
		if(a.length <= 0)
			throw new ArrayIndexOutOfBoundsException();
				
		/*check for ascending */
		int i=0;
		for(i=0; i< a.length-1 ; i++){
			if(a[i] > a[i+1]){
				break;
			}
		}
				
		/* => is in ascending order*/
		if(i == a.length -1){
			return 1;
		}
				
		/*descending check */
		for(i=0; i< a.length -1; i++){
			if(a[i] < a[i+1])
				break;
		}
			
		/* => is descending sorted*/
		if(i == a.length- 1){
			return 2;	 
		}
			
		return 0;
		}
}			
		
/**		Another algorithm
		int type_of_sort =0;
		boolean flag_asc =false, flag_dsc = false;
		int l = a.length;
		for(int i=0; i < l/2; i++) {
			if(a[i] < a[l-1-i]) {
				flag_asc = true;
			}else if( a[i] > a[l-1 -i]){
				flag_dsc = true;
			}
		}
		
		if(flag_asc & flag_dsc)
			type_of_sort = 0;
		else if(flag_asc & !flag_dsc)
			type_of_sort =1;
		else
			type_of_sort =2;
	
		return type_of_sort;
	}
**/
