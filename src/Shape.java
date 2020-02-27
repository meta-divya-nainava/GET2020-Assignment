/* @author Divya Nainava
 * @date 27-01-2020 
*/
import java.util.Date;

public interface Shape {
	//@return area Of Shape
	public float getArea();

	//@return perimeter Of Shape
	public float getPerimeter();

	//@return true if point lies within the shape, false otherwise.
	public boolean isPointEnclosed(Point point) throws Exception;

	//@return type Of Shape
	public shapeType getTypeOfShape();

	//@return coordinates of origin of shape.
	public Point getOrigin();

	//@return date and time of creation of shape.
	public Date getTimeStamp();

	//@return distance from origin.
	public float getDistanceFromOriginOfScreen();

	//enum of the types of shapes available.
	public enum shapeType {
		RECTANGLE, TRIANGLE, SQUARE, CIRCLE
	}
}
