package com.metacube.shoppingcart.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ClassName  : Product
 * @author    : Vaishali Jain
 * Description: POJO class for product
 * 				provide mapping with the databse
 */  
@Entity
@Table(name="product")
public class Product {
	
	
	@Id
	@Column(name = "id")
	//auto generated
	@GeneratedValue(strategy= GenerationType.AUTO)
    private int Id;
    
   
	@Column(name="name")
    private String name;
    
  
	@Column(name="price")
    private double price;

  
    public int getId() {
        return Id;
    }

    public void setId(final int Id) {
        this.Id = Id;
    }

   
    public String getName() {
        return name;
    }

  
    public void setName(String name) {
        this.name = name;
    }

    
    public double getPrice() {
        return price;
    }

    
    public void setPrice(double price) {
        this.price = price;
    }

 
}
