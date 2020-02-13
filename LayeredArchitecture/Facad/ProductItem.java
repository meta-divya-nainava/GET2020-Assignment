package LayeredArchitecture.Facad;
/**
 * The Class ProductItem.
 */
public class ProductItem {
	
	/** The product id. */
	private int productId;
	
	/** The product type. */
	private String productType;
	
	/** The product name. */
	private String productName;
	
	/** The product qty. */
	private int productQty;
	
	/** The product price. */
	private int productPrice;
	
	/**
	 * Instantiates a new product item.
	 *
	 * @param id the id
	 * @param type the type
	 * @param name the name
	 * @param qty the qty
	 * @param price the price
	 */
	public ProductItem(int id,String type,String name,int qty, int price)
	{
		this.productId=id;
		this.productName=name;
		this.productPrice=price;
		this.productType=type;
		this.productQty=qty;
	}
	
	/**
	 * Gets the product type.
	 *
	 * @return the product type
	 */
	//Getter methods
	public String getProductType()
	{
		return productType;
	}
	
	/**
	 * Gets the product name.
	 *
	 * @return the product name
	 */
	public String getProductName()
	{
		return productName;
	}
	
	/**
	 * Gets the product quantity.
	 *
	 * @return the product qty
	 */
	public int getProductQty()
	{
		return productQty;
	}
	
	/**
	 * Gets the product price.
	 *
	 * @return the product price
	 */
	public int  getProductPrice()
	{
		return productPrice;
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
