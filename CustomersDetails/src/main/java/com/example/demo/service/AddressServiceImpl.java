package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Address;
import com.example.demo.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	AddressRepository addressRepository;

	@Override
	public Optional<Address> searchCustomerAddress(int addressId) {
		Optional<Address> address=addressRepository.findById(addressId);
		return address;
	}
	
	@Override
	public Address addCustomerAddress(Address address) {
		Address a=addressRepository.save(address);
		return a;
	}

	@Override
	public Address updateCustomerAddress(int addressId, Address address) {
		// TODO Auto-generated method stub
		Address a1= addressRepository.findById(addressId).get();
		a1.setDoorNo(address.getDoorNo());
		a1.setStreetName(address.getStreetName());
		a1.setLayout(address.getLayout());
		a1.setCity(address.getCity());
		a1.setPincode(address.getPincode());
		addressRepository.save(a1);
		return a1;
	}
	@Override
	public void deleteCustomerAddress(int addressId) {
		if(addressRepository.existsById(addressId)) {
			addressRepository.deleteById(addressId);
		}
	}

}
