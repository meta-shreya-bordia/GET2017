/**
 * SoapWebServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package DefaultNamespace;

public class SoapWebServiceServiceLocator extends org.apache.axis.client.Service implements DefaultNamespace.SoapWebServiceService {

    public SoapWebServiceServiceLocator() {
    }


    public SoapWebServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SoapWebServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SoapWebService
    private java.lang.String SoapWebService_address = "http://localhost:8081/WebService1/services/SoapWebService";

    public java.lang.String getSoapWebServiceAddress() {
        return SoapWebService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SoapWebServiceWSDDServiceName = "SoapWebService";

    public java.lang.String getSoapWebServiceWSDDServiceName() {
        return SoapWebServiceWSDDServiceName;
    }

    public void setSoapWebServiceWSDDServiceName(java.lang.String name) {
        SoapWebServiceWSDDServiceName = name;
    }

    public DefaultNamespace.SoapWebService getSoapWebService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SoapWebService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSoapWebService(endpoint);
    }

    public DefaultNamespace.SoapWebService getSoapWebService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            DefaultNamespace.SoapWebServiceSoapBindingStub _stub = new DefaultNamespace.SoapWebServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getSoapWebServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSoapWebServiceEndpointAddress(java.lang.String address) {
        SoapWebService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (DefaultNamespace.SoapWebService.class.isAssignableFrom(serviceEndpointInterface)) {
                DefaultNamespace.SoapWebServiceSoapBindingStub _stub = new DefaultNamespace.SoapWebServiceSoapBindingStub(new java.net.URL(SoapWebService_address), this);
                _stub.setPortName(getSoapWebServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SoapWebService".equals(inputPortName)) {
            return getSoapWebService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://DefaultNamespace", "SoapWebServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://DefaultNamespace", "SoapWebService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SoapWebService".equals(portName)) {
            setSoapWebServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
