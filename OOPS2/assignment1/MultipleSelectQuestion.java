package assignment;

import java.util.HashSet;
import java.util.Set;

public class MultipleSelectQuestion extends Question{
	Set<String> options = new HashSet<String>();
	
	public void setChoice(){
		if("Multiple Select".equals(this.type) ) {
			String[] keys = this.choices.split("/");
			
			for(int i=0; i < keys.length; i++) {
				options.add(keys[i]);
			}
			
		}
	}
	
	public boolean isValidInput(String option) {
		String[] selected_option = option.split("/");
		
		for(int i=0; i< selected_option.length; i++) {
			if(! options.contains(selected_option[i]))
				return false;
		}
		
		return true;
	}
}
