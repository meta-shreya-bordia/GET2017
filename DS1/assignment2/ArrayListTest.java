package assignment2;

import org.junit.*;

public class ArrayListTest {
	IList<Double> double_list; 
	IList<String> string_list;
	
	@Before
	public void setUp(){
		double_list = new MyArrayList<Double>();
		string_list = new MyArrayList<String>(2);
	}

	@Test(expected = NullPointerException.class   )
	public void addNull(){
		double_list.add(10.01);
		double_list.addAll(null);
		Assert.assertEquals(1, double_list.size());
	}
	
	@Test(expected = NullPointerException.class)
	public void addNullList() {
		IList<Double> data = null;
		double_list.addAll(data);
		Assert.assertEquals(1, double_list.size());
	}
	
	@Test
	public void addOneElement(){
		double_list.add(10.01);

		IList<Double> data = new MyArrayList<Double>();
		data.add(11.01);
		
		double_list.addAll(data);
		Assert.assertEquals(2, double_list.size());
		Assert.assertEquals(11.01, double_list.get(1), 0.1);
	}
	
	@Test
	public void addToList(){
		IList<Double> data = new MyArrayList<Double>();
		//data.add(null);
		data.add(11.01);
		
		double_list.addAll(data);
		Assert.assertEquals(1, double_list.size());
		//Assert.assertEquals(null, double_list.get(1));
		Assert.assertEquals(11.01, double_list.get(0), 0.1);		
	}
}
