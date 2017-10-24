package com.metacube.shoppingcart.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;




import org.springframework.stereotype.Service;



import com.metacube.shoppingcart.dao.product.ProductDao;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Product;

@Service("productService")
@Transactional
public class DefaultProductService implements ProductService {

	@Resource(name = "hibernateProductDao")
	ProductDao productDao;

	public ProductDao getProductDao()
	{
		return productDao;
	}

	public void setProductDao(final ProductDao productDao)
	{
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
	public Status deleteProduct(int id) {
		// TODO Auto-generated method stub
		System.out.println("in delete dao");
		return productDao.delete(id);
	}

	@Override
	public Status addProduct(Product entity) {
		// TODO Auto-generated method stub
		return productDao.save(entity);
	}

	

	@Override
	public Status editProduct(Product entity, int id) {
		// TODO Auto-generated method stub
		return productDao.save(entity);
	}

	

}
