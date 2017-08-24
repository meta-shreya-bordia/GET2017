package dao;

import java.util.*;
import model.Product;

/**@Class	BaseDAO
 * abstracts lower level logic
 * product details could be stored either in database, files or in memory
 * only 1 object is created to access product list
 **/
public interface BaseDAO {
	//how to create object of BaseDAO in other package factory?
	/**
	 * called by facade
	 * create object of type: ?
	 * 1. productlist
	 * 2. cart
	 * 3. enum (error handling)
	 **/
	
	//public abstract List<Product> getProductList();
}
