package com.metacube.shoppingcart.facade;

import com.metacube.shoppingcart.dto.ProductDto;
import com.metacube.shoppingcart.dto.UserDto;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Product;
import com.metacube.shoppingcart.modal.User;

public interface UserFacade {
	
	UserDto getUserByName(String name);

}