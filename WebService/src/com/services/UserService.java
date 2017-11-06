package com.services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.models.User;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface UserService {

	/*
		Mengeluarkan user yang memiliki id yang sama dengan parameter
	*/
	@WebMethod
	public User getUser(int id);
	
	/*
	 * Mendapatkan preferred location dari database dan mengeluarkannya.
	 */
	@WebMethod
	public void loadPreferredLocations(User user);
}