package com.services;

public class UserServiceProxy implements com.services.UserService {
  private String _endpoint = null;
  private com.services.UserService userService = null;
  
  public UserServiceProxy() {
    _initUserServiceProxy();
  }
  
  public UserServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initUserServiceProxy();
  }
  
  private void _initUserServiceProxy() {
    try {
      userService = (new com.services.UserServiceImplServiceLocator()).getUserServiceImplPort();
      if (userService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)userService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)userService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (userService != null)
      ((javax.xml.rpc.Stub)userService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.services.UserService getUserService() {
    if (userService == null)
      _initUserServiceProxy();
    return userService;
  }
  
  public com.services.User getPreferredDriver(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws java.rmi.RemoteException{
    if (userService == null)
      _initUserServiceProxy();
    return userService.getPreferredDriver(arg0, arg1, arg2);
  }
  
  public com.services.ArrayList loadPreferredLocations(com.services.User arg0) throws java.rmi.RemoteException{
    if (userService == null)
      _initUserServiceProxy();
    return userService.loadPreferredLocations(arg0);
  }
  
  public boolean saveUser(com.services.User arg0) throws java.rmi.RemoteException{
    if (userService == null)
      _initUserServiceProxy();
    return userService.saveUser(arg0);
  }
  
  public com.services.User getUser(int arg0) throws java.rmi.RemoteException{
    if (userService == null)
      _initUserServiceProxy();
    return userService.getUser(arg0);
  }
  
  
}