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
	public ArrayList<Location> getLocation(int id);

	@WebMethod
	public boolean updateLocation(Location oldLoc, Location newLoc);
}