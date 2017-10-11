package com.metacube.shoppingcart.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.metacube.shoppingcart.dao.product.ProductDao;
import com.metacube.shoppingcart.dao.user.UserDao;
import com.metacube.shoppingcart.dto.UserDto;
import com.metacube.shoppingcart.modal.Product;
import com.metacube.shoppingcart.modal.User;
import com.metacube.shoppingcart.service.UserService;

@Service("userService")
@Transactional
public class DefaultUserService implements UserService {
	

	@Resource(name = "hibernateUserDao")
	UserDao userDao;
	
	public DefaultUserService() {
		
	}
	
	@Override
	public UserDto getUserByName(String name) {
		// TODO Auto-generated method stub
		return userDao.findOne(name);
	}

}
