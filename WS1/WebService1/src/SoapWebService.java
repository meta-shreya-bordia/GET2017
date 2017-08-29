
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class SoapWebService {

	@WebMethod
	public double convertFahrenheitToCelsius(double temperature){
		return (((temperature - 32) * 5/9));
	}
}
