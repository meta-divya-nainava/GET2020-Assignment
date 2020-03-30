package priorityQueue;

public interface PriorityQueue {
	/**
	 * method to enqueue item in queue
	 * @param item
	 * @throws Exception
	 */
	public void enQueue(Job item) throws Exception;
	/**
	 * method to dequeue item from queue
	 * @return Job item
	 * @throws Exception
	 */
	public Job deQueue() throws Exception;
	/**
	 * method to return item at front of queue
	 * @return Job item
	 * @throws Exception
	 */
	public Job peek() throws Exception;
	/**
	 * method to check whether queue is empty or not
	 * @return true if empty else false
	 */
	public boolean isEmpty();
	/**
	 * method to check whether queue is full or not
	 * @return true if full else false
	 */
	public boolean isFull();
	/**
	 * method to get priority queue
	 * @return
	 */
	public Job[] getQueue();
}
