package assignment2;

import java.util.*;

public class Counselling {
	Controller controller = new Controller();
	Scanner input = new Scanner(System.in);;
	
	public static void main(String[] args){
		Controller controller = new Controller();
		Counselling counsellor = new Counselling();
		
		MyQueue<Integer> candidates = controller.setRankWiseCalling(counsellor.getNumberOfCandidates());
		controller.setCollegeByRank( counsellor.getCollegeDetails( counsellor.getNumberOfColleges() ));
		
		
		while(){
			getRankWiseCalling();
		}
		
		controller.getCollegeRanks();
		controller.displayCollegeList();
		controller.getCandidateRank();
		controller.getCandidateCollegeList();
		controller.getUnassignedCandidates();
	}
	
	public int getNumberOfCandidates(){
		System.out.println("Enter total number of candidates appearing for couselling:");
		int numberOfCandidates = 0;
		
		while( (numberOfCandidates = input.nextInt())<=0 ){
			System.out.println("Number of candidates cannot be null or negative");
		}
		
		return numberOfCandidates;
	}
	
	public int getNumberOfColleges(){
		System.out.println("Enter total number of colleges appearing for couselling:");
		int numberOfColleges = 0;
		
		while( (numberOfColleges = input.nextInt())<=0 ){
			System.out.println("Number of colleges cannot be null or negative");
		}
		
		return numberOfColleges;
	}
	
	public IList<College> getCollegeDetails( int numberOfColleges ){
		IList<College> colleges = new MyArrayList<College>();
		
		
		for(int clg =0; clg< numberOfColleges; clg++){
			int rank, total_seats;
			String collegeName;
			
			System.out.println("\n\nEnter College details: \n"
							+  "College Rank:");
			while((rank = input.nextInt() ) <= 0 & rank >= numberOfColleges){
				System.out.println("Invalid rank");
			}
			
			System.out.println("College Name:");
			collegeName = input.nextLine();
			
			System.out.println("Total seats for counselling:");
			while((total_seats = input.nextInt() )<=0){
				System.out.println("Cannot be negative");
			}
			
			colleges.add(controller.setCollege(rank, collegeName, total_seats));
		}
		
		return colleges;
	}
}
