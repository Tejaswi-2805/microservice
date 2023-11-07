package com.example.shoppingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shoppingservice.model.Address;


@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
