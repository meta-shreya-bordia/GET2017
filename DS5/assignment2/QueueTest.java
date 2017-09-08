package assignment2;

import java.util.*;
import org.junit.*;

public class QueueTest {
	Queue<Double> doublyQueue;
	Queue<String> stringQueue;
	
	@Before
	public void setUp(){
		doublyQueue = new Queue<Double>();
		stringQueue = new Queue<String>();
	}
	
	@Test(expected = NullPointerException.class)
	public void testAddNull(){
		doublyQueue =  null;
		Assert.assertTrue( doublyQueue.add(10.2) );
	}
	
	@Test(expected = NullPointerException.class)
	public void testAddNullElement(){
		Assert.assertTrue( doublyQueue.add(null) );
	}
	
	@Test
	public void testAddAddElement(){
		Assert.assertTrue( doublyQueue.add(10.1) );
	}
	
	@Test
	public void testAddMultiple(){
		Assert.assertTrue( doublyQueue.add(10.1) );
		Assert.assertTrue( doublyQueue.add(20.1) );
		Assert.assertTrue( doublyQueue.add(30.1) );
		
		Assert.assertEquals(3, doublyQueue.size());
		Assert.assertEquals(10.1, (double)doublyQueue.peek(), 0.1);	
	}
	
	@Test
	public void testOfferNullElement(){
		Assert.assertFalse( doublyQueue.offer(null) );
	}
	
	@Test
	public void testOfferElement(){
		Assert.assertTrue( doublyQueue.offer(10.1) );
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testGetElement(){		
		doublyQueue.element() ;
	}
	
	@Test
	public void testGetValidElement(){
		Assert.assertTrue( doublyQueue.add(10.1) );
		Assert.assertTrue( doublyQueue.add(20.1) );
		Assert.assertTrue( doublyQueue.add(30.1) );
		Assert.assertEquals(10.1, (double)doublyQueue.element(), 0.1 );
	}
	
	@Test
	public void testPeekEmptyQueue(){
		Assert.assertEquals(null, doublyQueue.peek());
	}
	
	@Test
	public void testPeekQueue(){
		Assert.assertTrue( doublyQueue.add(10.1) );
		Assert.assertTrue( doublyQueue.add(20.1) );
		Assert.assertTrue( doublyQueue.add(30.1) );

		Assert.assertEquals(10.1, (double)doublyQueue.peek(), 0.1 );
		
		Assert.assertTrue( stringQueue.add("a") );
		Assert.assertTrue( stringQueue.add("b") );
		Assert.assertTrue( stringQueue.add("c") );

		Assert.assertEquals("a", (String)stringQueue.peek() );
	}
	
	@Test
	public void testPollEmptyQueue(){
		Assert.assertEquals(null, doublyQueue.poll());
		Assert.assertEquals(null, stringQueue.poll());
	}
	
	@Test
	public void testPollQueue(){
		Assert.assertTrue( doublyQueue.add(10.1) );
		Assert.assertTrue( doublyQueue.add(20.1) );
		Assert.assertTrue( doublyQueue.add(30.1) );

		Assert.assertEquals(10.1, (double)doublyQueue.poll(), 0.1 );
		Assert.assertEquals(2, doublyQueue.size());
		
		Assert.assertTrue( stringQueue.add("a") );
		Assert.assertTrue( stringQueue.add("b") );
		Assert.assertTrue( stringQueue.add("c") );

		Assert.assertEquals("a", (String)stringQueue.poll() );
		Assert.assertEquals(2, stringQueue.size());
	}
	
	@Test
	public void testRemoveFromEmptyQueue(){
		Assert.assertEquals(null, doublyQueue.poll());
		Assert.assertEquals(null, stringQueue.poll());
	}
	
	@Test
	public void testRemoveFromQueue(){
		Assert.assertTrue( doublyQueue.add(10.1) );
		Assert.assertTrue( doublyQueue.add(20.1) );
		Assert.assertTrue( doublyQueue.add(30.1) );

		Assert.assertEquals(10.1, (double)doublyQueue.poll(), 0.1 );
		Assert.assertEquals(2, doublyQueue.size());

		Assert.assertTrue( stringQueue.add("a") );
		Assert.assertTrue( stringQueue.add("b") );
		Assert.assertTrue( stringQueue.add("c") );

		Assert.assertEquals("a", (String)stringQueue.remove() );
		Assert.assertEquals(2, stringQueue.size());
	}
	
	@Test
	public void testIsEmpty(){
		Assert.assertTrue(doublyQueue.isEmpty());
		Assert.assertTrue(stringQueue.isEmpty());
	}
	
	@Test
	public void testIsNotEmpty(){
		doublyQueue.add(10.1);
		Assert.assertFalse(doublyQueue.isEmpty());
		
		stringQueue.add("a");
		Assert.assertFalse(doublyQueue.isEmpty());
	}
	
	@Test
	public void testZeroSize(){
		Assert.assertTrue(doublyQueue.isEmpty());
	}
	
	@Test
	public void testValidSize(){
		doublyQueue.add(10.1);
		Assert.assertFalse(doublyQueue.isEmpty());
	}
}
