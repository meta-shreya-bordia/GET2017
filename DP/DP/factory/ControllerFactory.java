package factory;

import enums.DBType;
import controller.*;

public class ControllerFactory {
	public static  IBaseController getInstance(DBType entity_type){
		switch(entity_type){
			case Product:
				return ProductController.getInstance();
			case Cart:
				return CartController.getInstance();
			case UserInput:
				return UserInputValidation.getInstance();
			default:
				return BaseController.getInstance();
		}
	}
}
