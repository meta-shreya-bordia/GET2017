package assignment1;

/**@Class	PriorityQueue
 * Max Heap based on priority and sequence number(arrival number)
 **/
public class PriorityQueue{
	private int totalElements = 0;			// Current count of elements in queue
	private Job[] jobToAllocate;			// Priority Queue
	private final int DEFAULT_SIZE = 10;	// Let the default size be 10: resize to fit jobs
	private int size;
	
	public PriorityQueue(){
		size = DEFAULT_SIZE;
		jobToAllocate = new Job[size];
	}
	
/*******COMPUTATIONS********/
	/**@Method	resize
	 * increase queue size by resizing
	 **/
	private void resize(){
		if(totalElements == size){
			size = size*2;
		}
		Job[] copyTo = new Job[size];
		
		for(int i=0; i< totalElements; i++){
			copyTo[i] = jobToAllocate[i];
		}
		
		this.jobToAllocate = copyTo;
	}
	
	/**@Method	isEmpty()
	 * check if queue is empty
	 * @return	type = boolean
	 **/
	private boolean isEmpty(){
		return(this.totalElements == 0);
	}
	
	/**@Method	size()
	 * get total number of jobs in queue
	 * @return	type = int
	 **/
	public int size(){
		return this.totalElements;
	}
	
	/**@Method	clear
	 * clear queue after printing
	 **/
	public void clear(){
		size = DEFAULT_SIZE;
		jobToAllocate = new Job[size];
	}
	
/*******PRIORITY QUEUE OPERATIONS***********/	
	/**@Method	enqueue(Job addJob)
	 * add a new job to the queue
	 * if queue size is reached, resize array
	 * then maxHeapify: re-order queue
	 **/
	public void enqueue(Job addJob){
		if(size() == size){
			resize();
		}
		
		//add at end of Queue
		jobToAllocate[totalElements++] = addJob;
		//build the queue again when new element is added
		buildHeap();
	}
	
/***********HEAP METHODS***************/	
	/**@Method	printQueue(heapSort)
	 * print all queue elements
	 * implements the heap sort algorithm
	 * @return	type = Job array: max priority jobs are printed first
	**/
	//Time Complexity: O(n log(n))
	public Job[] printQueue(){
		if(this.isEmpty()){
			return null;
		}
		
		int numberOfJobs =0;
		Job[] printJobs = new Job[size()];
		
		for(int lastIndex = size()-1; lastIndex >= 0; lastIndex--){
			Job swap = jobToAllocate[0];
			jobToAllocate[0] = jobToAllocate[lastIndex];
			jobToAllocate[lastIndex] = swap;
			
			printJobs[numberOfJobs++] = jobToAllocate[lastIndex];
			totalElements--;
			
			maxHeapify(lastIndex);
 		}
		
		return printJobs;
	}
	
	/**@Method	buildHeap()
	 * rearrange array to form a max heap
	 * compute max-heap only for parent nodes
	 * (exclude all leaf nodes)
	 **/
	private void buildHeap(){
		for(int startIndex = (size()/2)-1; startIndex >= 0; startIndex--){
			maxHeapify(startIndex);
		}
	}
	
	/**@Method	maxHeapify(int parentIndex)
	 * recursively check that the left & right child nodes do not have higher priority
	 * than the parent node
	 * Max Priority nodes are moved to the top of tree
	 * When same priority, sort on the basis of sequence number(time of entry in the queue)
	 **/
	private void maxHeapify(int parentIndex){
		int leftChild  = left(parentIndex);		//left child
		int rightChild = right(parentIndex);	//right child
		int largest    = parentIndex;			//parent
		
		/**Condition to check if the left child of a node has greater priority than the parent node
		 * i.e
		 * Condition 1: Node should have a left Child
		 * 		only then
		 * Condition 2: compare the left child(entering later into the queue) has higher priority than parent
		 * 		OR
		 * Condition 3: if left child and parent node have the same priority
		 * 					then if left child entered the queue before the largest node
		 * 			
		 * THEN: set largest priority index = left child index
		 **/
		if( leftChild < size() &&
			( jobToAllocate[leftChild].getPriority() > jobToAllocate[largest].getPriority() 
				|| ( jobToAllocate[leftChild].getPriority() == jobToAllocate[largest].getPriority() 
					&& jobToAllocate[leftChild].getSequenceNumber() < jobToAllocate[largest].getSequenceNumber()
				)  
			) 
		  ){
			largest = leftChild;
		}
		
		/**Condition to check if the right child of a node has greater priority than parent/left node
		 * i.e
		 * Condition 1: Node should have a left Child
		 * 		only then
		 * Condition 2: compare the left child(entering later into the queue) has higher priority than parent
		 * 		OR
		 * Condition 3: if left child and parent node have the same priority
		 * 					then if left child entered the queue before the largest node
		 * 			
		 * THEN: set largest priority index = left child index
		 **/
		if( rightChild <size() && 
			(jobToAllocate[rightChild].getPriority() > jobToAllocate[largest].getPriority()
				|| ( jobToAllocate[rightChild].getPriority() == jobToAllocate[largest].getPriority() 
						&& jobToAllocate[rightChild].getSequenceNumber() < jobToAllocate[largest].getSequenceNumber() )	
			)	
		  ){
			largest = rightChild;
		}
		
		
		/**Condition to check whether to swap nodes or not 
		 * If largest index is not equal to the parent index
		 * 		then a higher priority process has been found and heap must be heapified.
		 * **/
		if( largest != parentIndex){
			//swap these values: then heapify with largest
			Job swapper = jobToAllocate[parentIndex];
			jobToAllocate[parentIndex] = jobToAllocate[largest];
			jobToAllocate[largest]	   = swapper;
			
			maxHeapify(largest);
		}
	}
	
	private int left(int parent){
		return parent*2 + 1;
	}
	
	private int right(int parent){
		return parent*2 + 2;
	}
}