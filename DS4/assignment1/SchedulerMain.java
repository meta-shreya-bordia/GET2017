package assignment1;

/**@Class	SchedulerMain
 * allocate printer to priority of a document
 * for same priority, FCFS priority is used.
 **/
public class SchedulerMain {

	public static void main(String[] args){
		Printer printer = new Printer();
		
		while(true){
			printer.getUserOption();
		}
	}
}