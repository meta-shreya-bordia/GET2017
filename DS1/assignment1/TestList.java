package assignment1;

import java.util.*;

public class TestList {
	public static void main(String[] args){
		List<Integer> list = new ArrayList<Integer>(1);
		
		list.add(1);
		list.add(2);
		list.add(10);
		list.add(null);
		
		list.remove(1);
		Integer j = new Integer(100);
		
		System.out.println( list.remove(j) );
		
//		list.add(true);
//		list.add(0, 'a');
//		int[] l = {90, 100};		
//		list.addAll(l);
		
		//System.out.println(list.toString() + " "+ list.size());
		
		IList<Integer> list1 = new MyArrayList<Integer>();
		IList<Integer> list2 = new MyArrayList<Integer>(2);
		
		//System.out.println( list1.size()+ " "+ list2.size() );
		
		for(int i=0; i < 15; i++){
			list1.add(i);		
			list2.add(i, 10+i);
			
			//System.out.println(list1.size() + " " +list2.size() );
		}
		
		for(int i=14; i>=0; i--){
			list1.remove(i);
	//		list2.remove(10+i);
			
			System.out.println( list1.size() + " " +list2.size() );
		}
	}
}
