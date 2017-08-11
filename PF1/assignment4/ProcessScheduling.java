package assignment4;

//Process scheduling using First Come First Serve(FCFS)
public class ProcessScheduling {
	/**
	 * Method: isArrayEqual(int[][] expected, int[][] actual)
	 * compare two 2D array elements. Returns false if any element differs.
	 * @param expected	expected result for given functionality
	 * @param actual	value returned by method
	 * @return 			type = boolean	
	 * **/
	public boolean isArrayEqual(int[][] expected, int[][] actual){
		boolean flag= true;
				
		for(int row=0; row< actual.length; row++){
			for(int column=0; column< actual[0].length; column++){
				if(actual[row][column] != expected[row][column]){
					flag= false;
					break;
				}
			}
		}
		
		return flag;
	}
	 
	/**
	 * Method: FCFS(int[] arrival_time, int[] job_size)
	 * create Process schedule 
	 * @param arrival_time	when process arrives
	 * @param job_size		process execution time
	 * @return 				type = int[][]	
	 * **/
	public int[][] FCFS( int arrival_time[], int job_size[] ) {
		int total_finish_time=0;
		int result_array[][]=new int[arrival_time.length][5];
	 
		for(int i=0;i< arrival_time.length ;i++){
			result_array[i][0] = i+1;						//Assign Process id no
			result_array[i][1] = arrival_time[i];			//Arrival time of each process
			
			if(total_finish_time < arrival_time[i]){		//if new process arrives after running process completes
				result_array[i][2] = 0;						//   then no waiting time and process starts at same time
				result_array[i][3] = arrival_time[i];		
			}else{											//else process waits for process to finish
				result_array[i][2] = total_finish_time + arrival_time[i];
				result_array[i][3] = total_finish_time + 1;
			}
			
			total_finish_time += job_size[i] + result_array[i][3];	
			result_array[i][4] = total_finish_time;			//finish time of a process
		}
		return result_array;	
	}
}
