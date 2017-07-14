package assignment2;

// find unique elements of an array
public class RemoveDuplicate {
	
	/* Replace each repeating element with
	 * maximum possible integer size 
	 * */
	public int[] removeDuplicate(int[] n) {
		int[] tmp= new int[n.length];			
		int k=0;
		final int MAX = Integer.MAX_VALUE;
		
		for(int i=0; i< n.length; i++) {
			if(n[i] != MAX) {
				for(int j=i+1; j<n.length; j++) {
					if(n[j] != MAX){
						if(n[i] == n[j]){
							n[j] = MAX;
						}
					}
				}
				tmp[k++] = n[i];
			}
		}

		int[] out = new int[k];
			for(int i=0; i<k; i++){
			out[i]= tmp[i];
		}
		return out; 
	}
}
