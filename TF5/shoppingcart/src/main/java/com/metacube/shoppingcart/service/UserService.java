package com.metacube.shoppingcart.service;

import com.metacube.shoppingcart.dto.UserDto;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Product;
import com.metacube.shoppingcart.modal.User;

public interface UserService {

	UserDto getUserByName(String name);
	
}
