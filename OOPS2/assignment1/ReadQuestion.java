package assignment1;

import java.io.*;
import java.util.*;
public class ReadQuestion {
	static int participant = 1;
	
	public static void main(String[] args){
		Map<Integer, Integer> rating = new HashMap<Integer, Integer>();
		rating.put(1,0);
		rating.put(2,0);
		rating.put(3,0);
		rating.put(4,0);
		rating.put(5,0);
		
		Scanner input;
		BufferedReader reader;
		BufferedWriter writer;
		
		try{
			input = new Scanner(System.in);
			reader = new BufferedReader(new FileReader(new File("question.txt")));
			writer = new BufferedWriter(new FileWriter(new File("answer.txt"), true));
			
			writer.write("Participant "+participant);
			
			System.out.println(reader.readLine());
			int rate = input.nextInt();
			//rating.put(rate, rating.get(rate)+1);
			writer.write(rate);
			
			System.out.println(reader.readLine());
			String area_of_improvement = input.nextLine();
			writer.write(area_of_improvement);
			
			System.out.println(reader.readLine());
			String feedback = input.nextLine();
			writer.write(feedback);
			
			reader = new BufferedReader(new FileReader(new File("answer.txt")));
			System.out.println(reader.readLine());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
