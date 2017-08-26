package assignment1;

/**@Class	PriorityQueue
 * Max Heap based on priority and sequence number(arrival number)
 **/
public class PriorityQueue{
	private int totalElements;				// Current count of elements in queue
	private Job[] jobToAllocate;			// Priority Queue
	private final int DEFAULT_SIZE = 10;	// Let the default size be 10: resize to fit jobs
	private int size;
	
	public PriorityQueue(){
		size = DEFAULT_SIZE;
		jobToAllocate = new Job[size];
	}
	
	/**@Method	setPriority()
	 * The priority queue is sorted upon each addition of job
	 * and upon completion of each job
	 * by MAX HEAP: heapify on the basis of priority number
	 **/
	public void setPriority(){
		/*TODO*/
	}
	
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
	
	/**@Method	size()
	 * get total number of jobs in queue
	 **/
	public int size(){
		return this.totalElements;
	}
/*******PRIORITY QUEUE OPERATIONS***********/	
	public void enqueue(Job addJob){
		if(size() == size){
			resize();
		}
		
		//add at end of Queue
		jobToAllocate[totalElements++] = addJob;
		//build the queue again when new element is added
		buildHeap();
	}
	
	public Job dequeue(){
		if(isEmpty()){
			return null;
		}
		
		return jobToAllocate[totalElements--];
	}
	
	public Job[] getPriorityQueue(){
		return this.jobToAllocate;
	}
	
	public Job[] printQueue(){
		return this.heapSort();
	}
	
	private boolean isEmpty(){
		return(this.totalElements == 0);
	}
	
/***********HEAP METHODS***************/	
	/**@Method	heapSort
	 * first build the heap. Then sort it.
	**/
	private Job[] heapSort(){
		if(this.isEmpty()){
			return null;
		}
		
		buildHeap();
		
		int numberOfJobs =0;
		Job[] printJobs = new Job[size()];
		
		for(int lastIndex = size(); lastIndex > 0; lastIndex--){
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
	 **/
	private void buildHeap(){
		for(int startIndex = (size()/2)-1; startIndex >= 0; startIndex--){
			maxHeapify(startIndex);
		}
	}
	
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