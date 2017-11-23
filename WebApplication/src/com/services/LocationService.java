/**
 * LocationService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.services;

public interface LocationService extends java.rmi.Remote {
    public com.services.ArrayList getLocation(java.lang.String arg0, int arg1) throws java.rmi.RemoteException, com.services.TokenException;
    public boolean insertLocation(java.lang.String arg0, int arg1, com.services.Location arg2) throws java.rmi.RemoteException, com.services.TokenException;
    public boolean updateLocation(java.lang.String arg0, int arg1, com.services.Location arg2, com.services.Location arg3) throws java.rmi.RemoteException, com.services.TokenException;
    public boolean deleteLocation(java.lang.String arg0, int arg1, com.services.Location arg2) throws java.rmi.RemoteException, com.services.TokenException;
}
