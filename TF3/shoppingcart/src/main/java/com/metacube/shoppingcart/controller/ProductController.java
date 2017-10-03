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
 * The Class ProductController.
 * 
 * This class use is responsible to direct the service on right page
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	/** The product facade. */
	@Autowired
	ProductFacade productFacade;

	@RequestMapping(value="/list", produces ="application/json")
	public @ResponseBody Iterable<ProductDto> getProducts() {

		return productFacade.getAllProducts();

	}

	
	@RequestMapping(value="/get/{id}" , produces="application/json")
	public @ResponseBody ProductDto getProductById(@PathVariable("id") int id) {
		return productFacade.getProductById(id);
	}

	@RequestMapping(value="/delete/{id}" , produces="application/json")
	public @ResponseBody Status deleteProductById(@PathVariable("id") int id){
		return productFacade.deleteProduct(id);
	}

	/*@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)*/
	
	@RequestMapping(value="/add")
	public @ResponseBody Status addProduct(@RequestBody Product product) {
		return productFacade.addProduct(product);
	}
	
	/*@PUT
	@Path("/edit/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)*/
	
	@RequestMapping(value="/edit/{id}")
	public @ResponseBody Status editProduct( @RequestBody Product product,@PathVariable("id") int id) {
		return productFacade.editProduct(product,id);
	}
	
}
