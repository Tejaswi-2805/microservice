package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Address;
import com.example.demo.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@GetMapping("/{addressId}")
	Optional<Address> getAddressById(@PathVariable int addressId) {
		Optional<Address> address=addressService.searchCustomerAddress(addressId);
		return address;
	}
	
	@PostMapping("/addCustomerAddess")
	Address addCustomerAddress(@RequestBody Address address) {
		Address a=addressService.addCustomerAddress(address);
		return a;
	}
	
	@PutMapping("/updateAddress/{addressId}")
	ResponseEntity<Address> updateAddress(@PathVariable int addressId, @RequestBody Address updatedAddress) {
		Address address=addressService.updateCustomerAddress(addressId, updatedAddress);
		return ResponseEntity.ok(address);
	}
	@DeleteMapping("/deleteAddress/{addressId}")
	public ResponseEntity<Void> deleteAddress(@PathVariable int addressId) {
		addressService.deleteCustomerAddress(addressId);
		return ResponseEntity.ok().build();
	}
}
