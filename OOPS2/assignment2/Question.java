package assignment;


public class Question {
	//change to protected, public for checking
	public String text, type, choices;
	
	public Question() {
		
	}
	
	public boolean isValidInput(String choice) {
		// used to call subclass definitions
		return false;
	}
	
	public Question(String question){
		String[] value = {"", "", ""};
		value = question.split(",");
		
		this.text = value[0];
		this.type = value[1];
		
		if(value[2] != "")
			this.choices = value[2];
	}
	
	public void setValues() {
		Question set;
		switch(this.type) {
			case "Single Select":
				set  = new SingleSelectQuestion();
				break;
			case "Multiple Select":
				set = new MultipleSelectQuestion();
				break;
			case "Number":
				set = new NumberQuestion();
				break;
			case "Text":
				set = new TextQuestion();
				break;
		}
	}	
	
	public Question getValues(){
		return this;
	}
}
