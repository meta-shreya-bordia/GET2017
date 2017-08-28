package assignment1;

public class ConcordanceInStringMain {
	
	public static void main(String[] args) {
		String findConcordance = "";
		
		ConcordanceInString operation = new ConcordanceInString();
		
		for(int index =0; index < args.length; index++) { 
			findConcordance += args[index];
		}
		
		System.out.println( operation.printCharPosition(findConcordance) );
	}
}