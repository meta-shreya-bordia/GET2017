package assignment1;

import java.awt.Button;

/** @Class	Buttons
* user defined class that extends the awt Button class
* defines its own methods for default button size
* button position
* and button action
**/
public class Buttons extends Button{
	protected int height, width;
	
	public Buttons() {
		height =100;
		width = 100;
	}
	
	/**@Method Buttons: constructor
	 * Define height and width of what a button should have
	 * */
	public Buttons(int height,int width){
		this.height = height;
		this.width = width;
	}
	
	/**@Method	setButton(position_x, position_y)
	 * set Button position onto screen
	 * */
	public void setButton(int position) {
		
	}
	
	/**@Method	enableButton
	 * set visibility of a button: whether button is available or not
	 * */
	public void enableButton() {
		
	}
	
	/**@Method	getLabelOnButton()
	 * find operator label name on button
	 * */
	public String getLabelOnButton() {
		
	}
}
