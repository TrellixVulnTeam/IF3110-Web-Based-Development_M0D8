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
  
  public java.lang.String getValidation(java.lang.String arg0, int arg1) throws java.rmi.RemoteException{
    if (historyService == null)
      _initHistoryServiceProxy();
    return historyService.getValidation(arg0, arg1);
  }
  
  public boolean updateCustomer(java.lang.String arg0, int arg1, com.services.History arg2) throws java.rmi.RemoteException, com.services.TokenException{
    if (historyService == null)
      _initHistoryServiceProxy();
    return historyService.updateCustomer(arg0, arg1, arg2);
  }
  
  public boolean createHistory(java.lang.String arg0, com.services.History arg1, int arg2) throws java.rmi.RemoteException, com.services.TokenException{
    if (historyService == null)
      _initHistoryServiceProxy();
    return historyService.createHistory(arg0, arg1, arg2);
  }
  
  public com.services.History[] getHistoryAsCustomer(java.lang.String arg0, int arg1) throws java.rmi.RemoteException, com.services.TokenException{
    if (historyService == null)
      _initHistoryServiceProxy();
    return historyService.getHistoryAsCustomer(arg0, arg1);
  }
  
  public boolean hideHistoryAsDriver(java.lang.String arg0, int arg1) throws java.rmi.RemoteException, com.services.TokenException{
    if (historyService == null)
      _initHistoryServiceProxy();
    return historyService.hideHistoryAsDriver(arg0, arg1);
  }
  
  public boolean hideHistoryAsCustomer(java.lang.String arg0, int arg1) throws java.rmi.RemoteException, com.services.TokenException{
    if (historyService == null)
      _initHistoryServiceProxy();
    return historyService.hideHistoryAsCustomer(arg0, arg1);
  }
  
  public com.services.History[] getHistoryAsDriver(java.lang.String arg0, int arg1) throws java.rmi.RemoteException, com.services.TokenException{
    if (historyService == null)
      _initHistoryServiceProxy();
    return historyService.getHistoryAsDriver(arg0, arg1);
  }
  
  
}