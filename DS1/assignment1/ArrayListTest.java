package assignment1;

import org.junit.*;

public class ArrayListTest {
	IList<Double> double_list; 
	IList<String> string_list;
	
	@Before
	public void setUp(){
		double_list = new MyArrayList<Double>();
		string_list = new MyArrayList<String>(2);
	}
	
	@Test
	public void testInitialSize(){
		Assert.assertEquals(0, double_list.size());
	}
	
	@Test
	public void testResizingList(){
		for(int element = 0; element < 15; element++){
			double_list.add(element+ 0.05);
			string_list.add(element, "Hi"+element);
		}
		
		Assert.assertEquals(15, double_list.size());
		Assert.assertEquals(15, string_list.size());
		
		for(int position = 14; position >= 0; position--){
			double_list.remove(position);		//delete by position
			string_list.remove("Hi"+position);	//delete by element data
		}
		
		Assert.assertEquals(0, double_list.size());
		Assert.assertEquals(0, string_list.size());
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
		string_list.add(0, "Hi");
		
		double[] expected = {100.01};
		Assert.assertEquals((double) expected[0], double_list.get(0), 0.01);
		Assert.assertEquals("Hi", string_list.get(0));
	}
	
	//when element does not exist in list
	@Test
	public void removeInvalidElement(){
		Assert.assertFalse( double_list.remove(100.00) );
		Assert.assertFalse( string_list.remove(null) );
	}
	
	//when element exists in list
	@Test
	public void removeByElement(){
		double_list.add(100.00);
		Assert.assertTrue( double_list.remove(100.00) );
		
		string_list.add("");
		Assert.assertTrue( string_list.remove("") );
	}
	
	@Test
	public void removeNullElement(){                     
		Assert.assertFalse( double_list.remove(null) );
		
		Assert.assertFalse( string_list.remove(null) );
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void removeInvalidPosition(){
		for(int data = 0; data < 10; data++){
			double_list.add((double)data);
		}
		Assert.assertEquals(null, (double)double_list.remove(100));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void removeUnderflow(){
		double_list.remove(-1);
	}
	
	@Test
	public void clearAllElements(){
		for(int i=0; i<15; i++){
			double_list.add((double)i);
			string_list.add("Test"+i);
		}
		
		Assert.assertEquals(15, double_list.size());
		Assert.assertEquals(15, string_list.size());
		
		double_list.clear();
		Assert.assertEquals(0, double_list.size());		
		
		double_list.clear();
		Assert.assertEquals(0, double_list.size());

	}
	
	@Test
	public void sortEmptyList(){
		double_list.sort();
	}
	
	@Test
	public void sortOneElement(){
		double_list.add(10.01);
		double_list.sort();
		
		Assert.assertEquals(10.01, double_list.get(0), 0.1);
		
		string_list.add(null);
		string_list.sort();
		
		Assert.assertEquals(null, string_list.get(0));
	}
	
	@Test
	public void sortList(){
		for(int data = 4; data >= 0; data--){
			double_list.add((double)data);
		}
		
		double_list.sort();
		for(int check =0; check< 5; check++){
			Assert.assertEquals((double)check, double_list.get(check), 0.1);
		}

		string_list.add("aA");
		string_list.add("a");
		string_list.add("A");
		string_list.add("");
		
		string_list.sort();
		
		Assert.assertEquals("", string_list.get(0));
		Assert.assertEquals("A", string_list.get(1));
		Assert.assertEquals("a", string_list.get(2));
		Assert.assertEquals("aA", string_list.get(3));
	}
	
	@Test
	public void reverseEmptyList(){
		double_list.reverse();
	}
	
	@Test
	public void reverseOneElement(){
		double_list.add(10.091);
		double_list.reverse();
		
		Assert.assertEquals(10.091, double_list.get(0), 0.1);
	}
	
	@Test
	public void reverseList(){
		for(int data = 4; data >= 0; data--){
			double_list.add((double)data);
		}
		
		double_list.reverse();
		for(int check =0; check< 5; check++){
			Assert.assertEquals((double)check, double_list.get(check), 0.1);
		}
		
		string_list.add("aA");
		string_list.add("A");
		string_list.add("a");
		string_list.add("");
		
		string_list.reverse();
		
		Assert.assertEquals("", string_list.get(0));
		Assert.assertEquals("a", string_list.get(1));
		Assert.assertEquals("A", string_list.get(2));
		Assert.assertEquals("aA", string_list.get(3));
	}
}
