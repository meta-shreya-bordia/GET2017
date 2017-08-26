package assignment1;

import java.util.Scanner;

public class Controller {
	private int sequenceNumber = 0;			// Count number of jobs that are entered into the queue. Always increasing.
	private Scanner input;
	private PriorityQueue jobs;
	
	public Controller(){
		jobs  = new PriorityQueue();
		input = new Scanner(System.in);
	}
	
	private void startMenu(){
		System.out.println("Welcome to the Printer:"
						+ "\n 1 Add a document to print"
						+ "\n 2 Print your documents"
						+ "\3 3 Exit");
	}
	
	public void getUserOption(){
		startMenu();

		int menuOption = input.nextInt();
		executeMenuOperation(menuOption);
	}
	
	public void printUserType(){
		System.out.println("Please provide us your information:"
				+ "\n 1 Department Chair(chair)"
				+ "\n 2 Professor"
				+ "\n 3 Graduate"
				+ "\n 4 Undergraduate");
	}
	
	public Job getDocumentDetails(){
		System.out.println("Enter Document Name: ");
		String documentName = input.next();
		
		printUserType();
		String senderType = input.next();
		int priority = getPriority(senderType.trim());
		
		while(priority == 0){
			senderType = input.next();
			priority = getPriority( senderType.trim() );
		}
		
		// pass priority(option selected), 
		return new Job(priority, getSequenceNumber(), senderType, documentName);
	}

	private int getPriority(String senderType){
		int priority = 0;
		
		if( "chair".equalsIgnoreCase( senderType ) ) {
			priority = 4;
		}else if( "professor".equalsIgnoreCase( senderType ) ){
			priority = 3;
		}else if( "graduate".equalsIgnoreCase( senderType ) ){
			priority = 2;
		}else if( "undergraduate".equalsIgnoreCase( senderType ) ){
			priority = 1;
		}
		
		return priority;
	}
		
	private int getSequenceNumber(){
		return this.sequenceNumber++;
	}
	
	private void executeMenuOperation(int option){
		switch(option){
		case 1:
			jobs.enqueue( getDocumentDetails() );
			//add this document to Queue
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
	
	public void printPrinterDetails(Job[] printJobs){
		System.out.println("All documents printed are: "
						+ "\n Document Name\t Document Sender\t Document Priority");
		
		for( int i =0; i< printJobs.length; i++){
			System.out.println(printJobs[i].getDocument()
							+"\t"+ printJobs[i].getSenderType()
							+"\t"+ printJobs[i].getPriority());
		}
	}
}
