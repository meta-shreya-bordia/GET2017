package com.metacube.shoppingcart.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.metacube.shoppingcart.dao.cart.CartDao;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Cart;


@Service("cartService")
@Transactional
public class DefaultCartService implements CartService{
	
	@Resource(name = "hibernateCartDao")
	CartDao cartDao;
	
	public DefaultCartService(){
		
	}

	@Override
	public Status addProductToCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartDao.addToCart(cart);
	}

}
