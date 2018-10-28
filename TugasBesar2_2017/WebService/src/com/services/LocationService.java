package com.services;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.models.Location;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface LocationService {

	/*
		Mengeluarkan user yang memiliki id yang sama dengan parameter
	*/
	@WebMethod
	public ArrayList<Location> getLocation(String token, int id) throws TokenException;

	@WebMethod
	public boolean updateLocation(String token, int id, Location oldLoc, Location newLoc) throws TokenException;
	
	@WebMethod
	public boolean deleteLocation(String token, int id, Location loc) throws TokenException;
	
	@WebMethod
	public boolean insertLocation(String token, int id, Location loc) throws TokenException;
}