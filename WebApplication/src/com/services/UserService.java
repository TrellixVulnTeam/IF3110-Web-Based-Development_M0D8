/**
 * UserService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.services;

public interface UserService extends java.rmi.Remote {
    public com.services.ArrayList loadPreferredLocations(com.services.User arg0) throws java.rmi.RemoteException;
    public boolean saveUser(com.services.User arg0) throws java.rmi.RemoteException;
    public com.services.User getUserById(int arg0) throws java.rmi.RemoteException;
    public com.services.User getUserByToken(java.lang.String arg0) throws java.rmi.RemoteException;
}
