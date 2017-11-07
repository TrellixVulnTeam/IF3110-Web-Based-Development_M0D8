/**
 * HistoryService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.services;

public interface HistoryService extends java.rmi.Remote {
    public boolean hideHistoryAsDriver(int arg0) throws java.rmi.RemoteException;
    public boolean hideHistoryAsCustomer(int arg0) throws java.rmi.RemoteException;
    public com.services.ArrayList getHistoryAsDriver(int arg0) throws java.rmi.RemoteException;
    public com.services.ArrayList getHistoryAsCustomer(int arg0) throws java.rmi.RemoteException;
}
