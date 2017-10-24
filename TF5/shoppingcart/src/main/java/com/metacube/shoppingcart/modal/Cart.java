package com.metacube.shoppingcart.modal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart implements Serializable {
	
	@Id
	@Column(name = "id")
	//auto generated
	@GeneratedValue(strategy= GenerationType.AUTO)
    private int Id;
	
	@Column(name = "userId")
	private int userId;
	
	@Column(name = "productId")
	private int productId;
	
	public Cart(int userId, int productId) {
		super();
		this.userId = userId;
		this.productId = productId;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	

	
}

