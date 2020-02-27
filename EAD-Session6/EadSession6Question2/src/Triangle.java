public class Triangle {
	public double  triangleArea(double side1, double side2, double side3)
	{
		try
		{
		double s=(side1+side2+side3)/2;
		return (Math.sqrt((s*(s-side1)*(s-side2)*(s-side3))));
		}
		catch(Exception e)
		{
			System.out.println("please enter valid number");
			return 0;
			
		}
		
	}

}
