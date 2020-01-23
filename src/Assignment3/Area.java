/*
 * @author Divya Nainava
 * @date 16-01-2020
 */
/*
 
* Design a class Area to calculate areas for different shapes. It should support following methods
Method to return area of a Triangle. Method will receive width and height as double and return computed value as double.
Method to return area of a Rectangle. Method will receive width and height as double and return computed value as double.
Method to return area of a Square. Method will receive width as double and return computed value as double.
Method to return area of a Circle. Method will receive radius as double and return computed value as double.

 */
package Assignment3;

import Assignment3.AreaLogic;
import Assignment3.AreaInput;

public class Area {
	public static void main(String args[])
	{
		AreaLogic logicObject=new AreaLogic();
		AreaInput input=new AreaInput();
		double width;
		double height;
		double radius;
		while(true)
		{
			System.out.println("***************");
			System.out.println("1.Calculate area of Triangle"+"\n"+"2.Calculate area of Rectangle"
					+"\n"+"3.Calculate area of Square"+"\n"
					+"4.Calculate area of circle"+"\n"+
					"0 Exit");
			switch(input.getChoice())
			{
				case 1: width=input.getWidth();
						height=input.getHeight();
						System.out.println(logicObject.triangleArea(width,height));
						break;	
				case 2: width=input.getWidth();
						height=input.getHeight();
						System.out.println(logicObject.rectangleArea(width,height));
						break;
				case 3: width=input.getWidth();
						System.out.println(logicObject.squareArea(width));
						break;
				case 4: radius=input.getRadius();
						System.out.println(logicObject.circleArea(radius));
						break;
				case 0: System.out.println("Thank you");
						return;
				default: System.out.println("Please enter valid choice");
						break;
			}
		}

	}

}
