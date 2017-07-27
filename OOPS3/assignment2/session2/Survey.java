package session2;

import java.io.*;
import java.util.*;

/**@Class	Survey
 * reads questions from a text file and prompts user input for each input
 * writes participant answers to file
 * */
public class Survey {
	private static String file_path = "question.txt";
	static String reportA 	= "ReportA.txt";
	static String reportB	= "ReportB.txt";
	
	public static void main(String[] args){
		try {
			int lines_count = ReadQuestionFile.countNoOfLinesInFile(file_path);
			int no_of_users=0;

			Scanner scan_input = new Scanner(System.in);
			
			System.out.println("Enter no of participant in Survey:");
			no_of_users = scan_input.nextInt();
			
			if (no_of_users < 1) {
				scan_input.close();
				throw new IllegalArgumentException("Invalid no of users entered");
			}
			
			Questions[] question_object = Questions.createQuestionObject(lines_count);
			
			Questions.initializeQuestionsParameters(file_path, question_object);
			Participation.storeUserAnswers(no_of_users, question_object);
			WriteToFile.printReportA(reportA, question_object);
			WriteToFile.printReportB(reportB, no_of_users);
			
			Sorting.sortQuestionsFromText(question_object);
			
			scan_input.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
