package com.Boardimak.main.repository;


import org.springframework.data.repository.CrudRepository;

import com.Boardimak.main.model.*;


public interface UserRepo extends CrudRepository<Buyer, Integer>{

	// custom method to get buyer using the email
	Buyer findAllByEmail(String email);
}
