package com.Boardimak.main.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Boardimak.main.model.Property;


public interface PropertyRepository extends JpaRepository<Property, Integer> {
	
	Property findAllById(int id);

}
