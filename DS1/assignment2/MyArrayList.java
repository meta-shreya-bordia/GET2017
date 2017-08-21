package assignment2;

import java.util.Collection;

public class MyArrayList<E extends Object> implements MyList<E>{
	private Object[] array_list;
	private int total_elements;
	private int _length;
	
	private final int DEFAULT_SIZE = 10;
	
	public MyArrayList(){
		_length = DEFAULT_SIZE;
		total_elements = 0;
		array_list = new Object[DEFAULT_SIZE];
	}
	
	public MyArrayList(int size){
		this._length = size;
		array_list = new Object[this._length];
	}
	
	/**@method	addAll(Collection<E> list)
	 * supports all types of objects to be added to array_list
	 * if their types(instance of same class matches)
	 * add an element to array_list element by element
	 **/
//original:	public boolean addAll(int index, Collection<E> list){
	public void addAll(MyArrayList<E> list){
		//check that list2 is not null
		if(list == null || list.size() <= 0){
			throw new NullPointerException();
		}
		
		//check that the list1 and list2 are of same type
		/*if(list.getClass()  array_list.getClass()){
			
		}*/
		
		for(int index = 0; index < list.size(); index++){
			add((E)list.get(index));
		}
	}
	
	public void resize(){
		Object[] copyTo = new Object[ _length*2 ];
		for(int index=0; index < _length; index++){
			copyTo[index] = array_list[index];
		}
		
		this.array_list = copyTo;
	}
	
	@Override
	public boolean add(E element) {
		if(size() == _length){
			resize();
		}
		
		array_list[total_elements++] = element;
		return true;
	}

	@Override
	public void add(int index, E element) {
		isValidIndex(index);
		if (size() == _length) {
			resize();
		}

		//shift right
		shiftRight(index);

		array_list[index] = element;
	}

	@Override
	public E remove(int index) {
		isValidIndex(index);
		
		E element = (E)array_list[index];
		
		//shift left
		shiftLeft(index);
		
		total_elements--;
		return element;
	}

	@Override
	public boolean remove(E element) {
		int position = indexOf(element);
		remove(position);
		return true;
	}
	
	@Override
	public void clear(){
		array_list = new Object[DEFAULT_SIZE];
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
		for(int position = 0; position < size(); position++){
			if(array_list[position] == element){
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
	// ArrayList uses merge sort
	@Override
	public void sort(){
		
	}
	
	public int size() {
		return this.total_elements;
	}
	
	/**********How to iterate over the list.*********/
//	public E[] getList(){
//		return (E)array_list;
//	}
	
	private boolean isValidIndex(int index){
		if(index< 0 || index > size()){
			throw new IndexOutOfBoundsException();
		}
		return true;
	}
	
	//linear left shift
	private void shiftLeft(int position){
		for (int shift_element = position; shift_element < total_elements; shift_element++) {
			array_list[shift_element] = array_list[shift_element+1];
		}
	}
	
	//linear right shift
	private void shiftRight(int position){
		for (int shift_element = total_elements; shift_element > position; shift_element--) {
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
		for(int index = start_index; index <= end_index; index++){
			
		}
	}
}
