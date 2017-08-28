package assignment3;

import java.util.*;

public class SortedLinkedList<E> {
	
	List<E> sortedList;
	
	public SortedLinkedList(){
		sortedList = new LinkedList<E>();
	}
	
	public boolean add(E element){
		if( element == null ){
			return false;
		}
		
		int position = 0;		
		add(position, element);
		return true;
	}
	
	private void add(int position, E element){
		if( size() == 0 ){
			sortedList.add(element);
		}else if(sortedList.size() == position){
			sortedList.add(size(), element);
		}else{
			if(element.toString().compareTo(sortedList.get(position).toString())>0){
				add(position+1, element);
			}else{
				sortedList.add(position, element);
			}
		}
	}
	
	public List<E> getSortedList(){
		return this.sortedList;
	}
	
	public int size(){
		return sortedList.size();
	}
	
	public E get(int index){
		if(index < 0 || index >= sortedList.size()){
			return null;
		}
		return sortedList.get(index);
	}
}
