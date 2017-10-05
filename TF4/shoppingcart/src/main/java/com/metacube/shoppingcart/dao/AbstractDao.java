package com.metacube.shoppingcart.dao;

import java.io.Serializable;

import com.metacube.shoppingcart.enums.Status;



public interface AbstractDao<T, ID extends Serializable> {
	
	
	
	
	
	
	
	Iterable<T> findAll();
	T findOne(ID primaryKey);
	/**
	 * method to delete product on the basis of id
	 * @param primaryKey
	 * @return
	 */
	Status delete(ID primaryKey);
	
	/**
	 * method to update the product
	 * @param entity
	 * @param primaryKey
	 * @return
	 */
	<S extends T>Status edit(S entity,ID primaryKey);
	/**
	 * Declaration of method to save the product
	 * @param entity
	 * @return
	 */
	<S extends T> Status save(S entity);
	
	
	
	
}
