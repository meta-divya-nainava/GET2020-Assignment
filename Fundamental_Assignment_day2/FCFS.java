/*
 * @author: divya nainava
 * @date:14-01-2020
 */
/*Design a class JobScheduler to simulate FCFS (First Come First Serve) scheduling algorithm. 
FCFS means the process which arrives first, gets executed first. 

Assume that we are receiving a number of processes with their arrival time and burst time seconds in a two dimensional array as input.  For example:

[0][10]
[6][20]
[60][10]
[110][5]

Define methods to perform following operations: 

Calculate completion time for each process. 
Calculate waiting time for each process.
Calculate turn around time for each process.
Average waiting time of processes.
Maximum waiting time period for a process in queue.*/
package Fundamental_Assignment_day2;
import java.util.Scanner;
class JobScheduler
{
	/*
	 * this class contains following method
	 * 1.get_input()
	 * 2.completion_time()
	 * 3.turn_around_time()
	 * 4.waiting_time()
	 * 5.avg_time_waiting()
	 * 6.max.waiting_time()
	 */
	static int[][] arr;
	static int[] CompletionArr;
	static int[] TurnAroundArr;
	static int[] WaitingTimeArr;
	int size;
	public JobScheduler()
	{
		/*
		 * constructor to initialize array size.
		 */
		Scanner input=new Scanner(System.in);
		System.out.println("Enter number of processess");
		size=input.nextInt();
	    arr=new int[size][2];
	    CompletionArr=new int[size];
	    TurnAroundArr=new int[size];
	    WaitingTimeArr=new int[size];
	}
	public void GetInput()
	{
		/*
		 * @param arr collection of arrival time and burst time of process
		 */
		Scanner input=new Scanner(System.in);
		try
		{
		for(int i=0;i<size;i++)
        {
			System.out.println("Enter arrival time and burst time of process "+(i+1)+":");
        	for(int j=0; j<2;j++)
        	{
        		arr[i][j]=input.nextInt();
        	}
        }
		}
		catch(Exception e)
		{
			System.out.println("Enter valid number");
			return;
		}
	}
	public  void CompletionTime ()
	{
		/*
		 * method for calculating completion time of processes.
		 * @param complete_time contains last completion time
		 * @param complation_arr=collection of completion time
		 */
		CompletionArr[0]=arr[0][0]+arr[0][1];
		int CompleteTime=arr[0][1];
		for(int i=1;i<size;i++)
        {
			if(arr[i][0]<CompleteTime)
			{
				CompletionArr[i]=CompleteTime+arr[i][1];
				CompleteTime+=arr[i][1];
			}
			else
			{
				CompletionArr[i]=arr[i][0]+arr[i][1];
				CompleteTime=arr[i][0]+arr[i][1];
			}
        }
		System.out.println("Completion time of process:");
		for(int i=0;i<size;i++)
		{
			System.out.println("Process"+(i+1)+"\t"+CompletionArr[i]);
		}
		
	}
	public void TurnAroundTime()
	{
		/*
		 * method for calculating turn around time of processes.
		 * @param turn_around_arr=collection of turn around time
		 * @param arr collection of arrival time and burst time of process
		 * @param i used for iteration
		 */
		for(int i=0;i<size;i++)
		{
			TurnAroundArr[i]=CompletionArr[i]-arr[i][0];
		}
		System.out.println("Turn around time of process:");
		for(int i=0;i<size;i++)
		{
			System.out.println("Process"+(i+1)+"\t"+TurnAroundArr[i]);
		}
		
	}
	public void WaitingTime()
	{/*
		 * method for calculating turn around time of processes.
		 * @param waiting_arr=collection of waiting time of process
		 * @param arr collection of arrival time and burst time of process
		 * @param i used for iteration
		 */
		for(int i=0;i<size;i++)
		{
			WaitingTimeArr[i]=TurnAroundArr[i]-arr[i][1];
		}
		System.out.println("Waiting time of process:");
		for(int i=0;i<size;i++)
		{
			System.out.println("Process"+(i+1)+"\t"+WaitingTimeArr[i]);
		}
	}
	public void AvgWaitingTime()
	{
		/*
		 * method for calculating Average waiting time of processes.
		 * @param waiting_arr=collection of waiting time of process
		 * @param arr collection of arrival time and burst time of process
		 * @param i used for iteration
		 * @param average contains value for total average
		 */
		int average=0;
		for(int i=0;i<size;i++)
		{
			average+=WaitingTimeArr[i];
		}
		average=average/size;
		System.out.println("Average time of processs: "+average);
	}
	public void MaxWaitingTime()
	{
		/*
		 * method for calculating maximum waiting time of a process.
		 * @param waiting_arr=collection of waiting time of process
		 * @param arr collection of arrival time and burst time of process
		 * @param i used for iteration
		 * @param max contains maximum waiting time
		 */
		int max=0;
		for(int i=0;i<size;i++)
		{
			if(WaitingTimeArr[i]>max)
			{
				max=WaitingTimeArr[i];
			}
		}
		System.out.println("Maximum time of processs:"+max);
	}
}

public class FCFS {
	    public static void main(String[] args) 
	    { 
	    	Scanner input= new Scanner(System.in);
			JobScheduler object=new JobScheduler();
			while(true)
			{
				System.out.println("***************");
				System.out.println("1.Enter Arrival time and burst time of processes"+"\n"+"2, Display completion time of each process."
						+"\n"+"3.Display turn around time of each process."+"\n"
						+"4.Display waiting time of each process."+"\n"+
						"5.Display Average waiting time"+"\n"
						+"6.Display maximum waiting time"+"\n"+
						"0 Exit");
				System.out.println("***************");
				System.out.println("Enter your choice");
				int choice;
				try
				{
				choice= input.nextInt();
				switch(choice)
				{
					case 1:	object.GetInput();
							break;	
					case 2:	object.CompletionTime();
							break;
					case 3: object.TurnAroundTime();
							break;
					case 4: object.WaitingTime();
							break;
					case 5: object.AvgWaitingTime();
							break;
					case 6: object.MaxWaitingTime();
							break;
					case 0: System.out.println("Thank you");
							return;
					default: System.out.println("Please enter valid choice");
							break;
				}
				}
				catch(java.util.InputMismatchException e)
				{
					System.out.println("enter valid choice");
					
				}
			}

	    } 

}
