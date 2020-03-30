package match;

import static org.junit.Assert.assertEquals;

public class PriorityQueueImplementation implements PriorityQueue
{
	private final int size;
	private Bowler[] bowlerQueue;
	private int front;
	private int rear;
	
	public PriorityQueueImplementation(int size) {
		this.size = size;
		this.bowlerQueue = new Bowler[this.size];
		this.front = -1;
		this.rear = -1;
	}
	@Override
	public void enQueue(Bowler job) throws Exception {
		if(this.isEmpty()){
			this.front = 0;
			this.rear = 0;
			bowlerQueue[this.rear]=job;
		} 
		else
		{
			int pos= this.posOfJob(this.front, this.rear, job);
			this.rear=this.increment(this.rear);
			 if(pos==-1)
			{
				bowlerQueue[this.rear]=job;
			}
			else
			{
				if(this.isFull())
				{
					this.shiftByOne(this.front,(this.size-1));
				}
				else
				{
					this.shiftByOne(this.front, this.rear);
				}
				bowlerQueue[pos]=job;
				
			}
		}
		
	}
	

	private int posOfJob(int left , int right,Bowler job)
	{
		int pos=-1;
		for(int i=left;i<=(right);i++)
		{
			if(bowlerQueue[i].getNoOfBallLeft()==job.getNoOfBallLeft())
				{
					if(bowlerQueue[i].getOrder()>job.getOrder())
					{
						pos=i;
						break;
						
					}
				}
			else if((bowlerQueue[i].getNoOfBallLeft()<job.getNoOfBallLeft()))
			{
				pos=i;
				break;
				
				 
			}
			else
			{
				pos=-1;
			}
		}
		return pos;
		
	}
	private void shiftByOne(int left, int right)
	{
		for(int i=right;i>left;i--)
		{
			bowlerQueue[i]=bowlerQueue[i-1];
		}
		
	}
	private void shiftByOneLeft(int left, int right)
	{
		for(int i=0;i<right;i++)
		{
			bowlerQueue[i]=bowlerQueue[i+1];
		}
		
	}

	@Override
	public Bowler deQueue() throws Exception {
		if(this.isEmpty()){
			 throw new Exception("Queue Underflow");
		}
		Bowler item = this.bowlerQueue[this.front];
		this.shiftByOneLeft(0,this.rear);
		this.rear--;
		
		if(this.front == this.rear){
			this.front = -1;
			this.rear = -1;
		}
		return item;
	}

	@Override
	public Bowler peek() throws Exception {
			if(this.isEmpty()){
				throw new Exception("Queue Underflow");
			}
			return this.bowlerQueue[this.front];
	}

	@Override
	public boolean isEmpty() {
		return (this.front == -1 && this.rear == -1);
	}

	@Override
	public boolean isFull() {
		return (increment(this.rear) == this.front || bowlerQueue[this.size-1]!=null);
	}
	
	private int increment(int index){
		return (index + 1) % this.size;
	}
	@Override
	public Bowler[] getQueue() {
		return this.bowlerQueue;
	}

	
	
}
