package session2;

import java.io.*;

public class ReadQuestionFile {
	private static BufferedReader input;
	/**
	 * @Method countNoOfLinesInFile(String path)
	 * count no of lines in file
	 * @param String , file path is entered
	 * @return Integer , number of line
	 **/
	public static int countNoOfLinesInFile(String path) throws IOException {
		input = new BufferedReader(new FileReader(new File(path)));
		
		int line_count = 0;
		while ((input.readLine()) != null) {
			line_count++;
		}

		input.close();
		return line_count;
	}

}
