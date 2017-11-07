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
	public History[] getHistoryAsCustomer(int id);

	/*
		Mengeluarkan semua history dimana user dengan id id merupakan driver;
	*/
	@WebMethod
	public History[] getHistoryAsDriver(int id);

	/*
		Menyembunyikan history sebagai driver
	*/
	@WebMethod
	public boolean hideHistoryAsDriver(int id);	

	/*
		Menyembunyikan history sebagai customer
	*/
	@WebMethod
	public boolean hideHistoryAsCustomer(int id);	
}