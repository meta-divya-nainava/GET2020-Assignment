package Assignment3;


public class AreaLogic {
	public double triangleArea(double width, double height)
	{
		/*
		 * method for calculating area of triangle
		 * @param area value of calculated area
		 * @param width contains width
		 * @param height contains height
		 * @return double area
		 */
		double area=(1.0/2)*width*height;
		return area;
	}
	public double rectangleArea(double width, double height)
	{

		/*
		 * method for calculating area of rectangle
		 * @param area value of calculated area
		 * @param width contains width
		 * @param height contains height
		 * @return double area
		 */
		double area=width*height;
		return area;
	}
	public double squareArea(double width)
	{

		/*
		 * method for calculating area of square
		 * @param area value of calculated area
		 * @param width contains width
		 * @return double area
		 */
		double area=width*width;
		return area;
	}
	public double circleArea(double radius)
	{

		/*
		 * method for calculating area of circle
		 * @param area value of calculated area
		 * @param radius contains radius
		 * @return double area
		 */
		double area=(22.0/7)*radius*radius;// 22.0/7 is value of pie
		return area;
	}

}
