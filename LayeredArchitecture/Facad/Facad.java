package LayeredArchitecture.Facad;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import LayeredArchitecture.Dao.Dao;
import LayeredArchitecture.Model.Model;
/**
 * The Class Facad.
 */
public class Facad {
	
	/** The dao object. */
	Dao daoObject=new Dao();
	
	/** The email. */
	String email;
	
	/**
	 * Validate email.
	 *
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean validateEmail() throws SQLException
	{
		Input in=new Input();
		this.email=in.getEmail();
		if(daoObject.checkCredentials(email))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Show product details.
	 *
	 * @return the array list of products
	 * @throws SQLException the SQL exception
	 */
	public ArrayList<ProductItem> showProductDetails() throws SQLException
	{
		ArrayList<ProductItem> productList= daoObject.showProductQuery();
		return productList;
		
	}
	
	/**
	 * Add the item  to cart.
	 *
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean addToCart() throws SQLException
	{
		Input in=new Input();
		int id=in.getProductId();
		if(daoObject.isProductExist(id) && !(daoObject.isCartProductExist(id,email)))
		{
		int qty=in.getProductQty();
		Model modelObject=new Model();
		if(daoObject.addToCartQuery(modelObject.getCartInstance(id, email, qty)))
		return true;
		else
		{
			return false;
		}
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Show cart details.
	 *
	 * @return the hash map
	 * @throws SQLException the SQL exception
	 */
	public HashMap<ArrayList<ProductItem>,ArrayList<cartItem>>  showCartDetails() throws SQLException
	{
		HashMap<ArrayList<ProductItem>,ArrayList<cartItem>> cartList= daoObject.showCartQuery(email);
		return cartList;
		
	}
	
	/**
	 * Update cart.
	 *
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean updateCart() throws SQLException
	{
		Input in=new Input();
		int id=in.getProductId();
		if(daoObject.isProductExist(id) && daoObject.isCartProductExist(id,email))
		{
		int qty=in.getProductQty();
		if (daoObject.updateCartQuery(id,qty,email))
		{
			return true;
		}
		else
		{
			return false;
		}
		}
		else
		{
			return false;
		}
		
	}
	
	/**
	 * Delete from cart.
	 *
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean deleteFromCart() throws SQLException
	{
		Input in=new Input();
		int id=in.getProductId();
		if(daoObject.deleteFromCartQuery(id,email))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	/**
	 * Show cart bill.
	 *
	 * @return the int bill
	 * @throws SQLException the SQL exception
	 */
	public int showCartBill() throws SQLException
	{
		return daoObject.showCartBillQuery(email);
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail()
	{
		return email;
	}

}
