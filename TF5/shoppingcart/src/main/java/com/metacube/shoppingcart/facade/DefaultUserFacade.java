package com.metacube.shoppingcart.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.shoppingcart.dto.UserDto;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Product;
import com.metacube.shoppingcart.modal.User;
import com.metacube.shoppingcart.service.UserService;

@Component("userFacade")
public class DefaultUserFacade  implements UserFacade  {
	
		@Autowired
		UserService userService;
		
		//default constructor
		public DefaultUserFacade() {
			
		}
		
		public void setUserService(final UserService userService)
		{
			this.userService = userService;
		}

		public UserService getUserService()
		{
			return userService;
		}
		
		//paremeterize constructor
		public DefaultUserFacade(UserService userService) {
			this.userService = userService;
		}
		
		//calls product service get by id method
		@Override
		public UserDto getUserByName(String name) {
			// TODO Auto-generated method stub
			return userService.getUserByName(name);
		}	
		
}
