package com.metacube.shoppingcart.facade;

import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Cart;

public interface CartFacade {
	Status addProductToCart(Cart cart);

}
