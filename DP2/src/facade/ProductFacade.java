package facade;

import model.Product;
import dao.*;

/**@Class	ProductFacade
 * check valid new product detail before adding (DAO in-memory access)
 * add new product to ProductList.csv (DAO write)
 * if product id does not already exist
 **/
public class ProductFacade {
	private static ProductDAO product_list;
	private static ProductFacade product_facade = null;
	
	private ProductFacade() {
		product_list = new ProductDAO();
	}
	
	public static ProductFacade getInstance(){
		if(product_facade == null){
			synchronized(ProductFacade.class) {
				if(product_facade == null){
					product_facade = new ProductFacade();
				}
			}
		}
		return product_facade;
	}
	
	public boolean isProductListEmpty(){
		return (product_list == null || product_list.getProductList() == null || product_list.getProductList().size() <=0);
	}
	
	//get in-memory DAO object containing product list
	public boolean checkValidProductCode(int product_code) {
		if(!isProductListEmpty()){
			for(Product product_item : product_list.getProductList() ){
				if(product_item.getProductCode() == product_code){
					return true;
				}
			}
		}
		return false;
	}
	
	public void addProductToDB(Product product) {
		//pass to DAO
	}
	
	public Product getProduct(int product_code){
		if(!isProductListEmpty()){
			for(Product product_item : product_list.getProductList() ){
				if(product_item.getProductCode() == product_code){
					return product_item;
				}
			}
		}
		return null;
	}
}
