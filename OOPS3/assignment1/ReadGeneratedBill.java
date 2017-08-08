package assignment1;

import java.io.*;

public class ReadGeneratedBill {
	public void readGeneratedBill(String file_to_read){
		String[] bill = ReadFile.readFile(new File(file_to_read));
		
		for(String order: bill) {
			System.out.println(order);
		}
	}
}
