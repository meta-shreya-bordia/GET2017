package assignment2;

/**@Class	ActionableMenuItem extends MenuItem implements Action
 * triggers the action to be performed when an option has been selected by the user
 * calls approriate overriden method
 * */
public class ActionableMenuItem extends MenuItem implements Action{
	private Action action;
	
	public ActionableMenuItem( Action action_to_perform) {
		this.action = action_to_perform;
	}
	
	@Override
	public void performAction(int operator) {
		this.action.performAction(operator);
	}
	
	public void triggerAction(int operator) {
		this.action.performAction(operator);  
	}
}
