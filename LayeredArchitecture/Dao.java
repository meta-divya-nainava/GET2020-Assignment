package LayeredArchitecture;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * The Class Dao.
 */
public class Dao {
	
	/** The con. */
	private Connection con=null;
    
    /** The stm. */
    private Statement stm = null;
    
    /** The ps. */
    private PreparedStatement ps= null;
    
    /** The rs. */
    private ResultSet rs = null;
    
    /** The list. */
    ArrayList<String> list = new ArrayList<String>();
    
    /**
     * Check credentials.
     *
     * @param email the email
     * @return true, if successful
     * @throws SQLException the SQL exception
     */
    public   boolean checkCredentials(String email) throws SQLException 
    {try{
    	con=new SetConnection().connection();
    	String query="select * from user where email='"+email+"'";
    	stm = (Statement) con.createStatement();
    	rs=stm.executeQuery(query);
    	if(rs.next())
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}}
    finally
    {
    	stm.close();
    	con.close();
    	
    }
    	
    	
    }
    
    /**
     * Checks if is product exist.
     *
     * @param id the id
     * @return true, if is product exist
     * @throws SQLException the SQL exception
     */
    public boolean isProductExist(int id) throws SQLException
    {
    	try{
    	Connection con=new SetConnection().connection();
    	String query="select productId from product where productId="+id+"";
    	stm = (Statement) con.createStatement();
    	rs=stm.executeQuery(query);
    	if(rs.next())
    	{
    		return true;
    	}
    	else
    	{
    		
    		return false;
    	}}
    	 finally
    	    {
    		 stm.close();
    	    	con.close();
    	    	
    	    }
    	
    	
    }
    
    /**
     * Checks if is cart product exist.
     *
     * @param id the id
     * @param email the email
     * @return true, if is cart product exist
     * @throws SQLException the SQL exception
     */
    public boolean isCartProductExist(int id,String email) throws SQLException
    {
    	try{
    	Connection con=new SetConnection().connection();
    	String query="select ProductId from cart where ProductId="+id+" and userEmail='"+email+"'";
    	stm = (Statement) con.createStatement();
    	rs=stm.executeQuery(query);
    	if(rs.next())
    	{
    		return true;
    	}
    	else
    	{
    		
    		return false;
    	}}
    	 finally
    	    {
    		 stm.close();
    	    	con.close();
    	    	
    	    }
    	
    	
    }
    
    /**
     * Show product details
     *
     * @return the array list of products
     * @throws SQLException the SQL exception
     */
    public ArrayList<ProductItem> showProductQuery() throws SQLException
    {
    	try{
    	ArrayList<ProductItem> productList=new ArrayList<ProductItem>();
    	Model modelObject=new Model();
    	Connection con=new SetConnection().connection();
    	String query="select * from product";
    	stm = (Statement) con.createStatement();
    	rs=stm.executeQuery(query);
    	while(rs.next())
    	{
    		productList.add(modelObject.getProductInstance(rs.getInt("ProductId"),rs.getString("productType"), rs.getString("productName"), rs.getInt("productQty"),  rs.getInt("productPrice")));
    		
    		
    	}
    	return productList;
    	}
    	finally{
    		stm.close();
    	con.close();}
    	
    }
    
    /**
     * Show cart details
     *
     * @param email the email
     * @return the hash map of productList and cart list
     * @throws SQLException the SQL exception
     */
    public HashMap<ArrayList<ProductItem>,ArrayList<cartItem>> showCartQuery(String email) throws SQLException
    {
    	try{
    	HashMap<ArrayList<ProductItem>,ArrayList<cartItem>> map=new HashMap();
    	ArrayList<ProductItem> productList=new ArrayList<ProductItem>();
    	ArrayList<cartItem> cartList=new ArrayList<cartItem>();
    	Model modelObject=new Model();
    	Connection con=new SetConnection().connection();
    	String query="select * from cart where userEmail='"+email+"'";
    	stm = (Statement) con.createStatement();
    	rs=stm.executeQuery(query);
    	ResultSet rs1;
    	while(rs.next())
    	{
    		cartList.add(modelObject.getCartInstance(rs.getInt("ProductId"),rs.getString("userEmail"),rs.getInt("productQty")));
    		String query1="select * from product where productId="+rs.getInt("ProductId")+"";
    		stm = (Statement) con.createStatement();
    		rs1=stm.executeQuery(query1);
    		rs1.next();
    		productList.add(modelObject.getProductInstance(rs1.getInt("ProductId"),rs1.getString("productType"), rs1.getString("productName"), rs1.getInt("productQty"),  rs1.getInt("productPrice")*rs.getInt("productQty")));
    		
    		
    	}
    	map.put(productList, cartList);
    	return map; 
    	}
    	finally
    	{
    		stm.close();
    	con.close();
    	}
    	
    	
    }
    
    /**
     * Adds the item to cart .
     *
     * @param object the cart object
     * @return true, if successful
     * @throws SQLException the SQL exception
     */
    public boolean addToCartQuery(cartItem object) throws SQLException
    {
    	try{
    	Connection con=new SetConnection().connection();
    	   String query="select productPrice,productQty from product where productId="+object.getProductId()+"";
       	   stm = (Statement) con.createStatement();
       	   rs=stm.executeQuery(query);
       	   rs.next();
       	   int price=rs.getInt(1);
       	   int qty=rs.getInt(2)-object.getCartQty();
       	   if(qty>0)
       	   {
    	   ps = con.prepareStatement("insert into cart(ProductId, userEmail, productQty, ProductPrice) values(?,?,?,?)");
    	   ps.setInt(1,object.getProductId());
    	   ps.setString(2,object.getEmail());
    	   ps.setInt(3, object.getCartQty());
    	   ps.setInt(4, object.getCartQty()*price);
    	   ps.executeUpdate();
    	   query="update product set productQty="+qty+" where productId="+object.getProductId()+"";
       	   stm = (Statement) con.createStatement();
       	   int result=stm.executeUpdate(query);
    	  
    	   return true;
       	   }
       	   else
       	   {
       		   return false;
       	   }}
    	finally
    	{
    		 ps.close();
      	   stm.close();
      	   con.close();
    	}
    	
    }
    
    /**
     * Update cart query.
     *
     * @param id the id
     * @param qty the quantity
     * @param email the email
     * @return true, if successful
     * @throws SQLException the SQL exception
     */
    public boolean updateCartQuery(int id,int qty,String email) throws SQLException
    {
    	try{
    	Connection con=new SetConnection().connection();
    	 String query1="select productPrice,productQty from product where productId="+id+"";
     	   stm = (Statement) con.createStatement();
     	   rs=stm.executeQuery(query1);
     	   rs.next();
     	   int price=rs.getInt(1);
     	   int pQty=rs.getInt(2)-qty;
     	   if(pQty>0)
     	   {
     	   String query="update cart set productQty="+qty+", productPrice="+price*qty+" where ProductId="+id+" and userEmail='"+email+"'";
     	   int result=stm.executeUpdate(query);
     	   query="update product set productQty="+pQty+" where productId="+id+"";
      	   stm = (Statement) con.createStatement();
      	   result=stm.executeUpdate(query);
     	  
     	   return true;
     	   }
     	   else
     	   {
     		   return false;
     	   }}
    	finally
    	{
    		stm.close();
    		 con.close();
    	}
    	
    }
    
    /**
     * Delete from cart query.
     *
     * @param id the id
     * @param email the email
     * @return true, if successful
     * @throws SQLException the SQL exception
     */
    public boolean deleteFromCartQuery(int id,String email) throws SQLException
    {
    	try{
    	Connection con=new SetConnection().connection();
    	 String query1="select productQty  from cart where productId="+id+" and userEmail='"+email+"'";
   	   	stm = (Statement) con.createStatement();
   	   	rs=stm.executeQuery(query1);
   	   	rs.next();
   	   	int qty=rs.getInt(1);
   	query1="select productQty  from product where productId="+id+"";
	   	stm = (Statement) con.createStatement();
	   	rs=stm.executeQuery(query1);
	   	rs.next();
	   	int Pqty=rs.getInt(1)+qty;
    	 
     query1="delete  from cart where productId="+id+" and userEmail='"+email+"'";
     	   stm = (Statement) con.createStatement();
     	   int resultDelete=stm.executeUpdate(query1);
     	   if(resultDelete!=0)
     	   {
     query1="update product set productQty="+Pqty+" where productId="+id+"";
     stm = (Statement) con.createStatement();
	   int result=stm.executeUpdate(query1);
	  
	   return true;
     	   }
     	   else
     	   {
     		   return false;
     	   }
    	
    	}
    	finally
    	{
    		stm.close();
    		 con.close();
    	}
    }
    
    /**
     * Show cart bill query.
     *
     * @param email the email
     * @return the int bill
     * @throws SQLException the SQL exception
     */
    public int showCartBillQuery(String email) throws SQLException
    {
    	try{
    	Connection con=new SetConnection().connection();
    	 String query1="select sum(productPrice) from cart where userEmail='"+email+"'";
     	  stm = (Statement) con.createStatement();
     	  rs=stm.executeQuery(query1);
     	  rs.next();
     	  int bill=rs.getInt(1);
     	 
     	  return bill;
    	}
    	finally
    	{
    		stm.close();
    		 con.close();
    	}
    	
    }

}
