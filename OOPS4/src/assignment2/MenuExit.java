package assignment2;

public class MenuExit implements Action{
	@Override
	public void performAction(int operator) {
		if(operator == 5)
			System.exit(0);
	}
}
