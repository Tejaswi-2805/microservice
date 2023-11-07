package com.example.shoppingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shoppingservice.model.CustomerCart;

@Repository
public interface CustomerCartRepository extends JpaRepository<CustomerCart, Integer>{
	
//	CustomerCart findByCustomerId(int customerId);

}
