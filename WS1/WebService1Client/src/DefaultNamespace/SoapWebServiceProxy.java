package DefaultNamespace;

public class SoapWebServiceProxy implements DefaultNamespace.SoapWebService {
  private String _endpoint = null;
  private DefaultNamespace.SoapWebService soapWebService = null;
  
  public SoapWebServiceProxy() {
    _initSoapWebServiceProxy();
  }
  
  public SoapWebServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initSoapWebServiceProxy();
  }
  
  private void _initSoapWebServiceProxy() {
    try {
      soapWebService = (new DefaultNamespace.SoapWebServiceServiceLocator()).getSoapWebService();
      if (soapWebService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)soapWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)soapWebService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (soapWebService != null)
      ((javax.xml.rpc.Stub)soapWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public DefaultNamespace.SoapWebService getSoapWebService() {
    if (soapWebService == null)
      _initSoapWebServiceProxy();
    return soapWebService;
  }
  
  public double convertFahrenheitToCelsius(double temperature) throws java.rmi.RemoteException{
    if (soapWebService == null)
      _initSoapWebServiceProxy();
    return soapWebService.convertFahrenheitToCelsius(temperature);
  }
  
  
}