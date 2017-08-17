package DefaultNamespace;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;


//Class containing the test cases for checking class Converter.
public class ControllerTest {
	
	 // Positive Test Case for checking functionality of function convert.
	@Test
	public void positiveTestCase() {

		Controller controller = new Controller();
		Double expected = 87.77;
		Double actual = controller.convert(190);
		assertEquals(expected, actual,0.01);

	}

	 //Negative Test Case for checking functionality of function convert.
	@Test
	public void negativeTestCase() {

		Controller obj = new Controller();
		Double expected = 87.77;
		Double actual = obj.convert(-34);
		assertNotEquals(expected, actual);

	}

}
