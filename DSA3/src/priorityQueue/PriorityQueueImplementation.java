package priorityQueue;

import static org.junit.Assert.assertEquals;

public class PriorityQueueImplementation implements PriorityQueue
{
	private final int size;
	private Job[] priorityQueue;
	private int front;
	private int rear;
	
	public PriorityQueueImplementation(int size) {
		this.size = size;
		this.priorityQueue = new Job[this.size];
		this.front = -1;
		this.rear = -1;
	}
	@Override
	public void enQueue(Job job) throws Exception {
		if(this.isEmpty()){
			this.front = 0;
			this.rear = 0;
			priorityQueue[this.rear]=job;
		} 
		else
		{
			int pos= this.posOfJob(this.front, this.rear, job);
			this.rear=this.increment(this.rear);
			if(pos==-1 && this.isFull())
			{
				throw new Exception("Queue Overflow");
				
			}
			else if(pos==-1)
			{
				priorityQueue[this.rear]=job;
			}
			else
			{
				if(this.isFull())
				{
					this.shiftByOne(pos,(this.size-1));
				}
				else
				{
					this.shiftByOne(pos, this.rear);
				}
				priorityQueue[pos]=job;
				
			}
		}
		
	}
	
	public int getFront() {
		return this.front;
	}

	public int getRear() {
		return this.rear;
	}

	private int posOfJob(int left , int right,Job job)
	{
		int pos=-1;
		for(int i=left;i<=(right);i++)
		{
		
			if(priorityQueue[i].getPriority()>job.getPriority())
			{
				pos=i;
				break;
				 
			}
		}
		return pos;
		
	}
	private void shiftByOne(int left, int right)
	{
		for(int i=right;i>left;i--)
		{
			priorityQueue[i]=priorityQueue[i-1];
		}
		
	}

	@Override
	public Job deQueue() throws Exception {
		if(this.isEmpty()){
			 throw new Exception("Queue Underflow");
		}
		Job item = this.priorityQueue[this.front];
		this.front = increment(this.front);
		if(this.front == this.rear){
			this.front = -1;
			this.rear = -1;
		}
		return item;
	}

	@Override
	public Job peek() throws Exception {
			if(this.isEmpty()){
				throw new Exception("Queue Underflow");
			}
			return this.priorityQueue[this.front];
	}

	@Override
	public boolean isEmpty() {
		return (this.front == -1 && this.rear == -1);
	}

	@Override
	public boolean isFull() {
		return (increment(this.rear) == this.front || priorityQueue[this.size-1]!=null);
	}
	
	private int increment(int index){
		return (index + 1) % this.size;
	}
	@Override
	public Job[] getQueue() {
		return this.priorityQueue;
	}
	
	
}
