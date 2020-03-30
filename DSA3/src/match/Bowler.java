package match;

public class Bowler {
	private String bowlerName;
	private int noOfBallLeft;
	private int order;
	/**
	 * constructor to initialize Bowler class
	 * @param bowlerName
	 * @param noOfBallLeft
	 * @param order
	 */
	public Bowler(String bowlerName, int noOfBallLeft,int order)
	{
		this.bowlerName=bowlerName;
		this.noOfBallLeft=noOfBallLeft;
		this.order=order;
	}
	/**
	 * 
	 * @return bowlerName
	 */
	public String getBowlerName() {
		return bowlerName;
	}
	/**
	 * 
	 * @return noOfBallLeft
	 */
	public int getNoOfBallLeft() {
		return noOfBallLeft;
	}
	/**
	 * 
	 * @return order
	 */
	public int getOrder()
	{
		return this.order;
	}
}
