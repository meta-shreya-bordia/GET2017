package dao;

import java.io.*;
import java.util.*;
import model.Product;

/**@Class	FileProductDAO
 * When data access is of file type
 * Get product details from enums.Constants.ProductListFile
 **/
class FileProductDAO{
	/**@Method	readProductList
	 * read from file list of all available products
	 * */
	public static List<String> readProductList(String file_name){
		BufferedReader reader = null;
		String file_read = null;
		List<String> lines = new ArrayList<String>();
		
		try {
			reader = new BufferedReader(new FileReader(new File(file_name)));
			
			while( (file_read = reader.readLine()) != null) {
				lines.add(file_read);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(reader != null)
					reader.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		return lines;
	}
	
	public void addProductToList(Product product, String file_name) {
		BufferedWriter writer = null;
		
		try{
			writer = new BufferedWriter(new FileWriter(new File(file_name)));
			writer.write(product.getProductCode()+","+product.getProductName()+","+ product.getProductPrice());
			writer.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
	}
}
