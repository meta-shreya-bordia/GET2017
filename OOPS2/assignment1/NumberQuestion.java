package assignment;

public class NumberQuestion extends Question{
	public void setChoice() {}
	
	public boolean isValidInput(String choice) {
		if(! "Number".equals(this.type))
			return false;
		
		return true;
	}
}
