package employee;

import java.io.*;
import java.util.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileReader {
	public static List<JSONObject> readFile(String filename) {
		JSONParser parser = new JSONParser();
		
		//return list of JSON object
		List<JSONObject> emp_details = new ArrayList<JSONObject>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
		
			String input = null;
			while( (input = reader.readLine()) != null) {
				emp_details.add((JSONObject) parser.parse(input));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return emp_details;
	}
	
	public static void writeFile(List<JSONObject> emp_details) {
		
	}
}
