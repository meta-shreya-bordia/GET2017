package assignment6;

/**This is the program to join two sorted array into a third sorted array.In this program 
 * I assume that either the two sorted arrays are in ascending order or are n descending order and 
 * returned array is in same order as in input array.
 */
public class MergeArrays {
	/**
	 * Two arrays a and b are sorted (either ascending or descending)
	 * sorted merging is applied by the method join
	 * creating an array c
	 * **/
	int[] join(int a[], int a_size, int b[], int b_size, int c[]){
		int i=0,j=0,k=0;
		if(a_size==0)
			return b;
		else if(b_size==0)
			return a;
		
		// if both arrays are in ascending order
		if(a[0]<= a[1] & b[0] <= b[1]){
			while(i<a_size & j<b_size){
				if(a[i] <= b[j]){
					c[k++] = a[i++];
				}else{
					c[k++] = b[j++];
				}
			}
		
			while(i < a.length){
				c[k++] = a[i++];
			}

			while (j < b.length){
				c[k++] = b[j++];
			}
		// if both arrays are in descending order
		}else if (a[0] > a[1] & b[0] > b[1]){

			while(i<a_size & j<b_size){
				if(a[i] >=b[j]){
					c[k++] = a[i++];
		        }else{
		            c[k++] = b[j++];
		        }		       
			}
			while(i < a.length){
				c[k++] = a[i++];
			}
			while (j < b.length){
				c[k++] = b[j++];
			}
		}
		//return sorted array
		return c;	
	}
}