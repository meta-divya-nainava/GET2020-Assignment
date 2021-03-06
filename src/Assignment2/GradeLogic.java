package Assignment2;
public class GradeLogic {
	public float average(float[] arr,int size)
	{
		/*
		 * method for calculating average of elements in arr
		 * @param arr contains elements.
		 * @param size contains size of value
		 * @param sum sum of all elements in arr
		 * @return float sum/size
		 */
		try
		{
		float sum=0;
		for(int itr=0; itr<size;itr++)
		{
			sum+=arr[itr];
		}
		return (sum/size);
		}
		catch(ArithmeticException e)
		{
			System.out.println("Airthmetic exception");
			return 0;
		}
	}
	public float maximumGrade(float[] arr,int size)
	{
		/*
		 * method for calculating maximum element  in arr
		 * @param arr contains elements.
		 * @param size contains size of value
		 * @param max maximum value
		 * @return float max
		 */
		float max=0;
		for(int itr=0; itr<size;itr++)
		{
			if(arr[itr]>=max)
			{
				max=arr[itr];
			}
		}
		return max;
	}
	public float minimumGrade(float[] arr,int size)
	{

		/*
		 * method for calculating minimum element  in arr
		 * @param arr contains elements.
		 * @param size contains size of value
		 * @param min minimum value
		 * @return float min
		 */
		float min=100;
		if(size==0)
		{
			min=0;
		}
		for(int itr=0; itr<size;itr++)
		{
			if(arr[itr]<=min)
			{
				min=arr[itr];
			}
		}
		return min;
	}
	
	
	public float percentagePassed(float[] arr,int size)
	{

		/*
		 * method for calculating percentage of passed students
		 * @param arr contains elements.
		 * @param size contains size of value
		 * @param count value of passed students
		 * @return float percentage
		 */
		try
		{
		int count=0;
		float percentage;
		for(int itr=0; itr<size;itr++)
		{
			if(arr[itr]>=40)
			{
				count++;
			}
		}
	    percentage=(float)((count*100)/size);
		return percentage;
		}
		catch(ArithmeticException e )
		{
			System.out.println("Airthmetic Exception");
			return 0;
		}
	}

}
