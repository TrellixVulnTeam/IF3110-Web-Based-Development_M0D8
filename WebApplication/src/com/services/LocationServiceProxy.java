package com.services;

public class LocationServiceProxy implements com.services.LocationService {
  private String _endpoint = null;
  private com.services.LocationService locationService = null;
  
  public LocationServiceProxy() {
    _initLocationServiceProxy();
  }
  
  public LocationServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initLocationServiceProxy();
  }
  
  private void _initLocationServiceProxy() {
    try {
      locationService = (new com.services.LocationServiceImplServiceLocator()).getLocationServiceImplPort();
      if (locationService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)locationService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)locationService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (locationService != null)
      ((javax.xml.rpc.Stub)locationService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.services.LocationService getLocationService() {
    if (locationService == null)
      _initLocationServiceProxy();
    return locationService;
  }
  
  public com.services.ArrayList getLocation(java.lang.String arg0, int arg1) throws java.rmi.RemoteException, com.services.TokenException{
    if (locationService == null)
      _initLocationServiceProxy();
    return locationService.getLocation(arg0, arg1);
  }
  
  public boolean insertLocation(java.lang.String arg0, int arg1, com.services.Location arg2) throws java.rmi.RemoteException, com.services.TokenException{
    if (locationService == null)
      _initLocationServiceProxy();
    return locationService.insertLocation(arg0, arg1, arg2);
  }
  
  public boolean updateLocation(java.lang.String arg0, int arg1, com.services.Location arg2, com.services.Location arg3) throws java.rmi.RemoteException, com.services.TokenException{
    if (locationService == null)
      _initLocationServiceProxy();
    return locationService.updateLocation(arg0, arg1, arg2, arg3);
  }
  
  public boolean deleteLocation(java.lang.String arg0, int arg1, com.services.Location arg2) throws java.rmi.RemoteException, com.services.TokenException{
    if (locationService == null)
      _initLocationServiceProxy();
    return locationService.deleteLocation(arg0, arg1, arg2);
  }
  
  
}