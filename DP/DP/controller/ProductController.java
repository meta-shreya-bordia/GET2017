package controller;

import dao.*;
import java.util.*;

/**
 * only get product list available in memory
 * future: update product list file
 * **/
public class ProductController implements IBaseController{
	private static ProductController product_controller = null;
	
	public static ProductController getInstance() {
		if(product_controller == null) {
			synchronized (ProductController.class) {
				if(product_controller == null) {
					product_controller = new ProductController();
				}
			}
		}
		
		return product_controller;
	}
	
	public List getProductList() {
		return new ProductDAO().getProductList();
	}
}
