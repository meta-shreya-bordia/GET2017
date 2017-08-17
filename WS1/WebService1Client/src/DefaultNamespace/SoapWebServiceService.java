/**
 * SoapWebServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package DefaultNamespace;

public interface SoapWebServiceService extends javax.xml.rpc.Service {
    public java.lang.String getSoapWebServiceAddress();

    public DefaultNamespace.SoapWebService getSoapWebService() throws javax.xml.rpc.ServiceException;

    public DefaultNamespace.SoapWebService getSoapWebService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
