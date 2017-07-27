package session2;

import java.io.*;

public class WriteToFile {
	/**
	 * @Method printReportA(String filename, Questions[] question_object)
	 * print ReportA (analysis report of single choice question) according to user input
	 * @param Question_objects
	 * @return void
	 */
	public static void printReportA(String filename, Questions[] question_object) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filename)));
		
		for (Questions ques:  question_object) {
			if (Participation.compareStrings("Single Select", ques.question_type)) {
				int total = 0;

				System.out.println(ques.question_text + ques.question_type + ques.options);
				writer.write(ques.question_text + ques.question_type + ques.options + System.getProperty("line.separator"));
				for (int i : ques.single_choice_options.values()) {
					total += i;
				}
				
				for (String name : ques.single_choice_options.keySet()) {
					float value = ((ques.single_choice_options.get(name).intValue() * 100) / (float) total);
					System.out.println(name + " : " + value + "%");
					writer.write(name + " : " + value + "%" + System.getProperty("line.separator"));
				}
			}
		}
		writer.close();
	}
	
	/**
	 * @Method printReportB(int no_of_users) 
	 * print ReportB (all user's recorded survey responses )
	 * @param Question
	 *            objects
	 * @return void
	 * */
	public static void printReportB(String filename, int no_of_users) throws IOException{
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filename), true));
		
		for (int i = 1; i <= no_of_users; i++) {
			String participant = "Participant " + i;
			System.out.println(participant+ Participation.all_participant_answers.get(participant));
			writer.write("," + Participation.all_participant_answers.get("Participant "+i));
		}
		writer.close();
	}
}