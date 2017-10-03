package com.metacube.shoppingcart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.shoppingcart.dao.product.ProductDao;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Product;

@Component("productService")
public class DefaultProductService implements ProductService {

	ProductDao productDao;
	
	@Autowired
	public DefaultProductService(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public Iterable<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return productDao.findOne(id);
	}

	@Override
	public Status addProduct(Product entity) {
		// TODO Auto-generated method stub
		return productDao.save(entity);
	}

	@Override
	public Status deleteProduct(int id) {
		// TODO Auto-generated method stub
		return productDao.delete(id);
	}

	@Override
	public Status editProduct(Product entity,int id) {
		// TODO Auto-generated method stub
		return productDao.edit(entity,id);
	}

}
