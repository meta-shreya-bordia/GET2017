package DefaultNamespace;
import java.rmi.RemoteException;
import java.util.Scanner;

import javax.xml.rpc.ServiceException;
public class Controller {
	public Double convert(double temperture) {
		Double result = null;
		SoapWebServiceServiceLocator wsServerServiceLocator = new SoapWebServiceServiceLocator();
		wsServerServiceLocator.setSoapWebServiceEndpointAddress("http://localhost:8081/WebService1/services/SoapWebService");

		SoapWebService wsServer;
		try {
			wsServer = wsServerServiceLocator.getSoapWebService();
			result = wsServer.convertFahrenheitToCelsius(temperture);

		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	/**
	 * @param temp	:	temperature value given by user
	 * @return		:	true/false
	 * Description	:	check whether the temperature given by user is valid or not. 
	 */
	public static boolean isValidTemperature(String temp){
		try{
			double temperature=Double.parseDouble(temp);
			return true;
			
		}catch(NumberFormatException e){
			return false;
		}
	}
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		Controller converter=new Controller();
		System.out.println("Enter temperature in fahrenheit");
		String temp=scanner.next();
		
		//checking for valid temperature.
		while(!isValidTemperature(temp)){
			System.out.println("Enter a valid temperature");
			temp=scanner.next();
		}
		
		//converting value from fahrenheit to celcius by calling convert function. 
		System.out.println("Temperature in celcius is: "+converter.convert(Double.parseDouble(temp)));
	}
}

