package assignment2;

import java.util.*;

public class Controller {
	SortingView view = new SortingView();
	Sort sort;
	List<Integer> inputArray = new LinkedList<Integer>();
	
	/** 1. add element
	 *  2. remove element
	 *  3. Comparison sorting
	 *  4. linear sorting
	**/
	public String performAction(int option){
		boolean flag = false;
		
		switch(option){
		case 1: 
			int element = view.getElement();
			
			if( element < 0){
				return "No negative elements. Add another?";
			}else{
				inputArray.add( element );
				return "Element added successfully";
			}
			
		case 2: 
			element = view.getElement();
			
			if( inputArray.contains( element )){
				inputArray.remove( new Integer( element ) );
				return "Element removed from the list.";
			}else{
				return "No element found. Cannot remove the element";
			}
			
		case 3:	//Comparison Sort: LargeSize: QS; Small Size: BubbleSort
			if ( (flag = ComparisonSort.largeSize( inputArray )) ){
				sort = new QuickSort();
			}else{
				sort = new BubbleSort();
			}

			sort.setList(inputArray);
			sort.sort();

			String output = "";
			if(flag){
				output += "System has used Quick Sort sorting technique and sorted list as below :\n";
			}else{
				output += "System has used Bubble Sort sorting technique and sorted list as below :\n";
			}
			
			return output+sort.getList().toString();
			
		case 4:	//Linear Sort: Large Number: RS; Small Numbers: CS 
			if( flag = LinearSort.hasLargeDigits(inputArray) ){
				sort = new RadixSort();
			}else{
				sort = new CountingSort();				
			}
			
			sort.setList(inputArray);
			sort.sort();
			
			output = "";
			if(flag){
				output += "System has used Radix Sort sorting technique and sorted list as below :\n";
			}else{
				output += "System has used Counting Sort sorting technique and sorted list as below :\n";
			}
			
			return output+sort.getList().toString();
		case 5:
			System.exit(0);
		
		default:
			return "Invalid Option. Enter again.";
		}
	}
}
