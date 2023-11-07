package com.example.demo.service;

import java.util.Optional;

import com.example.demo.model.Address;


public interface AddressService {
	
	public Address addCustomerAddress(Address address);
	Address updateCustomerAddress(int addressId, Address address);
	Optional<Address> searchCustomerAddress(int addressId);
	void deleteCustomerAddress(int addressId);
}
