package assignment2;

/** Swap adjacent elements*/
public class BubbleSort extends ComparisonSort {
	//Time: O(n2)
	public void sort() {
		for(int index = 0; index < input.size()- 1; index++) {
			for(int next = 0; next< input.size()- 1 - index; next++) {
				if( input.get(next+1) < input.get(next) ) {
					swap( next, next+1 );
 				}
			}
		}
	}
		
	public static void main(String[] args) {
		BubbleSort q = new BubbleSort();
		
		long startTime = System.currentTimeMillis();
		for(int i = 100; i > 0; i--) {
			q.add(i);
		}
		
		q.sort();
		long stopTime = System.currentTimeMillis();
	    long elapsedTime = stopTime - startTime;
	    System.out.println(elapsedTime);
		System.out.println( q.getList());
	}
}
