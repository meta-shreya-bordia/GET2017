package assignment;

import java.io.*;
import java.util.Scanner;

public class Survey {
	public static void readQuestions() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("question.txt")));
			String[] question = new String[5];
			
			int q_id =0;
			String line;
			while((line = reader.readLine()) != null) {
				question[q_id++] = line;
			}
			
			Question[] ques = new Question[q_id];
			for(int i=0; i< q_id; i++) {
				System.out.println(question[i]);
				ques[i] = new Question(question[i]);
				
				System.out.println("Ques object: "+ ques[i].text + " "+ ques[i].type+" "+ ques[i].choices);
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readUserInput() {
		Scanner input = new Scanner(System.in);
		for(int q=0; q<5; q++) {
			
		}
	}
	
	public static void main(String[] args) {
		readQuestions();
		
		for(int participant = 0; participant < 3; participant++) {
			readUserInput();
		}
	}
}
