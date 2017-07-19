package assignment2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Compile all test cases and execute with runner class
 * Holds all test classes to run
 * Methods are executed as per listing in class
 * and class executed with listing in TestSuite class
 * */

@RunWith(Suite.class)
@Suite.SuiteClasses({
	   QuaterPyramidTestPositives.class,
	   QuaterPyramidTestNegatives.class
	})
public class QuaterPyramidTestSuite {

}
