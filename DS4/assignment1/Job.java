package assignment1;

/**@Class	Define the priority of job
 * sender of job
 * and document type
**/
public class Job {
	private int priority;
	private int sequenceNumber;
	private String senderType;
	private String document;
	
	public Job(){
		
	}
	
	/**
	 * The priority of the document is set by the type of sender.
	 * The sequence number is selected by a static counter that keeps count of all arriving jobs.
	 **/
	public Job(int priority, int sequenceNumber, String senderType, String document){
		this.priority	= priority;
		this.sequenceNumber= sequenceNumber;
		this.document   = document;
		this.senderType = senderType;
	}

	public int getPriority() {
		return priority;
	}

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public String getSenderType() {
		return senderType;
	}

	public String getDocument() {
		return document;
	}
	
	
}
