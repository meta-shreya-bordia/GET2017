package assignment2;

import java.util.*;

public class Controller {
	IList<College> collegeList;
	MyQueue<Integer> candidateList;
	
	Controller(){
		
	}
	
	public Controller(int numberOfCandidates, int numberOfColleges){
		candidateList = new MyQueue<Integer>();
		collegeList	  = new MyArrayList<College>();
	}
	
	public MyQueue<Integer> setRankWiseCalling(int maxCandidatesToCouncil){
		for(int candidate=1; candidate<= maxCandidatesToCouncil; candidate++){
			candidateList.enqueue(candidate);
		}
		return this.candidateList;
	}
	
	public College setCollege(int rank, String collegeName, int totalSeats){
		return new College(rank, collegeName, totalSeats);
	}
	
	public void setCollegeByRank(IList<College> colleges){
		for(int i =0; i<colleges.size(); i++){
			this.collegeList.add(colleges.get(i).getCollegeRank(), colleges.get(i));
		}
	}
	
	public IList<College> getCollegeByRank(){
		return this.collegeList;
	}
	
	public void getCandidateByRank(){
		
	}
	
	public List<College> getCandidateCollegeList(){
		
	}
	
	public void getUnassignedCandidates(){
		
	}
}
