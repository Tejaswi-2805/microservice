package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.LineItem;

@Repository
public interface LineItemRepositoy extends JpaRepository<LineItem, Integer>{

}
