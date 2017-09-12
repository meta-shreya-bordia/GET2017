package assignment2;

import java.util.Scanner;

public class CacheResults {

	public static void main(String[] args){
		UniqueCharacterCount charCounter = new UniqueCharacterCount();
		
		Scanner input = new Scanner(System.in);
		
		while(true){
			System.out.println("Enter string to find its unique chars: ");
			
			String inputString = input.next();
			
			//int count = charCounter.computeResult(inputString);
			System.out.println("Here is your unique char finder:");
			int count = 0;
			if(( count = charCounter.getCachedResult(inputString)) != 0){
				System.out.println("Found your string "+ inputString + " in our cached results:"
						+ "\nUnique char count is: "+ count);
			}else{
				count = charCounter.getUniqueCharacterCount(inputString);
				System.out.println("New String encountered!"+ inputString
						+ "\nLong delay but we have computed its unique chars to be:"+count);
				
				charCounter.setCacheResult(inputString, count);
			}
		}
	}
}
