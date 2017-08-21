package assignment1;

import org.junit.*;

public class ArrayListTest {
	IList<Double> double_list; 
	
	@Before
	public void setUp(){
		double_list = new MyArrayList<Double>();
	}
	
	@Test
	public void testInitialSize(){
		Assert.assertEquals(0, double_list.size());
	}
	
	@Test
	public void testResizingList(){
		IList<String> string_list = new MyArrayList<String>(2);
		for(int element = 0; element < 15; element++){
			double_list.add(element+ 0.05);
			string_list.add(element, "Hi"+element);
		}
		
		Assert.assertEquals(15, double_list.size());
		Assert.assertEquals(15, string_list.size());
		
		for(int position = 14; position >= 0; position--){
			double_list.remove(position);	//delete by position
			string_list.remove("Hi"+position);
		}
		
		Assert.assertEquals(0, string_list.size());
		Assert.assertEquals(0, double_list.size());
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testInvalidPositionForAddElement(){
		double_list.add(1000, 90.345);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testNegativePositionForAddElement(){
		double_list.add(-1, 90.345);
	}
	
	@Test
	public void testAddOneElement(){
		double_list.add(0, 100.01);
		
		double[] expected = {100.01};
		Assert.assertEquals((double) expected[0], double_list.get(0), 0.01);
	}
	
	@Test
	public void removeByElement(){
		
	}
	
	@Test
	public void removeByPosition(){
		
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void removeUnderflow(){
		double_list.remove(-1);
	}
	
}
