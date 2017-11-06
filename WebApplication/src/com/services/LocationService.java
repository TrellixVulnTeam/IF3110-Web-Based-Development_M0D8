/**
 * LocationService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.services;

public interface LocationService extends java.rmi.Remote {
    public com.services.ArrayList getLocation(int arg0) throws java.rmi.RemoteException;
    public boolean updateLocation(com.services.Location arg0, com.services.Location arg1) throws java.rmi.RemoteException;
}
