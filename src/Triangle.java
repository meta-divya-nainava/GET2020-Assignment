import java.util.Date;
import java.util.List;

public class Triangle implements Shape {

	 
	int baseOfTriangle;
	int secondSideOfTriangle;
	int thirdSideOfTriangle;
	int heightOfTriangle;
	Point originOfShape;
	Date timeStamp;

	public Triangle(Point originOfShape, List<Integer> dimensionOfTriangle) throws Exception {
		/**
		 * Instantiates a new triangle.
		 * @param originOfShape the origin of shape
		 * @param dimensionOfTriangle is a list containing the dimensions of triangle
		 */
		
		if (dimensionOfTriangle.size() == 0){
			throw new Exception ("Dimensions not given.");
		}

		this.timeStamp = new Date();
		this.baseOfTriangle = dimensionOfTriangle.get(0);
		this.secondSideOfTriangle = dimensionOfTriangle.get(1);
		this.thirdSideOfTriangle = dimensionOfTriangle.get(2);
		this.heightOfTriangle = dimensionOfTriangle.get(3);
		this.originOfShape = originOfShape;
	}

 	@Override
	public shapeType getTypeOfShape() {
 		// Method to return type of the shape.
		
 		return shapeType.TRIANGLE;
	}

 	@Override
	public float getArea() {
		// Calculation of area using heron's formula and return it.
		
 		float semiPerimeter = getPerimeter() / 2;
		return (float) Math.sqrt(semiPerimeter
				* (semiPerimeter - baseOfTriangle)
				* (semiPerimeter - secondSideOfTriangle)
				* (semiPerimeter - thirdSideOfTriangle));
	}

 	@Override
	public float getPerimeter() {
 		// Method to return perimeter of the shape.
 		
 		return (baseOfTriangle + secondSideOfTriangle + thirdSideOfTriangle);
	}
 	private float getSubArea(Point p1, Point p2, Point p3)
 	{
 		return ((p1.getXCoordinate()*(p2.getYCoordinate()-p3.getYCoordinate()))+(p1.getXCoordinate()*(p3.getYCoordinate()-p1.getYCoordinate()))
 				+(p3.getXCoordinate()*(p1.getYCoordinate()-p2.getYCoordinate())));
 	}

 	@Override
	public boolean isPointEnclosed(Point point) throws Exception {
		/* Method to check if a point is enclosed in a shape.
		 * @param point specifies the x and y coordinate.
		 * @return true if point lies within the shape and false otherwise.
		 */
 		if (point==null){
 			throw new Exception ("Point not valid.");
 		}
 		Point vertex1=originOfShape;
 		Point vertex2=new Point(originOfShape.getXCoordinate(),(originOfShape.getYCoordinate()+baseOfTriangle));
 		Point vertex3=new Point((originOfShape.getXCoordinate()/2),(originOfShape.getYCoordinate()+heightOfTriangle));
 		float totalSubArea=getSubArea(point,vertex1,vertex2)+getSubArea(point,vertex1,vertex3)+getSubArea(point,vertex2,vertex3);
 		if(getArea()==totalSubArea)
 		{
 			return true;
 		}
 		return false;
	}

 	@Override
	public Point getOrigin() {
 		// Method to return distance from origin of the shape.
		
 		return originOfShape;
	}
 
	@Override
	public Date getTimeStamp() {
		// Method to return timestamp of the shape.
		
		return timeStamp;
	}

 	@Override
	public float getDistanceFromOriginOfScreen() {
 		// Method to return distance from origin of the shape.
 		
		return (float) Math.sqrt(Math.pow(originOfShape.getXCoordinate(), 2)
				+ Math.pow(originOfShape.getYCoordinate(), 2));
	}

}
