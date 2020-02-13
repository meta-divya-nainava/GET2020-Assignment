package LayeredArchitecture.View;

import LayeredArchitecture.Facad.Input;

/**
 * The Class View.
 */
public class View {
	
	/** The in object of Input class */
	Input in=new Input();
	
	/**
	 * View dashboard.
	 * contains shopping option for user
	 *
	 * @return the int choice 
	 */
	public int viewDashboard()
	{
		System.out.println("Welcome to dashboard"+"\n"+"1.Show Products"
				+"\n"+"2.Add to cart"+"\n"
				+"3.delete from cart"+"\n"+
				"4.Show total cart bill "+"\n"
				+"5.Display cart items"+"\n"
				+"6.update cart"+"\n"+
				"7.update products"+"\n"+
				"0 Exit");
		return in.getChoice();
	
	}

}
