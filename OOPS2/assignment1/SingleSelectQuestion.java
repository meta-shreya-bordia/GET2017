package assignment;

import java.util.HashMap;
import java.util.Map;

public class SingleSelectQuestion extends Question{
	protected Map<String, Integer> options = new HashMap<String, Integer>();
	
	public SingleSelectQuestion() {
		if("Single Select".equals(this.type) ) {
			String[] keys = this.choices.split("/");
			
			for(int i=0; i < keys.length; i++) {
				options.put( keys[i], 0 );
			}
		}
	}
	
	public boolean isValidInput(String selected_option) {
		if(options.containsKey(selected_option))
			return true;
		
		return false;
	}
	
	public void updateCount(String selected_option) {
		options.put(selected_option, options.get(selected_option)+1);
	}
	
	public Map viewCount() {
		return options;
	}
}
