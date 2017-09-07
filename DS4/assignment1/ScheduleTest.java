package assignment1;

import org.junit.*;

public class ScheduleTest {
	PriorityQueue printer;
	
	@Before
	public void setUp(){
		printer = new PriorityQueue();
	}
	
	@Test
	public void testJobEntryIntoQueue(){
		printer.enqueue(new Job(4, 10, "Chair of department", "ImportantDocument"));
		Assert.assertEquals(1, printer.size() );
	}
	
	@Test
	public void testPrintSinglePriorityQueue(){
		Job addJob = new Job(4, 10, "Chair of department", "ImportantDocument");
		printer.enqueue(addJob);
		Assert.assertEquals(1, printer.size() );
		
		Assert.assertEquals(addJob, printer.printQueue()[0]);
	}
	
	@Test
	public void testForNewHigherPriorityJobAdd(){
		Job addJob = new Job(1, 10, "Undergraduate", "Assignment");
		Job higherPriority = new Job(4, 10, "Chair of department", "ImportantDocument");

		printer.enqueue(addJob);		
		printer.enqueue(higherPriority);
		
		Job[] actual = printer.printQueue();
		
		Assert.assertEquals(higherPriority, actual[0]);
		Assert.assertEquals(addJob, actual[1]);
	}
	
	@Test
	public void testForNewLowerPriorityJobAdd(){
		Job lowerPriority = new Job(1, 10, "Undergraduate", "Assignment");
		Job higherPriority = new Job(4,11, "Chair of department", "ImportantDocument");

		printer.enqueue(higherPriority);
		printer.enqueue(lowerPriority);

		Job[] actual = printer.printQueue();
		
		Assert.assertEquals(higherPriority, actual[0]);		
		Assert.assertEquals(lowerPriority,  actual[1]);
	}
	
	@Test
	public void testForSamePriorityInQueue(){
		Job addJob = new Job(1, 10, "Undergraduate", "Assignment");
		Job samePriority = new Job(1,11, "Undergraduate", "File");

		printer.enqueue(addJob);
		printer.enqueue(samePriority);

		Job[] actual = printer.printQueue();
		
		Assert.assertEquals(addJob, actual[0]);		
		Assert.assertEquals(samePriority,  actual[1]);
	}
}
