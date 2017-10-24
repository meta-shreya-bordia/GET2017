package com.metacube.shoppingcart.dto;

import com.metacube.shoppingcart.modal.User;

public class UserDto {
	private User user;
	private Double totalPrice;
	private int totalProduct;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getTotalProduct() {
		return totalProduct;
	}
	public void setTotalProduct(int totalProduct) {
		this.totalProduct = totalProduct;
	}
	

}
