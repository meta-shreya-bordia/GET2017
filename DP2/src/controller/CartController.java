package controller;

import java.util.*;
import facade.*;

/**@Class	CartController
 * maintain cart details 
 * Apply TO validations
 **/
public class CartController implements IBaseController{
	private static CartController cart_controller = null;
	private CartFacade user_cart;
	
	private CartController() {
		user_cart = new CartFacade();
	}
	
	public static CartController getInstance() {
		if(cart_controller == null) {
			synchronized (CartController.class) {
				if(cart_controller == null) {
					cart_controller = new CartController();
				}
			}
		}
		
		return cart_controller;
	}
	
	public Map getCart(){
		if(user_cart.getCart().size() <=0){
			displayMessage("Error: Empty cart. Add items to it?");
		}
		return user_cart.getCart();
	}
	
	public boolean validateItem(int product_code, int quantity) {
		//call UserInputValidations
		return UserInputValidation.getInstance().isValidSaleLineItem(product_code, quantity);
	}
	//then call facade checks
		
	public void addToCart(int product_code, int product_quantity) {
		//facade checks if valid product id
		//facade check if product exists in cart
		//add product to cart
		if(validateItem(product_code, product_quantity) &&
		   user_cart.addToCart(product_code, product_quantity) ){
			displayMessage("Product successfully added to cart");
		}else {
			displayMessage();
		}
		
	}
	
	public void deleteFromCart(int product_code) {
		//facade check if product exists in cart
		//then calls controller to delete item from cart
		if(validateItem(product_code, 1) ||
		   user_cart.deleteFromCart(product_code) ){
			displayMessage("Product deleted from cart. View Cart?");
		}else {
			displayMessage();
		}
	}
	
	public void updateCartItem(int product_code, int product_quantity) {
		//facade checks if item exists in cart and valid quantity
		//then calls controller to update item quantity
		if( validateItem(product_code, product_quantity) &&
			user_cart.updateCartItem(product_code, product_quantity) ){
			displayMessage("Product details updated.");
		}else {
			displayMessage();
		}
	}
	
	public double getBillTotal(){
		//check facade that cart is not empty
		//then get bill total
		return user_cart.getBillTotal();
	}
	
	public void displayMessage(){
		BaseController.getInstance().displayMessage("Error: Product id does not exist.");
	}
	
	public void displayMessage(String message) {
		BaseController.getInstance().displayMessage(message);
	}
}
