package facade;

import java.util.*;
import dao.*;
import model.*;

public class CartFacade {
	private CartDAO your_cart;
	private ProductFacade product_list;
	
	public CartFacade() {
		your_cart 	 = new CartDAO();
		product_list = ProductFacade.getInstance();
	}
	
	public boolean isCartEmpty() {
		return (your_cart == null || your_cart.getCart() == null || your_cart.getCart().size() <= 0);
	}
	
	public Map getCart() {
		if(isCartEmpty()){
			return null;
		}
		
		return your_cart.getCart();
	}
	
	public double getBillTotal(){
		return isCartEmpty() ? -1 : your_cart.getBillTotal();
	}
		
	public boolean addToCart(int product_code, int quantity){
		if(your_cart == null || your_cart.getCart() == null || !product_list.checkValidProductCode(product_code) ){
			return false;
		}
		
		your_cart.addToCart(new SaleLineItem(product_list.getProduct(product_code), quantity));
		return true;
	}
	
	public boolean deleteFromCart(int product_code){
		if(isCartEmpty()  ||  !getCart().containsKey(product_code) ){
			return false;
		}
		
		your_cart.deleteSaleItem(product_code);
		return true;
	}
	
	public boolean updateCartItem(int product_code, int quantity){
		if( isCartEmpty() ||
		    !product_list.checkValidProductCode(product_code) ||
		    your_cart.getItemInCart(product_code) == null ){
			return false;
		}
		
		your_cart.addToCart(new SaleLineItem(product_list.getProduct(product_code), quantity));
		return true;
	}
}
