package assignment4;
import org.junit.*;

public class ProcessSchedulingTest {
	ProcessScheduling process;
	
	@Before
	public void setUp(){
		process = new ProcessScheduling();
	}

/** Positive Cases: */
	//Normal Case: processes with different arrival time
	@Test
	public void testDifferentArrivalTime(){
		int[] arrival_time= {1,5,9,25};
		int[] job_size    = {12,7,2,5};
		
		int[][] expected = {{1, 1, 0, 1, 12}, 
							{2, 5, 8, 13, 19},
							{3, 9, 11, 20, 21},
							{4, 25, 0, 25, 29}
							};
		// return if expected 2D is equal to actual 2D
		Assert.assertEquals(true, process.isArrayEqual(expected, process.FCFS(arrival_time, job_size)));
	}

	// when process arrives before CPU starts
	@Test
	public void testArrivalTimeWait(){
		int[] arrival_time= {0, 1, 5, 9, 25};
		int[] job_size    = {4, 12,7,2,5};
		
		int[][] expected = {{1, 0, 1, 1, 4},
							{2, 1, 2, 5, 16}, 
							{3, 5, 11, 17, 23},
							{4, 9, 16, 24, 26},
							{5, 25, 1, 27, 31}
							};		
		// return if expected 2D is equal to actual 2D
		Assert.assertEquals(true, process.isArrayEqual(expected, process.FCFS(arrival_time, job_size)));
	}
	
	// when 2 processes arrive at same time
	@Test
	public void testSameArrivalTime(){
		int[] arrival_time= {2, 5, 5};
		int[] job_size    = {1, 12, 7};
		
		int[][] expected = {{1, 2, 0, 2, 2},
							{2, 5, 0, 5, 17},
							{3, 5, 12, 28, 25},
							};
		// return if expected 2D is equal to actual 2D
		Assert.assertEquals(true, process.isArrayEqual(expected, process.FCFS(arrival_time, job_size)));
	}
}
