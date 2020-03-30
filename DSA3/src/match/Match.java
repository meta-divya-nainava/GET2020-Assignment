package match;

import java.util.ArrayList;
import java.util.List;

public class Match {
	private int noOfBallsToPlay;
	private Bowler[] bowlers;
	PriorityQueue bowlerQueue;
	public Match(int noOfBallsToPlay,Bowler[] bowlers) throws Exception
	{
		this.noOfBallsToPlay=noOfBallsToPlay;
		bowlerQueue=new PriorityQueueImplementation(bowlers.length);
		for(Bowler bowler:bowlers)
		{
			if (bowler == null) {
				throw new Exception("Null bowler found!");
			}
			bowlerQueue.enQueue(bowler);
		}
		
	}
	public List<String> planStrategy() throws Exception 
	{
		List<String> orderOfBowler=new ArrayList<>();
		for(int i=0;i<this.noOfBallsToPlay;i++)
		{
			Bowler bowler=bowlerQueue.deQueue();
			if(bowler.getNoOfBallLeft()<0)
			{
				throw new Exception("Not enough bowlers left");
			}
			bowlerQueue.enQueue(new Bowler(bowler.getBowlerName(),(bowler.getNoOfBallLeft()-1),bowler.getOrder()));
			orderOfBowler.add(bowler.getBowlerName());
		}
		return orderOfBowler;
	}

}
