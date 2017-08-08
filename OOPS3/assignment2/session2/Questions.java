package session2;

import java.io.*;
import java.util.*;
public class Questions implements Comparable<Questions> {

	String question_text;
	String question_type;
	String options;
	
	Map<String,Integer> single_choice_options;
	Set<String> multiple_choice_options;
	
	public Questions() {
		this.question_text	=null;
		this.question_type	=null;
		this.options		=null;
	}
	
	/**
	 * @Constructor Questions()
	 * parameterized constructor initializing Question object data members
	 * @param String question_text,String question_type,String options
	 * */
	public Questions(String question_text,String question_type,String options) {
		this.question_text=question_text;
		this.question_type=question_type;
		this.options=options;
		
		if("Single Select".compareTo(question_type.trim())==0){
			single_choice_options=new HashMap<String,Integer>();
		}
		else if("Multi Select".compareTo(question_type.trim())==0){
			multiple_choice_options=new HashSet<String>();
		}
	}
	
	/**
	 * @Method  createQuestionObject(int noOfObjects)
	 * creating questions class object array  
	 * @param no_of_objects
	 * @return Questions[] , Questions class array 
	 * */
	public static Questions[] createQuestionObject(int noOfObjects){	
		return new Questions[noOfObjects];
	}
	
	/**
	 * @Method  initializeQuestionsParameters(String file_path,Questions[] question_object)
	 * initialize question objects
	 * @param file_path  and question_object array 
	 * @return void
	 * */
	public static void initializeQuestionsParameters(String file_path, Questions[] question_object) throws IOException {
		BufferedReader buffer_input = new BufferedReader(new FileReader(new File(file_path)));
		String question_line;
		int question_index = 0;
		
		while ((question_line = buffer_input.readLine()) != null) {
			String[] splited_field_values = question_line.trim().split(",");
			
			/*
			 * if splited_field_values > 2 then it is Single or Multi select type 
			 * else it will be  of Text or Number type
			 * */
			if (splited_field_values.length > 2) {
				question_object[question_index] = new Questions(splited_field_values[0], splited_field_values[1],splited_field_values[2]);
				
				String option_string=splited_field_values[2].trim().replace("(", "");
				option_string=option_string.replace(")","");
				
				String[] choice_options = option_string.trim().split("/");
				
				/*
				 * Single select choice initialization
				 */
				if ("Single Select".compareTo(splited_field_values[1].trim()) == 0) {
					for (int i = 0; i < choice_options.length; i++) {
						question_object[question_index].single_choice_options.put(choice_options[i], 0);
					}
				}
				
				/*
				 * Multiple select choice initialization
				 */
				else if ("Multi Select".compareTo(splited_field_values[1].trim()) == 0) {
					for (int i = 0; i < choice_options.length; i++) {
						question_object[question_index].multiple_choice_options.add(choice_options[i]);
					}
				}
				question_index++;
			
			}else {
				question_object[question_index++] = new Questions(splited_field_values[0], splited_field_values[1], null);
			}
		}
	}
	
	/**
	 * @Method  compareTo(Questions object)
	 * over ridden method of comparator interface 
	 * @param question object 
	 * @return integer ,returning zero, positive or negative value
	 * */
	public int compareTo(Questions object){
		return this.question_text.trim().compareTo(object.question_text.trim());
	}
}
