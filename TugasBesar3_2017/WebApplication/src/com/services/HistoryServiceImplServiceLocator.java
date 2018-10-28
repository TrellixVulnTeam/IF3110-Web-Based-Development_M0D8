/**
 * HistoryServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.services;

public class HistoryServiceImplServiceLocator extends org.apache.axis.client.Service implements com.services.HistoryServiceImplService {

    public HistoryServiceImplServiceLocator() {
    }


    public HistoryServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public HistoryServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for HistoryServiceImplPort
    private java.lang.String HistoryServiceImplPort_address = "http://localhost:8000/WebService/History";

    public java.lang.String getHistoryServiceImplPortAddress() {
        return HistoryServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String HistoryServiceImplPortWSDDServiceName = "HistoryServiceImplPort";

    public java.lang.String getHistoryServiceImplPortWSDDServiceName() {
        return HistoryServiceImplPortWSDDServiceName;
    }

    public void setHistoryServiceImplPortWSDDServiceName(java.lang.String name) {
        HistoryServiceImplPortWSDDServiceName = name;
    }

    public com.services.HistoryService getHistoryServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(HistoryServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHistoryServiceImplPort(endpoint);
    }

    public com.services.HistoryService getHistoryServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.services.HistoryServiceImplPortBindingStub _stub = new com.services.HistoryServiceImplPortBindingStub(portAddress, this);
            _stub.setPortName(getHistoryServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHistoryServiceImplPortEndpointAddress(java.lang.String address) {
        HistoryServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.services.HistoryService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.services.HistoryServiceImplPortBindingStub _stub = new com.services.HistoryServiceImplPortBindingStub(new java.net.URL(HistoryServiceImplPort_address), this);
                _stub.setPortName(getHistoryServiceImplPortWSDDServiceName());
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
        if ("HistoryServiceImplPort".equals(inputPortName)) {
            return getHistoryServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://services.com/", "HistoryServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://services.com/", "HistoryServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("HistoryServiceImplPort".equals(portName)) {
            setHistoryServiceImplPortEndpointAddress(address);
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
