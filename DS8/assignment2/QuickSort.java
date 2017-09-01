package assignment2;

public class QuickSort extends ComparisonSort{

	@Override
	public void sort() {
		quickSort(0, input.size()-1);
	}

	private void quickSort(int startIndex, int endIndex) {
		if( startIndex < endIndex ) {
			int pivot = partition( startIndex, endIndex );
			
			quickSort(startIndex, pivot-1);
			quickSort(pivot+1   , endIndex);
		}
	}
	
	private int partition(int startIndex, int endIndex) {
		int pivot 	  = input.get( endIndex );
		int leftIndex = startIndex-1;
		
		for(int rightIndex = startIndex; rightIndex < endIndex; rightIndex++) {
			if( input.get(rightIndex) <= pivot) {
				//swap to left side all smaller elements
				swap(++leftIndex, rightIndex);
			}
		}
		
		//swap pivot with leftIndex
		swap(++leftIndex, endIndex);
		//now only pivot element is at proper position
		
		//return the pivot position = leftindex
		return leftIndex;
	}

	public static void main(String[] args) {
		QuickSort q = new QuickSort();
		
		long startTime = System.currentTimeMillis();
		for(int i = 9; i > 0; i--) {
			q.add(i);
		}
		
		q.sort();
		long stopTime = System.currentTimeMillis();
	    long elapsedTime = stopTime - startTime;
	    System.out.println(elapsedTime);
		System.out.println( q.getList());
	}
}
