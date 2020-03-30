package priorityQueue;
/**
 * 
 * @author Divya
 *
 */
public class Job {
	private String jobName;
	private int priority;
	/**
	 * 
	 * @param jobName
	 * @param priority
	 */
	public Job(String jobName, int priority)
	{
		this.jobName=jobName;
		this.priority=priority;
	}
	/**
	 * 
	 * @return jobName
	 */
	public String getJobName() {
		return jobName;
	}
	/**'
	 * 
	 * @return priority
	 */
	public int getPriority() {
		return priority;
	}
}
