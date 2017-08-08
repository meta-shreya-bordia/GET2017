package assignment1;

import java.awt.TextField;

public class Display {
	/**
	 * clear display TextField
	 * */
	public void clear() {
		
	}
	
	/**
	 * when result is calculated, display onto TextField value computed
	 * Insert result onto text field and layout displays it onto screen
	 * */
	public void displayOutput(Number result) {

		// output = result
		//pass output to layout
		
		Layout layout = new Layout();
		TextField output = new TextField(result.toString());		
	}
}
