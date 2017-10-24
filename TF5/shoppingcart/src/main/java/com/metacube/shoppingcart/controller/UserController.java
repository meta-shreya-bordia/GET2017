package com.metacube.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metacube.shoppingcart.dto.ProductDto;
import com.metacube.shoppingcart.dto.UserDto;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.facade.CartFacade;
import com.metacube.shoppingcart.facade.UserFacade;
import com.metacube.shoppingcart.modal.Cart;
import com.metacube.shoppingcart.modal.Product;
import com.metacube.shoppingcart.modal.User;



@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserFacade userFacade;
	@Autowired
	CartFacade cartFacade;
	
	//request to display product on the basis of product id 
		@RequestMapping(value="/get/{userName}" , produces="application/json")
		public @ResponseBody UserDto  getUserBy(@PathVariable("userName") String userName) {
			return userFacade.getUserByName(userName);
		}
		
		//request to add product
		@RequestMapping(value="/add")
		public @ResponseBody Status addProduct(@RequestBody Cart cart) {
			return cartFacade.addProductToCart(cart);
		}
		
	
}
