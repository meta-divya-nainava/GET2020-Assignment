package LayeredArchitecture.Model;

import LayeredArchitecture.Facad.ProductItem;
import LayeredArchitecture.Facad.cartItem;

/**
 * The Class Model.
 */
public class Model {
	
	/**
	 * Gets the product instance.
	 *
	 * @param id the id
	 * @param type the type
	 * @param name the name
	 * @param qty the quantity
	 * @param price the price
	 * @return the product instance
	 */
	public ProductItem getProductInstance(int id,String type,String name, int qty, int price)
	{
		return new ProductItem(id,type,name,qty,price);
	}
	
	/**
	 * Gets the cart instance.
	 *
	 * @param id the id
	 * @param email the email
	 * @param qty the quantity
	 * @return the cart instance
	 */
	public cartItem getCartInstance(int id,String email, int qty)
	{
		return new cartItem(id,email,qty);
	}

}
