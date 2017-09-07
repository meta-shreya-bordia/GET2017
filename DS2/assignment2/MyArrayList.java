package assignment2;

public class MyArrayList<E extends Object> implements IList<E>{
	private Object[] array_list;
	private int total_elements;
	private int size;
	
	public MyArrayList(){
		size = DEFAULT_SIZE;
		total_elements = 0;
		array_list = new Object[DEFAULT_SIZE];
	}
	
	public MyArrayList(int size){
		this.size = size;
		array_list = new Object[this.size];
	}
	
	private void resize(){
		size *= 2;
		Object[] copyTo = new Object[size];
		for(int index = 0; index < size/2; index++){
			copyTo[index] = array_list[index];
		}
		
		this.array_list = copyTo;
	}
	
	@Override
	public boolean add(E element) {
		if(total_elements == size){
			resize();
		}
		
		array_list[total_elements++] = element;
		return true;
	}

	@Override
	public void add(int index, E element) {
		isValidIndex(index);
		if (total_elements == size) {
			resize();
		}

		//shift right
		shiftRight(index);

		array_list[index] = element;
		total_elements++;
	}

	@Override
	public E remove(int index) {
		isValidIndex(index);
		
		E element = (E)array_list[index];
		
		//shift left
		shiftLeft(index);
		
		total_elements--;
//		System.out.println(total_elements + " " + size());
		return element;
	}

	@Override
	public boolean remove(E element) {
		int position = indexOf(element);
		if(position == -1){
			return false;
		}
		
		if ( remove(position) != null ){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public void clear(){
		array_list = new Object[DEFAULT_SIZE];
		total_elements = 0;
	}
	
	/**@method	get(index)
	 * Returns the element at the specified position in this list.
	 **/
	@Override
	public E get(int index){
		isValidIndex(index);
		return (E)array_list[index];
	}
	
	/**@Method	indexOf(E element)
	 * Returns the index of the first occurrence of the specified element in this list
	 *  or -1 if this list does not contain the element.
	 **/
	//linear search
	@Override
	public int indexOf(E element){
		for(int position = 0; position < total_elements; position++){
			if( array_list[position].equals( element )){
				return position;
			}
		}
		return -1;
	}
	
	/**@method	reverse
	 * swaps from the middle
	 * time: O(n/2) space: O(1)
	 **/
	@Override
	public void reverse(){
		for(int index = 0; index < size()/2; index++){
			E swap 			  = (E)array_list[index];
			array_list[index] = array_list[size() - index - 1];
			array_list[size() - index - 1]= swap;
		}
	}
	
	/**@method	sort
	 * sort the elements of the array in ascending order
	 * Uses comparable interface to compare 2 objects
	 * time: O(n)
	 **/
	// ArrayList uses merge sort: O(n log n)
	@Override
	public <E extends Comparable<E>> void sort(){
		if(size() == 0 || size() == 1){
			return;
		}
		
		this.mergeSort(0, size()-1);
	}
	
	@Override
	public int size() {
		return this.total_elements;
	}
	
	private boolean isValidIndex(int index){
		if(index< 0 || index > size()){
			throw new IndexOutOfBoundsException();
		}
		return true;
	}
	
	//linear left shift
	private void shiftLeft(int position){
		for (int shift_element = position; shift_element < size(); shift_element++) {
			array_list[shift_element] = array_list[shift_element+1];
		}
	}
	
	//linear right shift
	private void shiftRight(int position){
		for (int shift_element = size(); shift_element > position; shift_element--) {
			array_list[shift_element] = array_list[shift_element + 1];
		}
	}
	
	private void mergeSort(int start_index, int end_index){
		if(start_index < end_index){
			int middle = start_index + (end_index - start_index)/2;
			
			mergeSort(start_index, middle);
			mergeSort(middle+1, end_index);
			merge(start_index, middle, end_index);
		}
	}
	
	
	private void merge(int start_index, int middle, int end_index){
		Object[] left_array = new Object[middle - start_index +1];
		Object[] right_array= new Object[end_index - middle];
		
		int lindex =0, rindex =0;
		
		for(lindex = 0; lindex < left_array.length; lindex++) {
			left_array[lindex] = array_list[start_index + lindex];
		}
		
		for(rindex = 0; rindex < right_array.length; rindex++) {
			right_array[rindex] = array_list[middle + 1 + rindex];
		}
		
		lindex= 0; rindex=0;
		int k = start_index;
		
		while(lindex < left_array.length && rindex < right_array.length) {
			if( (left_array[lindex]).toString().compareTo(right_array[rindex].toString()) <= 0) {
				array_list[k++] = left_array[lindex++];
			}else {
				array_list[k++] = right_array[rindex++];
			}
		}
		
		while(lindex < left_array.length) {
			array_list[k++] = left_array[lindex++];
		}
		
		while(rindex < right_array.length) {
			array_list[k++] = right_array[rindex++];
		}
	}
}
