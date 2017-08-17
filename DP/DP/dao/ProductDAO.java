package dao;

import java.util.*;
import enums.Constants;
import model.Product;

public class ProductDAO implements BaseDAO{

	private static List<Product> product_list = new ArrayList<Product>();

	/**Read from FileProductDAO and make List of products
	 *	store count of all available product codes and their prices
	 **/
	public ProductDAO() {
		// must be changed when connected with DB
		List<String> products_available = FileProductDAO.readProductList(Constants.ProductListFile);

		for (String product_details : products_available) {
			product_list.add(new Product(product_details));
		}
	}
	
	public List<Product> getProductList() {
		return product_list;
	}
}
