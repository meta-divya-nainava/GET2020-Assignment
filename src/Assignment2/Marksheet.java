/*
 * @author Divya Nainava
 * @date 16-01-2020
 */
/*
/*
 * Design a class Marksheet, which reads in grades of n no of students. Assume n as a positive integer and grades will be between 0 and 100 both inclusive. It should support following methods 
Return average of all grades. 
Return maximum of all grades.
Return minimum of all grades.
Return percentage of students passed. (Assume grade >= 40 as Pass) 
 
Also write proper specification for each method created above. Assume that these methods may throw ArithmeticException.
Note : Use the floating-point values upto 2 decimal places.

 */

package Assignment2;

public class Marksheet {
	public static void main(String args[])
	{
	GradeLogic logicObject=new GradeLogic();
	GradeInput input=new GradeInput();
	int size=input.getSize();
	float[] arr=new float[size];
	while(true)
	{
		System.out.println("***************");
		System.out.println("1.Enter grade of students"+"\n"+"2.Calculate average"
				+"\n"+"3.Calculate maximum grade."+"\n"
				+"4.Calculate minimum grade"+"\n"+"5.Calculate percentage of student passed"+"\n"+
				"0 Exit");
		switch(input.getChoice())
		{
			case 1: arr=input.getArr(size,0);
					break;	
			case 2: System.out.printf("%.2f",logicObject.average(arr,size));
					System.out.println();
					break;
			case 3: System.out.printf("%.2f",logicObject.maximumGrade(arr,size));
					System.out.println();
					break;
			case 4: System.out.printf("%.2f",logicObject.minimumGrade(arr,size));
					System.out.println();
					break;
			case 5: System.out.printf("%.2f",logicObject.percentagePassed(arr,size));
					System.out.println();
					break;
			case 0: System.out.println("Thank you");
					return;
			default: System.out.println("Please enter valid choice");
					break;
		}
	}

}}

