package factory;

import dao.*;
import enums.DBType;

public class DAOFactory {
	public static BaseDAO getInstance(DBType entity_type){
		switch(entity_type){
			case Product:
				return new ProductDAO();
			case Cart:
				return new CartDAO();
			default:
				return null;
		}
	}
}
