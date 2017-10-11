package com.metacube.shoppingcart.service;

import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Cart;

public interface CartService {
	Status addProductToCart(Cart cart);

}
