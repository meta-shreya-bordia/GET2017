package assignment1;

import java.util.Scanner;

public class Printer {
	private int sequenceNumber = 0;		// Count number of jobs that are entered into the queue. Always increasing.
	private Scanner input;
	private PriorityQueue jobs;
	
	public Printer(){
		jobs  = new PriorityQueue();
		input = new Scanner(System.in);
	}

/******INPUT OPERATIONS******/
	/**@Method	getUserOption()
	 * execution starts here
	 * display menu
	 * get user option
	 * and perform operation on selected option
	 **/
	public void getUserOption(){
		startMenu();
		int menuOption = input.nextInt();
		performAction(menuOption);
	}
	
	/**@Method	getDocumentDetails()
	 * get all details of the job
	 * and create a Job object
	 * to be added to the queue
	 * @return	type = Job object 
	**/
	private Job getDocumentDetails(){
		System.out.println("Enter Document Name: ");
		String documentName = input.next();
		
		printUserType();
		int priority = input.nextInt();
		String senderType = getSenderType(priority);
		
		while(senderType == null){
			priority = input.nextInt();
			senderType = getSenderType(priority);
		}
		
		// pass priority(option selected), 
		return new Job(priority, getSequenceNumber(), senderType, documentName);
	}

/*****OUTPUT OPERATIONS****/
	/**@Method	printUserType()
	 * display types of users which decides priority for printing
	 * @return	type = void
	 **/
	private void printUserType(){
		System.out.println("Please provide us your information:"
				+ "\n1 Undergraduate"
				+ "\n2 Graduate"
				+ "\n3 Professor"
				+ "\n4 Department Chair");
	}
	
	/**@Method 	startMenu()
	 * display list of options to access printer
	 * @return	type = void
	 **/
	private void startMenu(){
		System.out.println("Welcome to the Printer:"
						+ "\n1 Add a document to print"
						+ "\n2 Print your documents"
						+ "\n3 Exit");
	}
	
	/**@Method	printPrinterDetails(Job[] printJobs)
	 * @param	Job[] printJobs
	 * print collection of all documents available to print
	 * and clear the printer queue
	 * if no pending documents are found, print error message
	 * @return	type = void, prints onto console documents queued
	 **/
	public void printPrinterDetails(Job[] printJobs){
		if(printJobs == null){
			System.out.println( "No pending documents to print"
							+ "\nAdd a document?" );
			return;
		}
		
		System.out.println("All documents printed are: "
						+ "\nDocument Name\t Document Sender\t Document Priority");
		
		for( int i =0; i< printJobs.length; i++){
			System.out.println(printJobs[i].getDocument()
							+"\t\t\t"+ printJobs[i].getSenderType()
							+"\t\t\t"+ printJobs[i].getPriority());
		}
		
		//Clear the documents to print
		jobs.clear();
	}

/*****COMPUTATIONS*****/	
	/**@Method	getSenderType(int priority)
	 * get sender type based on option selected
	 * @return	String of senderType
	 **/
	private String getSenderType(int priority){
		String senderType = null;
		switch(priority){
		case 4: senderType = "Department Chair";
			break;
		case 3: senderType = "Professor";
			break;
		case 2: senderType = "Graduate";
			break;
		case 1: senderType = "Undergraduate";
			break;
		}
		
		return senderType;
	}
		
	/**@Method getSequenceNumber()
	 * continously increasing series of sequence number
	 **/
	private int getSequenceNumber(){
		return this.sequenceNumber++;
	}
	
	/**@Method	performAction(int option)
	 * perform action based on the menu item selected
	 * 
	 * 1: add an item to print
	 * 		enqueue this item in the printing queue
	 * 2: print the pending documents in order of priority
	 * 3: Exit the application
	**/
	private void performAction(int option){
		switch(option){
		case 1:
			//add a new document to Queue
			jobs.enqueue( getDocumentDetails() );
			System.out.println("Your document has been queued for printing.");
			break;
		case 2:
			//get all jobs in the queue
			printPrinterDetails(jobs.printQueue() );
			break;
		case 3:
			System.exit(0);
		default:
			System.out.println("Invalid Option");
		}
	}
}
