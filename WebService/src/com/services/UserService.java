package com.services;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.models.Location;
import com.models.User;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface UserService {

	/*
		Mengeluarkan user yang memiliki id yang sama dengan parameter
	*/
	@WebMethod
	public User getUserById(int id);
	
	/*
		Mengeluarkan user yang memiliki token yang sama dengan parameter
	*/
	@WebMethod
	public User getUserByToken(String token);
	
	/*
		Mengeluarkan user yang memiliki username yang sama dengan parameter
	*/
	@WebMethod
	public User getPreferredDriver(String username, String pickup, String dest);
	
	/*
	 * Mendapatkan preferred location dari database dan mengeluarkannya.
	 */
	@WebMethod
	public ArrayList<Location> loadPreferredLocations(User user);


	@WebMethod
	public boolean saveUser(User user);
}