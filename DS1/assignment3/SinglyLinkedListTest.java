package assignment3;

import org.junit.*;

public class SinglyLinkedListTest {
	SinglyLinkedList<Double> list1;
	SinglyLinkedList<String> list2;
	
	@Before
	public void setUp(){
		list1 = new SinglyLinkedList<Double>();
		list2 = new SinglyLinkedList<String>();
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddAtNegativePosition(){
		list1.add(-1, 10.2);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testAddAtOutOfRangePosition(){
		list1.add(10, 10.2);
	}
	
	@Test
	public void testAppend(){
		list1.add(0, 1.1);
		list1.add(1, 2.2);
		list1.add(2, 3.3);
		list1.add(3, 4.4);
		
		Assert.assertEquals(4.4, list1.get(3));
	}
	
	@Test
	public void testAddAtBegining(){
		list2.add(0, "1");
		list2.add(0, "2");
		list2.add(0, "3");
		list2.add(0, "4");
		
		Assert.assertEquals("4", list2.get(0));
	}
	
	@Test
	public void testAddAtPosition(){
		list1.add(0, 1.1);
		list1.add(0, 2.2);
		list1.add(1, 3.3);
		list1.add(0, 4.4);
		
		Assert.assertEquals(3.3, (double)list1.get(2), 0.1);
	}
	
	@Test
	public void testRemoveFromFirst(){
		list1.add(0, 1.1);
		list1.add(0, 2.2);
		list1.add(0, 3.3);
		list1.add(0, 4.4);
		
		Assert.assertEquals(4.4, (double)list1.get(0), 0.1);
		Assert.assertTrue(list1.remove(0));
		Assert.assertEquals(3.3, (double)list1.get(0), 0.1);
	}
	
	@Test
	public void testRemoveFromLast(){
		list1.add(0, 1.1);
		list1.add(0, 2.2);
		list1.add(0, 3.3);
		list1.add(0, 4.4);
		
		Assert.assertEquals(1.1, (double)list1.get(3), 0.1);
		Assert.assertTrue(list1.remove(3));
	}
	
	@Test
	public void testRemoveFromPosition(){
		list1.add(0, 1.1);
		list1.add(0, 2.2);
		list1.add(0, 3.3);
		list1.add(0, 4.4);
		
		Assert.assertEquals(2.2, (double)list1.get(2), 0.1);
		Assert.assertTrue(list1.remove(2));
	}
	
	@Test
	public void testRemoveByElement(){
		list2.add(0, "1");
		list2.add(0, "2");
		list2.add(0, "3");
		list2.add(0, "4");
		
		Assert.assertTrue(list2.remove("4"));
	}
	
	@Test
	public void testRemoveWhenElementNotInList(){
		list2.add(0, "1");
		list2.add(0, "2");
		list2.add(0, "3");
		list2.add(0, "4");
		
		Assert.assertFalse(list2.remove("6"));
	}
	
	@Test
	public void testReverseNullList(){
		list1.reverse();
	}
	
	@Test
	public void testReverseOneElementList(){
		list1.add(0, 1.1);
		list1.reverse();
		
		Assert.assertEquals(1.1, (double)list1.get(0), 0.1);
	}
	
	@Test
	public void testReverseList(){
		list2.add(0, "4");
		list2.add(0, "3");
		list2.add(0, "2");
		list2.add(0, "1");
		
		list2.reverse();
		
		Assert.assertEquals("4", list2.get(0));
	}
	
	@Test
	public void testEmptylist(){
		list1.sort();
	}
	
	@Test
	public void testSortOneElementList(){
		list1.add(0, 1.2);
		list1.sort();
		
		Assert.assertEquals(1.2, (double)list1.get(0), 0.1);
	}
	
	@Test
	public void testSortList(){
		list2.add(0, "4");
		list2.add(0, "3");
		list2.add(0, "2");
		list2.add(0, "1");
		
		list2.sort();
		
		Assert.assertEquals("1", list2.get(0));
		Assert.assertEquals("2", list2.get(1));
		Assert.assertEquals("3", list2.get(2));
		Assert.assertEquals("4", list2.get(3));
	}
}
