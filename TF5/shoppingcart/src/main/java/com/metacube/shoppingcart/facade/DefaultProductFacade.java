package com.metacube.shoppingcart.facade;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.metacube.shoppingcart.dto.ProductDto;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Product;
import com.metacube.shoppingcart.service.ProductService;

/**
 * ClassName  : DefaultProductFacade
 * @author    : Vaishali Jain
 * Description: Class performing business logic
 */
@Component("productFacade")
public class DefaultProductFacade implements ProductFacade {
	
	@Autowired
	ProductService productService;
	
	//default constructor
	public DefaultProductFacade() {
		
	}
	
	public void setProductService(final ProductService productService)
	{
		this.productService = productService;
	}

	public ProductService getProductService()
	{
		return productService;
	}
	
	//paremeterize constructor
	public DefaultProductFacade(ProductService productService) {
		this.productService = productService;
	}
	
	//calls product service get all products ,method
	@Override
	public Iterable<Product> getAllProducts() {
		return  productService.getAllProducts();
	}
	
	//calls product service get by id method
	@Override
	public ProductDto getProductById(int id) {
		// TODO Auto-generated method stub
		return modelToDto(productService.getProductById(id));
	}
	
	/**
	 * data transfer object to modal conversion
	 * @param productDto
	 * @return
	 */
	protected Product dtoToModel(ProductDto productDto) {
		if (productDto == null) {
			return null;
		}
		Product user = new Product();
		user.setId(productDto.getId());
		user.setName(productDto.getName());
		user.setPrice(productDto.getPrice());
		return user;
	}
	
	/**
	 * modal to data transfer object conversion
	 * @param product
	 * @return
	 */
	protected ProductDto modelToDto(Product product) {
		if (product == null) {
			return null;
		}
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setPrice(product.getPrice());
		return productDto;
	}

	@Override
	public Status addProduct(Product entity) {
		// TODO Auto-generated method stub
		return productService.addProduct(entity);
	}
	
	public Status deleteProduct(int id) {
		return  productService.deleteProduct(id);
	}

	@Override
	public Status editProduct(Product entity,int id) {
		// TODO Auto-generated method stub
		return productService.editProduct(entity,id);
	}
}
