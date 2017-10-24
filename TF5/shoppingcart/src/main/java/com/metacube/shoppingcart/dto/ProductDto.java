package com.metacube.shoppingcart.dto;

/**
 * ClassName  : ProductDto
 * @author    : Vaishali Jain
 * Description: DataTransferObject Of Product
 */
public class ProductDto {
	//describe product id
	private int id;
	//describe product name
	private String name;
	//describe product price
	private double price;
	
	//getter to get product id
	public int getId() {
		return id;
	}
	
	//getter to get product name
	public String getName() {
		return name;
	}
	
	//getter to get product price
	public double getPrice() {
		return price;
	}
	
	//setter to set product id
	public void setId(final int id) {
		this.id = id;
	}
	
	//setter to set product name
	public void setName(final String name) {
		this.name = name;
	}
	
	//setter to set product name
	public void setPrice(final double price) {
		this.price = price;
	}
	
}
