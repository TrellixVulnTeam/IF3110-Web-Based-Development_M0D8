package com.services;

public class HistoryServiceProxy implements com.services.HistoryService {
  private String _endpoint = null;
  private com.services.HistoryService historyService = null;
  
  public HistoryServiceProxy() {
    _initHistoryServiceProxy();
  }
  
  public HistoryServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initHistoryServiceProxy();
  }
  
  private void _initHistoryServiceProxy() {
    try {
      historyService = (new com.services.HistoryServiceImplServiceLocator()).getHistoryServiceImplPort();
      if (historyService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)historyService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)historyService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (historyService != null)
      ((javax.xml.rpc.Stub)historyService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.services.HistoryService getHistoryService() {
    if (historyService == null)
      _initHistoryServiceProxy();
    return historyService;
  }
  
  public boolean hideHistoryAsDriver(int arg0) throws java.rmi.RemoteException{
    if (historyService == null)
      _initHistoryServiceProxy();
    return historyService.hideHistoryAsDriver(arg0);
  }
  
  public boolean hideHistoryAsCustomer(int arg0) throws java.rmi.RemoteException{
    if (historyService == null)
      _initHistoryServiceProxy();
    return historyService.hideHistoryAsCustomer(arg0);
  }
  
  public com.services.ArrayList getHistoryAsDriver(int arg0) throws java.rmi.RemoteException{
    if (historyService == null)
      _initHistoryServiceProxy();
    return historyService.getHistoryAsDriver(arg0);
  }
  
  public com.services.ArrayList getHistoryAsCustomer(int arg0) throws java.rmi.RemoteException{
    if (historyService == null)
      _initHistoryServiceProxy();
    return historyService.getHistoryAsCustomer(arg0);
  }
  
  
}