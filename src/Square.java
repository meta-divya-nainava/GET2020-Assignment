import java.util.Date;
import java.util.List;

public class Square implements Shape {
	private int sideOfSquare;
	private Point originOfShape;
	private Date timeStamp;

	public Square(Point originOfShape, List<Integer> dimensionOfSquare) throws Exception {
		/**
		 * Instantiates a new square.
		 * @param originOfShape the origin of shape
		 * @param dimensionOfSquare is a list containing the dimensions of square.
		 */
	
		if (dimensionOfSquare.size() == 0){
			throw new Exception ("Dimensions not given.");
		}

		this.sideOfSquare = dimensionOfSquare.get(0);
		this.originOfShape = originOfShape;
		this.timeStamp = new Date();
	}

	@Override
	public Point getOrigin() {
		// Method to return origin of the shape.
		
		return originOfShape;
	}

	@Override
	public shapeType getTypeOfShape() {
		// Method to return type of the shape.
		
		return shapeType.SQUARE;
	}

	@Override
	public float getArea() {
		// Method to return area of the shape.
		
		return sideOfSquare * sideOfSquare;
	}

	@Override
	public float getPerimeter() {
		// Method to return time stamp of the shape.
		
		return 4 * (sideOfSquare);
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

		if (point.getXCoordinate() >= originOfShape.getXCoordinate()
				&& point.getXCoordinate() <= originOfShape.getXCoordinate()
						+ sideOfSquare) {
			if (point.getYCoordinate() >= originOfShape.getYCoordinate()
					&& point.getYCoordinate() <= originOfShape.getYCoordinate()
							+ sideOfSquare) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Date getTimeStamp() {
		// Method to return time stamp of the shape.
		
		return timeStamp;
	}

	@Override
	public float getDistanceFromOriginOfScreen() {
		// Method to return distance from origin of the shape.
		
		return (float) Math.sqrt(Math.pow(originOfShape.getXCoordinate(), 2)
				+ Math.pow(originOfShape.getYCoordinate(), 2));
	}

}
