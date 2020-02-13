/**
 * @author: Divya Nainava
 * @date: 12-01-2020
 */
package LayeredArchitecture.Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import LayeredArchitecture.Facad.Facad;
import LayeredArchitecture.Facad.ProductItem;
import LayeredArchitecture.Facad.cartItem;
import LayeredArchitecture.View.View;


/**
 * The Class Controller.
 */
public class Controller {
	
	/**
	 * various option functions
	 *
	 * @throws SQLException the SQL exception
	 */
	private void  viewData() throws SQLException
	{
		View viewObject = new View();
		Facad facadObject = new Facad();
		while (!(facadObject.validateEmail())) {
			System.out.println("Enter valid credentials.");
		}
		int choice;
		while (true) {
			choice = viewObject.viewDashboard();
			switch (choice) {
			case 1:
				ArrayList<ProductItem> productList = facadObject
						.showProductDetails();
				for (ProductItem itr : productList) {
					System.out.println(itr.getProductId() + "\t"
							+ itr.getProductType() + "\t"
							+ itr.getProductName() + "\t" + itr.getProductQty()
							+ "\t" + itr.getProductPrice());
				}
				break;
			case 2:
				if (facadObject.addToCart()) {
					System.out.println("successfully added");
				} else {
					System.out.println("enter valid product id or product is already in cart please update");
				}
				break;
			case 3:
				if (facadObject.deleteFromCart()) {
					System.out.println("successfully delete");
				} else {
					System.out
							.println("enter valid product id or cart is already empty");
				}
				break;
			case 4:
				System.out.println(facadObject.showCartBill());
				break;
			case 5:
				HashMap<ArrayList<ProductItem>, ArrayList<cartItem>> cartList = facadObject
						.showCartDetails();
				ArrayList<cartItem> cartItemList = null;
				ArrayList<ProductItem> productItemList = null;

				for (ArrayList itr : cartList.keySet()) {
					cartItemList = cartList.get(itr);
					productItemList = itr;

				}
				if (cartItemList.size() != 0) {
					for (int itr = 0; itr < productItemList.size(); itr++) {
						System.out.println(productItemList.get(itr)
								.getProductId()
								+ "\t"
								+ productItemList.get(itr).getProductType()
								+ "\t"
								+ productItemList.get(itr).getProductName()
								+ "\t"
								+ cartItemList.get(itr).getCartQty()
								+ "\t"
								+ productItemList.get(itr).getProductPrice());
					}
				} else {
					System.out.println("cart is empty");
				}
				break;
			case 6:
				if (facadObject.updateCart()) {
					System.err.println("successfully update");
				} else {
					System.out
							.println("enter valid product id or given quantity is out of stock");
				}
				break;
			case 0:
				return;
			}
		}
	}
		

	/**
	 * The main method.
	 * @throws SQLException the SQL exception
	 */
	public static void main(String args[]){
		Controller object=new Controller();
		try {
			object.viewData();
		} catch (SQLException e) {
			System.out.println("Error");
		}
		
	}
		

}
