package com.metacube.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metacube.shoppingcart.dto.ProductDto;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.facade.ProductFacade;
import com.metacube.shoppingcart.modal.Product;

/**
 * ClassName   : ProductController
 * @author     : Vaishali Jain
 * Description : Controller class of the project
 *               Decide what action to perform on the basis of the path
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	// The product facade. //
	@Autowired
	ProductFacade productFacade;
	
	//request to display product list
	@RequestMapping(value="/list", produces ="application/json")
	public @ResponseBody Iterable<Product> getProducts() {

		return productFacade.getAllProducts();

	}

	//request to display product on the basis of product id 
	@RequestMapping(value="/get/{id}" , produces="application/json")
	public @ResponseBody ProductDto getProductById(@PathVariable("id") int id) {
		return productFacade.getProductById(id);
	}
	
	//request to delete product on the basis of product id
	@RequestMapping(value="/delete/{id}" , produces="application/json")
	public @ResponseBody Status deleteProductById(@PathVariable("id") int id){
		return productFacade.deleteProduct(id);
	}


	//request to add product
	@RequestMapping(value="/add")
	public @ResponseBody Status addProduct(@RequestBody Product product) {
		return productFacade.addProduct(product);
	}
	
	//request to edit product
	@RequestMapping(value="/edit/{id}")
	public @ResponseBody Status editProduct( @RequestBody Product product,@PathVariable("id") int id) {
		System.out.println("in controller");
		return productFacade.editProduct(product,id);
	}
	
}
