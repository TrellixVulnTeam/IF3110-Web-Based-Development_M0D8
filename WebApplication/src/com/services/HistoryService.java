/**
 * HistoryService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.services;

public interface HistoryService extends java.rmi.Remote {
    public boolean hideHistoryAsCustomer(java.lang.String arg0, int arg1) throws java.rmi.RemoteException, com.services.TokenException;
    public com.services.History[] getHistoryAsDriver(java.lang.String arg0, int arg1) throws java.rmi.RemoteException, com.services.TokenException;
    public boolean hideHistoryAsDriver(java.lang.String arg0, int arg1) throws java.rmi.RemoteException, com.services.TokenException;
    public com.services.History[] getHistoryAsCustomer(java.lang.String arg0, int arg1) throws java.rmi.RemoteException, com.services.TokenException;
    public boolean createHistory(java.lang.String arg0, com.services.History arg1) throws java.rmi.RemoteException, com.services.TokenException;
    public boolean updateCustomer(java.lang.String arg0, int arg1, com.services.History arg2) throws java.rmi.RemoteException, com.services.TokenException;
}
