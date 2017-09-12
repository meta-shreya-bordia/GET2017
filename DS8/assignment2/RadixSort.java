package assignment2;

import java.util.Arrays;

public class RadixSort extends LinearSort{
	
	//Time Complexity: O( d*(n+b))
	@Override
	public void sort() {
		int maxNumber= findMax();
		
		Integer[] toSort = new Integer[ input.size()];
		input.toArray(toSort);
		
		for( int exponent = 1; maxNumber/exponent > 0; exponent *= 10){
			toSort = countingSort(toSort, exponent);
		}
		
        this.input = Arrays.asList(toSort);
	}
	
	private Integer[] countingSort(Integer[] toSort, int digitsPlace){
		int[] count = new int[10];
		Integer[] output = new Integer[ toSort.length ];
		
		//add count of each digit from the digit position
		for(int index =0; index< toSort.length; index++){
			count[ (toSort[index]/digitsPlace)%10 ] += 1;
		}
		
		for(int counter = 1; counter < count.length; counter++){
			count[counter] += count[counter -1];
		}
		
		for(int index = toSort.length-1; index >= 0; index--){
			int position = (toSort[index]/digitsPlace)%10;
			output[count[position] -1] = toSort[index];
            count[position] 		 -= 1;
		}
	
		return output;
	}
	
	public static void main(String[] args){
		RadixSort r = new RadixSort();
		
		for(int i = 4; i>=0; i--){
			r.add(i);
			r.add(100+i);
		}
		
		r.sort();
		
		System.out.println( r.getList());
	}
}
