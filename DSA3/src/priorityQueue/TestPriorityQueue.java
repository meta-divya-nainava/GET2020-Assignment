package priorityQueue;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestPriorityQueue {
	@Test
	public void testPriorityQueue()
	{
		PriorityQueue priorityQueue=new PriorityQueueImplementation(4);
		try {
		priorityQueue.enQueue(new Job("job1",3));
		priorityQueue.enQueue(new Job("job2",5));
		priorityQueue.enQueue(new Job("job3",1));
		priorityQueue.enQueue(new Job("job4",2));
		assertEquals("job3", priorityQueue.peek().getJobName());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void testOverflowWithHigherPriorityElement()
	{
		PriorityQueue priorityQueue=new PriorityQueueImplementation(4);
		try {
		priorityQueue.enQueue(new Job("job1",3));
		priorityQueue.enQueue(new Job("job2",5));
		priorityQueue.enQueue(new Job("job3",1));
		priorityQueue.enQueue(new Job("job4",2));
		priorityQueue.enQueue(new Job("job5",0));
		assertEquals("job5", priorityQueue.peek().getJobName());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void testPriorityQueueDequeue()
	{
		PriorityQueue priorityQueue=new PriorityQueueImplementation(4);
		try {
		priorityQueue.enQueue(new Job("job1",3));
		priorityQueue.enQueue(new Job("job2",5));
		priorityQueue.enQueue(new Job("job3",1));
		priorityQueue.enQueue(new Job("job4",2));
		priorityQueue.deQueue();
		assertEquals("job4", priorityQueue.peek().getJobName());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void testQueueUnderFlow()
	{
		PriorityQueue priorityQueue=new PriorityQueueImplementation(4);
		try {
			priorityQueue.deQueue();

		}
		catch (Exception e) {
			assertEquals("Queue Underflow", e.getMessage());
		}
	}
	@Test
	public void testQueueOverflow()
	{
		PriorityQueue priorityQueue=new PriorityQueueImplementation(4);
		try {
		priorityQueue.enQueue(new Job("job1",3));
		priorityQueue.enQueue(new Job("job2",5));
		priorityQueue.enQueue(new Job("job3",1));
		priorityQueue.enQueue(new Job("job4",2));
		priorityQueue.enQueue(new Job("job5",6));
		}
		catch (Exception e) {
			assertEquals("Queue Overflow", e.getMessage());
		}
	}
	@Test
	public void testDequeueAndEnqueue()
	{
		PriorityQueue priorityQueue=new PriorityQueueImplementation(4);
		try {
		priorityQueue.enQueue(new Job("job1",3));
		priorityQueue.enQueue(new Job("job2",5));
		priorityQueue.enQueue(new Job("job3",1));
		priorityQueue.enQueue(new Job("job4",2));
		priorityQueue.deQueue();
		priorityQueue.deQueue();
		priorityQueue.enQueue(new Job("job5",0));
		assertEquals("job5", priorityQueue.peek().getJobName());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
