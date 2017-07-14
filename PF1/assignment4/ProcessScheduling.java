package assignment4;

//Process scheduling using First Come First Serve(FCFS)
public class ProcessScheduling {
	public boolean isArrayEqual(int[][] expected, int[][] actual){
		boolean flag= true;
				
		for(int row=0; row< actual.length; row++){
			for(int column=0; column< actual[0].length; column++){
				if(actual[row][column] == expected[row][column]){
					flag= false;
					break;
				}
			}
		}
		return flag;
	}
	 
	public int[][] FCFS( int arrival_time[], int job_size[] ) {
		int i,j,start_time=1;
		int result_array[][]=new int[arrival_time.length][5];
	 
		for(i=0,j=0;i<arrival_time.length;i++){
			result_array[i][j]=i+1;
		}
	 
		result_array[0][1]=arrival_time[0];
		result_array[0][2]=start_time-arrival_time[0];
		result_array[0][3]=arrival_time[0];
		result_array[0][4]=job_size[0]+result_array[0][3]-1;
	 
		for(i=1;i< arrival_time.length ;i++){
			if(result_array[i-1][4]<arrival_time[i]){
				result_array[i][1]=arrival_time[i];
				result_array[i][3]=arrival_time[i];
				result_array[i][2]=0;
				result_array[i][4]=job_size[i]+result_array[i][3]-1;
			}else{
				result_array[i][1]=arrival_time[i];
				result_array[i][3]=result_array[i-1][4]+1;
				result_array[i][4]=job_size[i]+result_array[i][3]-1;
				result_array[i][2]=result_array[i][3]-result_array[i][1];
			}
		}
		return result_array;	
	}
}