package com.services;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.models.History;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface HistoryService {

	/*
		Mengeluarkan semua history dimana user dengan id id merupakan customer;
	*/
	@WebMethod
	public History[] getHistoryAsCustomer(String token, int id) throws TokenException;;

	/*
		Mengeluarkan semua history dimana user dengan id id merupakan driver;
	*/
	@WebMethod
	public History[] getHistoryAsDriver(String token, int id) throws TokenException;;

	/*
		Menyembunyikan history sebagai driver
	*/
	@WebMethod
	public boolean hideHistoryAsDriver(String token, int id) throws TokenException;	

	/*
		Menyembunyikan history sebagai customer
	*/
	@WebMethod
	public boolean hideHistoryAsCustomer(String token, int id) throws TokenException;
	
	/*
		Menyimpan history baru
	*/
	@WebMethod
	public boolean createHistory(String token, History history) throws TokenException;;
	
	/*
		Melakukan update rating dan vote pada driver setelah satu order
	*/
	@WebMethod
	public boolean updateCustomer(String token, int id, History history) throws TokenException;;
}