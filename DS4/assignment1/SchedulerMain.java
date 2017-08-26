package assignment1;

/**@Class	SchedulerMain
 * allocate printer to priority of a document
 * for same priority, FCFS priority is used.s
 **/
public class SchedulerMain {

	public static void main(String[] args){
		Scheduler scheduleJobs = new Scheduler();
		scheduleJobs.allocatePrinter();
	}
}
