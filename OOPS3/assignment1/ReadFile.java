package assignment1;

import java.io.*;

public class ReadFile {
	private static BufferedReader reader = null;
	
	private static int getNumberOfFileLines(File product_file) {
		int number_of_lines=0;
		
		try {
			reader = new BufferedReader(new FileReader(product_file));
		
			while( reader.readLine() != null) {
				number_of_lines++;
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				reader.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		return number_of_lines;
	}
	
	public static String[] readFile(File product_file){
		String file_read ="";
		String[] lines = new String[getNumberOfFileLines(product_file)];
		
		try {
			reader = new BufferedReader(new FileReader(product_file));
			int p_no =0;
			
			while( (file_read = reader.readLine()) != null) {
				lines[p_no++] = new String(file_read);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(reader != null)
					reader.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		return lines;
	}
}
