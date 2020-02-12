package LayeredArchitecture;
/**
 * The Class cartItem.
 */
public class cartItem {
	
	/** The product id. */
	private int productId;
	
	/** The email. */
	private String email;
	
	/** The product qty. */
	private int productQty;
	
	/** The product price. */
	private int productPrice;
	
	/**
	 * Instantiates a new cart item.
	 *
	 * @param id the product id
	 * @param email the email
	 * @param qty the product quantity
	 */
	public cartItem(int id,String email,int qty)
	{
		this.email=email;
		this.productId=id;
		this.productQty=qty;
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
	
	/**
	 * Gets the cart quantity.
	 *
	 * @return the cart qty
	 */
	public int getCartQty()
	{
		return productQty;
	}
	/**
	 * Gets the product id.
	 *
	 * @return the product id
	 */
	public int  getProductId()
	{
		return productId;
	}

}
