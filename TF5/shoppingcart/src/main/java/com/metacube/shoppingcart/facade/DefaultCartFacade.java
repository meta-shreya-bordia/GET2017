package com.metacube.shoppingcart.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Cart;
import com.metacube.shoppingcart.service.CartService;


@Component("cartFacade")
public class DefaultCartFacade  implements CartFacade {
	
	@Autowired
	CartService cartService;

	@Override
	public Status addProductToCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartService.addProductToCart(cart);
	}

}
