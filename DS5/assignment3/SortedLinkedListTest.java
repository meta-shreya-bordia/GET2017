package assignment3;

import org.junit.*;

public class SortedLinkedListTest {
		SortedLinkedList<Double> doubleList;
		SortedLinkedList<String> stringList;
		
		@Before
		public void setup(){
			doubleList = new SortedLinkedList<Double>();
			stringList=new SortedLinkedList<String>();
		}
		
		//method to test add element function
		@Test
		public void testAdd(){
			doubleList.add(20.2);
			doubleList.add(10.1);
			Assert.assertEquals(10.1, (double)doubleList.get(0), 0.1);
			Assert.assertEquals(20.2, (double)doubleList.get(1), 0.1);
			
			stringList.add("abc");
			stringList.add("acb");
			Assert.assertEquals("abc",stringList.get(0));
			Assert.assertEquals("acb",stringList.get(1));
		}
		
		//method to test if element passed is null
		@Test
		public void testAddIfElementNull(){
			Assert.assertFalse(doubleList.add(null));
			Assert.assertFalse(stringList.add(null));
		}
		
		//method to test get element by index method
		@Test
		public void testGetElementByIndex(){
			doubleList.add(20.2);
			doubleList.add(10.1);
			Assert.assertEquals(20.2, (double)doubleList.get(1), 0.1);
			
			stringList.add("abc");
			stringList.add("xyz");
			Assert.assertEquals("abc",stringList.get(0));
		}
		
		//method to test if invalid index is passed
		@Test
		public void testGetElementByInvalidIndex(){
			doubleList.add(20.2);
			doubleList.add(10.1);
			Assert.assertEquals(null,doubleList.get(13));
			
			stringList.add("abc");
			stringList.add("xyz");
			Assert.assertEquals(null, stringList.get(13));
		}
		
		//method to test if list is empty
		@Test
		public void testEmptySorted(){
			Assert.assertEquals(null, doubleList.get(0));
			Assert.assertEquals(null, stringList.get(0));
		}
}

