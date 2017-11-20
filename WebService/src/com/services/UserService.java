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
	public User getUser(String token, int id) throws TokenException;
	
	/*
		Mengeluarkan user yang memiliki token yang sama dengan parameter
	*/
	@WebMethod
	public User getUserByToken(String token) throws TokenException;
	
	/*
		Mengeluarkan user yang memiliki username yang sama dengan parameter dan preferred location yang sesuai
	*/
	@WebMethod
	public User getPreferredDriver(String token, String username, String pickup, String dest) throws TokenException;
	
	/*
		Mengeluarkan user yang memiliki username yang sama dengan parameter dan preferred location yang sesuai
	*/
	@WebMethod
	public User[] getDriver(String token, String pickup, String dest) throws TokenException;
	
	/*
	 * Mendapatkan preferred location dari database dan mengeluarkannya.
	 */
	@WebMethod
	public ArrayList<Location> loadPreferredLocations(String token, User user) throws TokenException;


	@WebMethod
	public boolean saveUser(String token, User user) throws TokenException;
	
	@WebMethod
	public int createUser(String token, User user) throws TokenException;
}