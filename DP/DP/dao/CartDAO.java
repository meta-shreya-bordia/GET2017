package dao;

import java.util.*;

//only dao can access model classes, files and DB
import model.*;

public class CartDAO implements BaseDAO{
	//map of all items in cart
	private Map<Integer, SaleLineItem> invoice = new HashMap<Integer, SaleLineItem>();

	public Map<Integer, SaleLineItem> getCart() {
		return invoice;
	}
		
	//facade checks if element exists in cart map
	//then calls to get all SaleLineItem details
	public SaleLineItem getItemInCart(int product_code) {
		return invoice.get(product_code);
	}

	// controller checks for valid quantity
	// facade checks for valid product id and that product does not already exist in map
	public void addToCart(SaleLineItem product) {
		invoice.put(product.getProductCode(), product);
	}

	// check by controller for valid quantity
	// if item exists in cart (checked by CartFacade) and passes appropriate object in map
	// then calls updateQuantity
	public void updateQuantity(SaleLineItem product, int new_quantity) {
		product.setProductQuantity(new_quantity);
		product.setTotalProductPrice();
		
		invoice.put(product.getProductCode(), product);
	}

	//CartFacade checks that product exists in cart
	//then calls particular product to be removed from cart
	public void deleteSaleItem(int product_code) {
		invoice.remove(product_code);
	}

	/**@Method	getBillTotal
	 * iterate over cart items and find total product bill
	 * @return	type = double, sum of all product_price * quantity
	 **/
	public double getBillTotal() {
		double order_total = 0;
		for (Map.Entry<Integer, SaleLineItem> cart_item : invoice.entrySet()) {
			order_total += cart_item.getValue().getProductPrice();
		}

		return order_total;
	}
}
