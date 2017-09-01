package assignment2;

import java.util.*;

public abstract class Sort {
	List<Integer> input = new LinkedList<Integer>();;
	
	public abstract void sort();
	
	public List<Integer> getList(){
		return this.input;
	}
	
	public void setList(List<Integer> addInput){
		this.input = addInput;
	}
	
	public boolean add(Integer number) {
		if( number == null) {
			return false;
		}
		
		return input.add(number);
	}
	
	public boolean remove(Integer element) {
		return input.remove(element);
	}
	
	public int size() {
		return input.size();
	}
}
